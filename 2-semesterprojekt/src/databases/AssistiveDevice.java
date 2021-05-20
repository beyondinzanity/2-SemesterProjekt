package databases;

import java.time.LocalDate;

public class AssistiveDevice implements IAssistiveDeviceDB {
	private int id;
	private int hmiNumber;
	private String name;
	private String type;

	public AssistiveDevice(int id, int hmiNumber, String name, String type) {
		super();
		this.id = id;
		this.hmiNumber = hmiNumber;
		this.name = name;
		this.type = type;
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
	
	

}
