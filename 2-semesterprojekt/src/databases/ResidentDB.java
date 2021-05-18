package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Resident;
import databases.DBConnection;

public class ResidentDB {
	
	private static final String FIND_BY_ID = "select * from Customer where id = ?";
	private static final String FIND_BY_EMAIL = "select * from Resident where email = ?";
	private PreparedStatement findCustomerByIdPS;
	private PreparedStatement findCustomerByEmailPS;

	public ResidentDB() throws Exception {

		Connection con = DBConnection.getInstance().getConnection();

		findCustomerByIdPS = con.prepareStatement(FIND_BY_ID);
		findCustomerByEmailPS = con.prepareStatement(FIND_BY_EMAIL);

	}
	
	public Resident findCustomerByEmail(String email) throws Exception {
		Resident res = null;

		try {
			findCustomerByEmailPS.setString(1, email);
			ResultSet rs = findCustomerByEmailPS.executeQuery();

			if (rs.next()) {

				res = buildResidentObject(rs);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return res;

	}

	private Resident buildResidentObject(ResultSet rs) {
		Resident resident = null;

		try {
			resident = new Resident(rs.getString("ssn"), rs.getInt("apartmentNumber"), rs.getString("fname"), rs.getString("lname"), rs.getString("phoneNr"), rs.getString("email"), rs.getInt("FKaddressId"));
			resident.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resident;

	}

}
