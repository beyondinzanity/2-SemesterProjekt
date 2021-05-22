package model;

import java.util.Date;

public class Rental {
	
	private int rentalID; 
	private Date startDate;
	private Date endDate;
	private int rentalNumber;
	private Employee employee;
	private AssistiveDeviceInstance assistiveDeviceInstance;
	private Resident resident;
	
	public Resident getResident() {
		return resident; 
	}
	
	
	public void setRentalId(int id) {
		rentalID = id;
		
	}
	
	public int getRentalNumber() {
		return rentalNumber;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate; 
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public AssistiveDeviceInstance getAssistiveDeviceInstance() {
		return assistiveDeviceInstance;
	}
}
