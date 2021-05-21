package model;

import java.util.ArrayList;
import java.util.List;

public class AssistiveDevice {
	private int id;
	private int hmiNumber;
	private String name;
	private String type;
	private List<AssistiveDeviceInstance> deviceInstanceList;

	public AssistiveDevice(int hmiNumber, String name, String type) {
		super();
		this.hmiNumber = hmiNumber;
		this.name = name;
		this.type = type;
		deviceInstanceList = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHmiNumber() {
		return hmiNumber;
	}

	public void setHmiNumber(int hmiNumber) {
		this.hmiNumber = hmiNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AssistiveDeviceInstance> getDeviceInstanceList() {
		return deviceInstanceList;
	}

	public void setDeviceInstanceList(List<AssistiveDeviceInstance> deviceInstanceList) {
		this.deviceInstanceList = deviceInstanceList;
	}
	
	
	
	

}
