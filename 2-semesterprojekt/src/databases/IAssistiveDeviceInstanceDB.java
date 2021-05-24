package databases;

import java.util.List;

import model.AssistiveDeviceInstance;

public interface IAssistiveDeviceInstanceDB {
	public List<AssistiveDeviceInstance> findInstancesByDeviceId(String deviceId) throws DataAccessException;
	
}
