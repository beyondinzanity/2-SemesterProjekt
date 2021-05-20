package databases;

import model.AssistiveDeviceInstance;

public interface IAssistiveDeviceInstanceDB {
	public AssistiveDeviceInstance findInstanceByDeviceId(int deviceId);
	
}
