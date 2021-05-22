package controller;

import java.sql.SQLException;

import databases.DataAccessException;
import model.Rental;
import model.Resident;

public class RentalController {
	private AssistiveDeviceController assistiveDeviceController;
	private ResidentController  residentController;
	Rental rental;
	
	public RentalController() {
		
	}
	
	
	
	public void createRental(){
		rental = new Rental();		
	}
	
	public Resident findResident(int ssn) throws DataAccessException {
		Resident resident = residentController.findResident(ssn);
		return resident; 
	}
	
	public void endRental() {
		
	}
	
	public ResidentController getResidentController() throws DataAccessException, SQLException {
		residentController = new ResidentController();
		return residentController;
	}
	
	public AssistiveDeviceController getAssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		return assistiveDeviceController;
		
	}
	
	

}
