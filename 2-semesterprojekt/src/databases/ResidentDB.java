package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Resident;
import model.ZipCity;
import databases.DBConnection;

public class ResidentDB implements IResidentDB {
	
	private static final String FIND_BY_SSN = "select * from Resident where ssn = ?";
	private PreparedStatement findCustomerBySsnPS;

	public ResidentDB() throws DataAccessException, SQLException {
		
		

		Connection con = DBConnection.getInstance().getConnection();

		findCustomerBySsnPS = con.prepareStatement(FIND_BY_SSN);

	}
	

	private Resident buildResidentObject(ResultSet rs) throws SQLException, DataAccessException {
		
		
		Resident resident = null;
		
		
		ZipCityDB db = new ZipCityDB();
		ZipCity zipCity = db.findZipCityById(rs.getInt("FKZipCityId")); 
		
		
		
		

		try {
			resident = new Resident(rs.getString("fname"), rs.getString("lname"), rs.getString("ssn"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getInt("apartmentNumber"), rs.getString("streetName"), rs.getInt("houseNumber"), zipCity);
			resident.setId(rs.getInt("id")); 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resident;

	}

	@Override
	public Resident findResidentBySsn(int ssn) throws DataAccessException {
		Resident res = null;

		try {
			findCustomerBySsnPS.setInt(1, ssn);
			ResultSet rs = findCustomerBySsnPS.executeQuery();

			if (rs.next()) {

				res = buildResidentObject(rs);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return res;

	
	}

	@Override
	public Resident findResidentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
