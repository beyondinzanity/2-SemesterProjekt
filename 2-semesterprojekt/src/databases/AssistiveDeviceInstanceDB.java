package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AssistiveDeviceInstance;

public class AssistiveDeviceInstanceDB implements IAssistiveDeviceInstanceDB {

	private static final String FIND_BY_DEVICE_ID = "select * from AssistiveDeviceInstance where FKassistiveDeviceId = ?";
	private PreparedStatement findAssistiveDeviceInstanceByDeviceIdPS;

	
	public AssistiveDeviceInstanceDB() throws DataAccessException, SQLException {

		Connection con = DBConnection.getInstance().getConnection();

		findAssistiveDeviceInstanceByDeviceIdPS = con.prepareStatement(FIND_BY_DEVICE_ID);

	}


	/**
	 * Returns a list of AssistiveDeviceInstance objects. 
	 * This method executes the PreparedStatement in the SQL database
	 * "select * from AssistiveDeviceInstance where FKassistiveDeviceId = ?"
	 * and searches in the database for AssistiveDeviceInstances with a ForeignKey to AssistiveDevice 
	 * which equals the given parameter (deviceId) and then returns a list of all matches
	 * 
	 * 
	 * @param deviceId the ID from AssistiveDevice. Whatever Integer input enters the method, replaces the questionmark ("?") in the prepared statement
	 * @return List of AssistiveDeviceInstance objects
	 */
	@Override
	public List<AssistiveDeviceInstance> findInstancesByDeviceId(int deviceId) throws DataAccessException{
		// TODO Auto-generated method stub
		try {
			findAssistiveDeviceInstanceByDeviceIdPS.setInt(1, deviceId);
			ResultSet rs = findAssistiveDeviceInstanceByDeviceIdPS.executeQuery();
			List<AssistiveDeviceInstance> res = buildObjects(rs);
			return res;
			
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve data from AssistiveDeviceInstance!", e);
		}
	}
	
	/**
	 * Returns a list of AssistiveDeviceInstance objects.
	 * This method loops through the the ResultSet and builds a
	 * list of all objects returned in the ResultSet.
	 * 
	 * @param rs ResultSet 
	 * @return List of AssistiveDeviceInstance objects
	 * @throws SQLException If a SQL exception occurred
	 */
	private List<AssistiveDeviceInstance> buildObjects(ResultSet rs) throws SQLException {
		List<AssistiveDeviceInstance> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildAssistiveDeviceInstanceObject(rs));
		}
		return res;
		
	}
	
	/**
	 * Returns an AssistiveDeviceInstance object.
	 * This method builds the first AssistiveDeviceInstance object it finds from the ResultSet
	 * @param rs ResultSet
	 * @return AssistiveDeviceInstance object
	 */
	private AssistiveDeviceInstance buildAssistiveDeviceInstanceObject(ResultSet rs) {
		AssistiveDeviceInstance assistiveDeviceInstance = null;

		try {
			assistiveDeviceInstance = new AssistiveDeviceInstance(rs.getInt("id"), rs.getString("barcode"), rs.getDate("registeredDate"), rs.getString("note"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assistiveDeviceInstance; 
	}
	


}
