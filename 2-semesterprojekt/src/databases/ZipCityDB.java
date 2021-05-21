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
	
	
	
	public ZipCity findZipCityById(int id) throws DataAccessException {
		
		try {
			findZipCityByIdPS.setInt(1, id);
			ResultSet rs = findZipCityByIdPS.executeQuery();
			ZipCity res = buildObject(rs);
			return res;
			
		} catch (SQLException s) {
			throw new DataAccessException("Could not retrieve data from ZipCity", s);
		}
	
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

		
	
	
	

}
