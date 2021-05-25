package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Municipality;
import model.Residency;
import model.Resident;

public class ResidencyDB {
	private ResidentDB residentDB;
	private MunicipalityDB municipalityDB;
	private static final String FIND_BY_ID = "select * from Residency where FKresidentId = ?";
	private PreparedStatement findResidencyByResidentIdPS;
	
	public ResidencyDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findResidencyByResidentIdPS = con.prepareStatement(FIND_BY_ID);
	}
	
	
	public Residency findResidencyByResidentId(int id) throws DataAccessException {
		Residency residency = null;
		try {
			findResidencyByResidentIdPS.setInt(1, id);
			ResultSet rs = findResidencyByResidentIdPS.executeQuery();
			if(rs.next()) {
				residency = buildResidencyObject(rs); 				
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Residency", s);
		}
		return residency;
	}
	
	private Residency buildResidencyObject(ResultSet rs) throws DataAccessException, SQLException{			
		Residency residency = null;
		municipalityDB = new MunicipalityDB();
		residentDB = new ResidentDB();

		try {
			residency = new Residency(rs.getInt("id"), rs.getDate("fromDate").toLocalDate(), null);
			residency.setMunicipality(municipalityDB.findMunicipality(rs.getInt("FKmunicipalityId")));
			residency.setResident(residentDB.findResidentById(rs.getInt("FKresidentId")));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in buildObject ResidencyDB");
		}
		return residency;
	}


}
