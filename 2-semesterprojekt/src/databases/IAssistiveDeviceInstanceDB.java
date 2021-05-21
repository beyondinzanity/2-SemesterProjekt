package databases;

import java.util.List;

import model.AssistiveDeviceInstance;

public interface IAssistiveDeviceInstanceDB {
	public List<AssistiveDeviceInstance> findInstanceByDeviceId(int deviceId) throws DataAccessException;
	
}
