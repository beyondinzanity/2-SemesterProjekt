package controller;

import java.sql.SQLException;
import java.util.List;

import databases.DataAccessException;
import model.AssistiveDevice;
import model.Rental;
import model.Resident;

public class RentalController {
	private AssistiveDeviceController assistiveDeviceController;
	
	Rental rental;
	
	public void createRental(){
		
		rental = new Rental();
			
	}
	
	public Resident findResident(int ssn) {
		return null;
	}
	
	public AssistiveDeviceController getAssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		return assistiveDeviceController;
		
	}
	
	

}
