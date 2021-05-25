package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Municipality;
import model.Residency;
import model.Resident;

public class ResidencyDB {
	

	private static final String FIND_BY_ID = "select * from Residency where FKresidentId = ?";
	private PreparedStatement findResidencyByResidentIdPS;
	
	public ResidencyDB() throws SQLException {
		
		Connection con = DBConnection.getInstance().getConnection();
		findResidencyByResidentIdPS = con.prepareStatement(FIND_BY_ID);
	}
	
	
	public Residency findResidency(int id) throws DataAccessException {
		
		
		try {
			findResidencyByResidentIdPS.setInt(1, id);
			ResultSet rs = findResidencyByResidentIdPS.executeQuery();
			Residency res = buildResidencyObject(rs); 
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Residency", s);
		}
		
	
	}
	
	private Residency buildResidencyObject(ResultSet rs) throws SQLException, DataAccessException {			

		Residency residency = null;
		MunicipalityDB munDB = new MunicipalityDB();
		ResidentDB resDB = new ResidentDB();

		try {
			residency = new Residency(rs.getInt("id"), rs.getDate("fromDate"), rs.getDate("toDate"), munDB.findMunicipality(rs.getInt("FKmunicipalityId")), resDB.findResidentById(rs.getInt("FKresidentId")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return residency;
	}


}
