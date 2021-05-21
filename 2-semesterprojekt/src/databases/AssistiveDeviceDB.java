package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AssistiveDevice;

public class AssistiveDeviceDB implements IAssistiveDeviceDB {
	private static final String FIND_BY_DEVICE_ID = "select * from AssistiveDevice where hmiNumber = ?";
	private PreparedStatement findAssistiveDevicesByHmiNumberPS;

	public AssistiveDeviceDB() throws DataAccessException, SQLException {

		Connection con = DBConnection.getInstance().getConnection();

		findAssistiveDevicesByHmiNumberPS = con.prepareStatement(FIND_BY_DEVICE_ID);

	}
	@Override
	public List<AssistiveDevice> findAssistiveDevices(int assistiveDeviceHmi) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			findAssistiveDevicesByHmiNumberPS.setInt(1, assistiveDeviceHmi);
			ResultSet rs = findAssistiveDevicesByHmiNumberPS.executeQuery();
			List<AssistiveDevice> res = buildObjects(rs);
			return res;
			
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve data from AssistiveDevice", e);
		}
	}
	
	private List<AssistiveDevice> buildObjects(ResultSet rs) throws SQLException {
		List<AssistiveDevice> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildAssistiveDeviceObject(rs));
		}
		return res;
	}
	
	private AssistiveDevice buildAssistiveDeviceObject(ResultSet rs) {
		AssistiveDevice assistiveDevice = null;
		
		try {
			assistiveDevice = new AssistiveDevice(rs.getInt("hmiNumber"), rs.getString("name"), rs.getString("type"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assistiveDevice;
	}
	
}
