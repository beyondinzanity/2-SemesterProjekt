package databases;

import java.util.List;

import model.AssistiveDevice;

public interface IAssistiveDeviceDB {
	//TODO Add Methods
	public List<AssistiveDevice> findAssistiveDevices(int assistiveDeviceHmi) throws DataAccessException;
	public List<AssistiveDevice> findAssistiveDevicesByName(String assistiveDeviceName) throws DataAccessException;

}
