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

	/**
	 * This method executes the PreparedStatement
	 * "insert into Rental values (?, ?, ?, ?, ?, ?)"
	 * which inserts a Rental in the database
	 * @param rental a Rental object
	 * @throws Exception
	 */
	public void endRental(Rental rental) throws Exception {
	
		try {
			// START TRANSACTION
			DBConnection.getInstance().startTransaction();
			con.setTransactionIsolation(SQLServerConnection.TRANSACTION_REPEATABLE_READ);
			List<Rental> rentList = findRentalsByDateAndAssistiveDeviceInstanceId(rental.getAssistiveDeviceInstance().getId(),
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

	/**
	 * Returns a list of Rental objects
	 * This method executes the PreparedStatement
	 * "select * from Rental where (endDate > ? AND startDate < ?) AND (FKassistiveDeviceInstanceId = ?)"
	 * which selects all the rentals on the specific AssistiveDeviceInstance within the chosen timeperiod
	 * If there is a clash between dates and the user selected dates overlap an already existing 
	 * rental, the method will return values to the list. If there is no overlap and the 
	 * AssistiveDeviceInstance is free to rent in the chosen time period, the method will return an 
	 * empty list.
	 * 
	 * @param assistiveDeviceInstanceId
	 * @param startDate
	 * @param endDate
	 * @return List<Rental> List of rental objects
	 * @throws DataAccessException
	 */
	@Override
	public List<Rental> findRentalsByDateAndAssistiveDeviceInstanceId(int assistiveDeviceInstanceId, LocalDate startDate, LocalDate endDate) throws DataAccessException {
		try {
			checkRental.setDate(1, convertDate(startDate));
			checkRental.setDate(2, convertDate(endDate));
			checkRental.setInt(3, assistiveDeviceInstanceId);
			ResultSet rs = checkRental.executeQuery();
			List<Rental> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve data from Rental", e);
		}
	}

	/**
	 * Returns a list of Rental objects.
	 * This method loops through the ResultSet and builds a
	 * list of all objects returned in the ResultSet.
	 * 
	 * @param rs ResultSet 
	 * @return List<Rental> List of Rental objects
	 * @throws SQLException If a SQL exception occurred
	 */
	private List<Rental> buildObjects(ResultSet rs) throws SQLException {
		List<Rental> res = new ArrayList<>();
		while (rs.next()) {
			res.add(buildRentalObject(rs));
		}
		return res;
	}

	/**
	 * Returns a Rental object.
	 * This method builds a Rental object from the first result
	 * it finds from the ResultSet
	 * 
	 * @param rs ResultSet
	 * @return Rental object
	 */
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
