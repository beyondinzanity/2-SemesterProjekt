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
	
	private List<AssistiveDeviceInstance> buildObjects(ResultSet rs) throws SQLException {
		List<AssistiveDeviceInstance> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildAssistiveDeviceInstanceObject(rs));
		}
		return res;
		
	}

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
