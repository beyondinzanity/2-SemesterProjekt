package controller;

import java.sql.SQLException;
import java.util.List;

import databases.AssistiveDeviceDB;
import databases.DataAccessException;
import model.AssistiveDevice;

public class AssistiveDeviceController {
	private AssistiveDeviceDB assistiveDeviceDB;
	
	public AssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceDB = new AssistiveDeviceDB();
	}

	public List<AssistiveDevice> findAssistiveDevices(String userSearch) throws DataAccessException {
		return assistiveDeviceDB.findAssistiveDevices(userSearch);

	}

}
