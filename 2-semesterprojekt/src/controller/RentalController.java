package Controller;

import java.sql.SQLException;
<<<<<<< Updated upstream
import java.util.List;

import databases.DataAccessException;
import model.AssistiveDevice;
=======

import databases.DataAccessException;
>>>>>>> Stashed changes
import model.Rental;
import model.Resident;

public class RentalController {
<<<<<<< Updated upstream
	private AssistiveDeviceController assistiveDeviceController;
	
=======
	private ResidentController  residentController;
>>>>>>> Stashed changes
	Rental rental;
	
	public RentalController() throws DataAccessException, SQLException {
		residentController = new ResidentController();
		
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
	
	public AssistiveDeviceController getAssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		return assistiveDeviceController;
		
	}
	
	

}
