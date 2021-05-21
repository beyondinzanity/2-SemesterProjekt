package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.AssistiveDeviceInstance;
import model.ZipCity;

public class ZipCityDB {
	private static final String FIND_BY_ZIPCITY_ID = "select * from ZipCity where id = ?";
	private PreparedStatement findZipCityByIdPS;
	
	public ZipCityDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();

		findZipCityByIdPS = con.prepareStatement(FIND_BY_ZIPCITY_ID);
		
	}
	
	private ZipCity buildObject(ResultSet rs) {
		ZipCity city = null;

		try {
			city = new ZipCity(rs.getString("postalCode"), rs.getString("city"));
			city.setId(rs.getInt("id"));
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return city;
	}

	
	
	
	public ZipCity findZipCityById(int id) throws DataAccessException {
		
		ZipCity res =  null;
		
		try {
			findZipCityByIdPS.setInt(1, id);
			ResultSet rs = findZipCityByIdPS.executeQuery();
			
			if(rs.next()) {
				res = buildObject(rs);
			}
		
			
			
		} catch (SQLException s) {
			throw new DataAccessException("Could not retrieve data from ZipCity", s);
		}
	
		return res;
		
	}




		
	
	
	

}
