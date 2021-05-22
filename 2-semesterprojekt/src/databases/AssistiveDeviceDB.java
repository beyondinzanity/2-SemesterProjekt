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
	
	private List<AssistiveDevice> buildObjects(ResultSet rs) throws SQLException, DataAccessException {
		List<AssistiveDevice> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildAssistiveDeviceObject(rs));
		}
		return res;
	}  
	
	
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
