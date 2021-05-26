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

	public Rental(int rentalId, int rentalNumber, LocalDate startDate, LocalDate endDate) {
		this.rentalID = rentalId;
		this.rentalNumber = rentalNumber;
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	public void setDate(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public void addAssistiveDeviceInstance(AssistiveDeviceInstance instance) {
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

	public int setRentalNumber(int rentalNumber) {
		// TODO Auto-generated method stub
		this.rentalNumber = rentalNumber;
		return this.rentalNumber;
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

	public void setEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employee = employee;
		
	}

}
