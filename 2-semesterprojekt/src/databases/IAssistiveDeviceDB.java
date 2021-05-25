package databases;

import java.util.List;

import model.AssistiveDevice;

public interface IAssistiveDeviceDB {
	public List<AssistiveDevice> findAssistiveDevices(String assistiveDeviceHmi) throws DataAccessException;

}
