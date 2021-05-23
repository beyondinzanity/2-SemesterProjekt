package model;

import java.time.LocalDate;

public class Rental {

	private int rentalID;
	private int rentalNumber;
	private LocalDate startDate;
	private LocalDate endDate;
	private Employee employee;
	private AssistiveDeviceInstance assistiveDeviceInstance;
	private Resident resident;
	
	public Rental() {
		
	}

	public Rental(int rentalID, int rentalNumber, LocalDate startDate, LocalDate endDate, Employee employee,
			AssistiveDeviceInstance assistiveDeviceInstance, Resident resident) {
		super();
		this.rentalID = rentalID;
		this.rentalNumber = rentalNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
		this.assistiveDeviceInstance = assistiveDeviceInstance;
		this.resident = resident;
	}
	
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
