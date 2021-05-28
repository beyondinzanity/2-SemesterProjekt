package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Residency;
import model.Resident;
import model.ZipCity;

public class ResidentDB implements IResidentDB {
	private static final String FIND_BY_SSN = "select * from Resident where ssn like ?";
	private static final String FIND_BY_ID = "select * from Resident where id = ?";
	private PreparedStatement findResidentBySsnPS;
	private PreparedStatement findResidentByIdPS;
	private ZipCityDB zipCityDB;
	private	ResidencyDB residencyDB;
	
	public ResidentDB() throws DataAccessException, SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findResidentBySsnPS = con.prepareStatement(FIND_BY_SSN);
		findResidentByIdPS = con.prepareStatement(FIND_BY_ID);
		zipCityDB = new ZipCityDB();
		residencyDB = new ResidencyDB();
	}

	/**
	 * Returns a Resident object
	 * This method builds a Resident object from the first result
	 * it finds from the ResultSet
	 * It builds the ResidentObject and adds a list containing residensies
	 * and a ZipCity object to the Resident.
	 * 
	 * @param rs ResultSet
	 * @return Resident
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	private Resident buildResidentObject(ResultSet rs) throws SQLException, DataAccessException {
		Resident resident = null;
		//ZipCity zipCity = zipCityDB.findZipCityById(rs.getInt("FKZipCityId"));
		
		try {
			 
			resident = new Resident(rs.getString("fname"), rs.getString("lname"), rs.getString("ssn"),
					rs.getString("phoneNumber"), rs.getString("email"), rs.getInt("apartmentNumber"),
					rs.getString("streetName"), rs.getInt("houseNumber"));
			
			resident.setId(rs.getInt("id"));
			resident.setZipCity(zipCityDB.findZipCityById(rs.getInt("FKZipCityId")));
			//Sets resident
			int someResidentId = resident.getResidentId();
			List<Residency> someList = residencyDB.findResidencyByResidentId(someResidentId);
			resident.setResidencyList(someList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resident;
	}

	private List<Resident> buildResidentObjects(ResultSet rs) throws SQLException, DataAccessException {
		List<Resident> res = new ArrayList<>();
		while (rs.next()) {
			res.add(buildResidentObject(rs));
		}
		return res;
	}

	/**
	 * Returns a list of resident objects
	 * This method executes the PreparedStatement
	 * "select * from Resident where ssn like ?"
	 * where it replaces the questionmark ("?") with the user input (ssn)
	 * and returns all Residents where it finds a ssn match in the database. 
	 * 
	 * @param ssn User input which the PreparedStatement uses to search the database
	 * @return List<Resident> List of resident objects
	 * @throws DataAccessException
	 */
	@Override
	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException {
		ssn = "%" + ssn + "%";
		try {
			findResidentBySsnPS.setString(1, ssn);
			ResultSet rs = findResidentBySsnPS.executeQuery();
			List<Resident> res = buildResidentObjects(rs);
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Resident", s);
		}
	}
	
	/**
	 * Returns a Resident object
	 * This method executes the PreparedStatement
	 * "select * from Resident where id = ?"
	 * where it replaces the questionmark ("?") with the user input (id)
	 * and returns the matching Residents from the database with that id. 
	 * @param id
	 * @return Resident
	 * @throws DataAccessException
	 */
	public Resident findResidentById(int id) throws DataAccessException {
		
		Resident res = null; 
		
		try {
			findResidentByIdPS.setInt(1, id);
			ResultSet rs = findResidentByIdPS.executeQuery();
			if(rs.next()) {
				res = buildResidentObject(rs);		
				
			}
		} catch (SQLException s) {
			throw new DataAccessException("Could not retrieve data from Resident", s);
		}
		
		return res;
	}

}













