package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AssistiveDeviceInstance;
import model.Resident;

public class AssistiveDeviceInstanceDB implements IAssistiveDeviceInstanceDB {

	private static final String FIND_BY_DEVICE_ID = "select * from AssistiveDeviceInstance where id = ?";
	private PreparedStatement findAssistiveDeviceInstanceByDeviceIdPS;

	public AssistiveDeviceInstanceDB() throws DataAccessException, SQLException {

		Connection con = DBConnection.getInstance().getConnection();

		findAssistiveDeviceInstanceByDeviceIdPS = con.prepareStatement(FIND_BY_DEVICE_ID);

	}

	@Override
	public AssistiveDeviceInstance findInstanceByDeviceId(int deviceId) {
		// TODO Auto-generated method stub
		AssistiveDeviceInstance res = null;

		try {
			findAssistiveDeviceInstanceByDeviceIdPS.setInt(1, deviceId);
			ResultSet rs = findAssistiveDeviceInstanceByDeviceIdPS.executeQuery();

			if (rs.next()) {
				res = buildAssistiveDeviceInstanceObject(rs);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return res;
	}

	private AssistiveDeviceInstance buildAssistiveDeviceInstanceObject(ResultSet rs) {
		AssistiveDeviceInstance assistiveDeviceInstance = null;

		try {
			assistiveDeviceInstance = new AssistiveDeviceInstance(rs.getString("barcode"), rs.getDate("registeredDate"),
					rs.getString("note"));
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return assistiveDeviceInstance;
	}

}
