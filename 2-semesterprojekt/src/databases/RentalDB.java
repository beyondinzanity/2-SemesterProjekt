package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

import model.Rental;

public class RentalDB implements IRentalDB {
	private static final String INSERT_RENTAL = "insert into Rental values (?, ?, ?, ?, ?, ?)";
	private static final String CHECK_RENTAL_DATE = "select * from Rental where (endDate > ? AND startDate < ?) AND (FKassistiveDeviceInstanceId = ?)";
	private Connection con;
	private PreparedStatement insertRental;
	private PreparedStatement checkRental;

	public RentalDB() throws DataAccessException, SQLException {
		con = DBConnection.getInstance().getConnection();
		insertRental = con.prepareStatement(INSERT_RENTAL, PreparedStatement.RETURN_GENERATED_KEYS);
		checkRental = con.prepareStatement(CHECK_RENTAL_DATE);
	}

	public void checkRentalDate() {

	}

	public void endRental(Rental rental) throws Exception {
		System.out.println("RentalNr - " + rental.getRentalNumber());
		System.out.println("Start Date - " + convertDate(rental.getStartDate()));
		System.out.println("End Date - " + convertDate(rental.getEndDate()));
		System.out.println("Employee ID - " + rental.getEmployee().getEmployeeId());
		System.out.println("AssistiveDeviceInstance ID - " + rental.getAssistiveDeviceInstance().getId());
		System.out.println("Resident ID - " + rental.getResident().getResidentId());

		try {
			// START TRANSACTION
			DBConnection.getInstance().startTransaction();
			con.setTransactionIsolation(SQLServerConnection.TRANSACTION_REPEATABLE_READ);
			List<Rental> rentList = findRentalsByDateAndAssistiveDeviceId(rental.getAssistiveDeviceInstance().getId(),
					rental.getStartDate(), rental.getEndDate());

			if (rentList.size() == 0) {
				insertRental.setInt(1, rental.getRentalNumber());
				insertRental.setDate(2, convertDate(rental.getStartDate()));
				insertRental.setDate(3, convertDate(rental.getEndDate()));
				insertRental.setInt(4, rental.getEmployee().getEmployeeId());
				insertRental.setInt(5, rental.getAssistiveDeviceInstance().getId());
				insertRental.setInt(6, rental.getResident().getResidentId());

				rental.setRentalId(executeInsertWithIdentity(insertRental));

				// COMMIT TRANSACTION
				DBConnection.getInstance().commitTransaction();
			} else {
				String error = null;
				for (Rental list : rentList) {
					error += list.getRentalNumber() + ", " + list.getStartDate() + ", " + list.getEndDate() + "\n";
				}
				throw new Exception(error);
			}

			// END TRANSACTION
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			DBConnection.getInstance().rollbackTransaction(); // END

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			DBConnection.getInstance().rollbackTransaction(); // END

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			DBConnection.getInstance().rollbackTransaction(); // END

		}
	}

	/*
	 * Converts a LocalDate to a sqlDate
	 */
	public java.sql.Date convertDate(LocalDate date) {
		java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		return sqlDate;
	}

	public int executeInsertWithIdentity(PreparedStatement ps) throws Exception {
		// requires prepared statement to be created with the additional argument
		// PreparedStatement.RETURN_GENERATED_KEYS
		int res = -1;
		try {
			res = ps.executeUpdate();
			if (res > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new Exception("Could not execute insert", e);
		}
		return res;
	}

	@Override
	public List<Rental> findRentalsByDateAndAssistiveDeviceId(int assistiveDeviceId, LocalDate startDate,
			LocalDate endDate) throws DataAccessException {
		try {
			checkRental.setDate(1, convertDate(startDate));
			checkRental.setDate(2, convertDate(endDate));
			checkRental.setInt(3, assistiveDeviceId);
			ResultSet rs = checkRental.executeQuery();
			List<Rental> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve data from Rental", e);
		}
	}

	private List<Rental> buildObjects(ResultSet rs) throws SQLException {
		List<Rental> res = new ArrayList<>();
		while (rs.next()) {
			res.add(buildRentalObject(rs));
		}
		return res;
	}

	private Rental buildRentalObject(ResultSet rs) throws SQLException {
		Rental rental = null;
		try {
			rental = new Rental(rs.getInt("id"), rs.getInt("rentalNumber"), rs.getDate("startDate").toLocalDate(),
					(rs.getDate("endDate") != null ? rs.getDate("endDate").toLocalDate() : null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rental;
	}
}
