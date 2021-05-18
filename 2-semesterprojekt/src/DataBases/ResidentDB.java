package DataBases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Resident;
import modelLayer.Customer;
import modelLayer.DBConnection;

public class ResidentDB {
	
	private static final String FIND_BY_ID = "select * from Customer where id = ?";
	private static final String FIND_BY_EMAIL = "select * from Customer where email = ?";
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
			resident = new Resident(rs.getString("fName"), rs.getString("lName"), rs.getString("email"), rs.getString("phoneNo"), rs.getString("streetName"), rs.getInt("streetNo"), rs.getInt("FKlocationId"));
			resident.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resident;

	}

}