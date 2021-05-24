package controller;

import java.sql.SQLException;
import java.util.List;

import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;

public class AssistiveDeviceController { 
	private AssistiveDeviceDB assistiveDeviceDB;
	private AssistiveDeviceInstanceDB assistiveDeviceInstanceDB;
	
	public AssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceDB = new AssistiveDeviceDB();
	}

	public List<AssistiveDevice> findAssistiveDevices(String userSearch) throws DataAccessException {
		return assistiveDeviceDB.findAssistiveDevices(userSearch);

	}
	
	public AssistiveDeviceInstance findAssistiveDeviceInstance(String deviceId) {
		
		AssistiveDeviceInstance instance = assistiveDeviceInstanceDB.findInstanceByDeviceId(deviceId);
		
	}

}
