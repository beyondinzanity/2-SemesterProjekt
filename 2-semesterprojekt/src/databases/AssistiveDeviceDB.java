package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AssistiveDevice;

public class AssistiveDeviceDB implements IAssistiveDeviceDB {
	private AssistiveDeviceInstanceDB assistiveDeviceInstanceDB;
	private static final String FIND_BY_DEVICE_NAME = "select * from AssistiveDevice where name like ? or hmiNumber like ?";
	private PreparedStatement findAssistiveDevicesByNamePS;

	public AssistiveDeviceDB() throws DataAccessException, SQLException {

		Connection con = DBConnection.getInstance().getConnection();

		findAssistiveDevicesByNamePS = con.prepareStatement(FIND_BY_DEVICE_NAME);

	}
	
	/**
	 * Returns a list of AssistiveDevice objects
	 * This method executes the PreparedStatent in the SQL database
	 * "select * from AssistiveDevice where name like ? or hmiNumber like ?"
	 * and searches the database for AssistiveDevices.
	 * The questionmarks are replaced by whatever input the user enters
	 * @param userSearch is the input from the user
	 * @return List of AssistiveDevice objects
	 */
	@Override
	public List<AssistiveDevice> findAssistiveDevices(String userSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		userSearch = "%" + userSearch + "%";
		try {
			findAssistiveDevicesByNamePS.setString(1, userSearch);
			findAssistiveDevicesByNamePS.setString(2, userSearch);
			ResultSet rs = findAssistiveDevicesByNamePS.executeQuery();
			List<AssistiveDevice> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not retrieve data from AssistiveDevice", e);
		}
	}
	
	/**
	 * Returns a list of AssistiveDevice objects
	 * This method loops through the ResultSet and builds a 
	 * list of all objects returned in the ResultSet
	 * 
	 * @param rs ResultSet
	 * @return	List of AssistiveDevice objects
	 * @throws SQLException If a SQL exception occurred
	 * @throws DataAccessException If a data access exception occurred
	 */
	private List<AssistiveDevice> buildObjects(ResultSet rs) throws SQLException, DataAccessException {
		List<AssistiveDevice> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildAssistiveDeviceObject(rs));
		}
		return res;
	}  
	
	/**
	 * Returns a list of AssistiveDevice objects
	 * This method builds an AssistiveDeviceInstance from the first result
	 * it finds from the ResultSet
	 * 
	 * @param rs ResultSet
	 * @return AssistiveDevice
	 * @throws DataAccessException If a data access exception occurred
	 * @throws SQLException If a SQL exception occurred
	 */
	private AssistiveDevice buildAssistiveDeviceObject(ResultSet rs) throws DataAccessException, SQLException {
		AssistiveDevice assistiveDevice = null;
		assistiveDeviceInstanceDB = new AssistiveDeviceInstanceDB();
		
		try {
			assistiveDevice = new AssistiveDevice(rs.getInt("id"), rs.getInt("hmiNumber"), rs.getString("name"), rs.getString("type"));
			assistiveDevice.setDeviceInstanceList(assistiveDeviceInstanceDB.findInstancesByDeviceId(assistiveDevice.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assistiveDevice;
	}
	
}
