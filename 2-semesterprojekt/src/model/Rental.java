package model;

import java.sql.SQLData;
import java.time.LocalDate;
import java.util.Date;

public class Rental {
	
	private int rentalID; 
	private LocalDate startDate;
	private LocalDate endDate; 
	private int rentalNumber;
	private Employee employee;
	private AssistiveDeviceInstance assistiveDeviceInstance;
	private Resident resident;
	
	public void setResident(Resident resident) {
		this.resident = resident;
	}
	
	public void setAssistiveDeviceInstance(AssistiveDeviceInstance instance) {
		this.assistiveDeviceInstance = instance; 
	}
	
	public Resident getResident() {
		return resident; 
	}
	
	
	public void setRentalId(int id) {
		rentalID = id;
		
	}
	
	public int getRentalNumber() {
		return rentalNumber;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate; 
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public AssistiveDeviceInstance getAssistiveDeviceInstance() {
		return assistiveDeviceInstance;
	}
}
