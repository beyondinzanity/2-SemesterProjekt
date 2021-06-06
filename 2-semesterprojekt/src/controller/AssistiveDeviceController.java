package Controller;

import java.sql.SQLException;
import java.util.List;

import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance; 

public class AssistiveDeviceController {
	private AssistiveDeviceDB assistiveDeviceDB;
	
	public AssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceDB = new AssistiveDeviceDB();
	}

	/**
	 * Gives access to finding and building AssistiveDevices through database class
	 * 
	 * @param userSearch String
	 * @return	List of AssistiveDevice objects
	 * @throws DataAccessException If a data access exception occurred
	 */
	public List<AssistiveDevice> findAssistiveDevices(String userSearch) throws DataAccessException {
		return assistiveDeviceDB.findAssistiveDevices(userSearch); 

	}

}
