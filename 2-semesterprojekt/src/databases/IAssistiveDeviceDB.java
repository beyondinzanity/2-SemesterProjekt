package databases;

import java.util.List;

import model.AssistiveDevice;

public interface IAssistiveDeviceDB {
	//TODO Add Methods
	public List<AssistiveDevice> findAssistiveDevices(String assistiveDeviceHmi) throws DataAccessException;

}
