package databases;

import java.util.List;

import model.AssistiveDeviceInstance;

public interface IAssistiveDeviceInstanceDB {
	public List<AssistiveDeviceInstance> findInstancesByDeviceId(int deviceId) throws DataAccessException;
	
}
