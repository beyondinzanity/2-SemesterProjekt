package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import databases.DataAccessException;
import databases.RentalDB;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;
import model.Rental;
import model.Resident;

public class RentalController {
	private AssistiveDeviceController assistiveDeviceController;
<<<<<<< Updated upstream
	private ResidentController residentController;
	Rental rental;

=======
	private ResidentController  residentController;
	private RentalDB rentalDB;
	Rental rental; 
	
>>>>>>> Stashed changes
	public RentalController() {

	}

	public void createRental() {
		rental = new Rental();
	}
<<<<<<< Updated upstream

=======
	
	public void setResident(String ssn) throws DataAccessException {
		Resident resident = findResident(ssn); 
		rental.setResident(resident);
		
		
	}
	
	public void setDate(String startDate, String endDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String startD = startDate;
        //convert String to LocalDate
		LocalDate localSDate = LocalDate.parse(startD, formatter);
		
		String endD = endDate; 
		
		LocalDate localEDate = LocalDate.parse(endD, formatter);
		
		rental.setDate(localSDate, localEDate);
		
	}
	
	public List<AssistiveDevice> findAssistiveDevice(String userInput) throws DataAccessException, SQLException {
		List<AssistiveDevice> assistiveDevices = getAssistiveDeviceController().findAssistiveDevices(userInput);
		
		return assistiveDevices;
		
	}
	
	public void addAssistiveDeviceInstance(String barcode) throws DataAccessException, SQLException {
		AssistiveDeviceInstance res = getAssistiveDeviceController().findAssistiveDeviceInstance(barcode);
		
		rental.addAssistiveDeviceInstance(res);
	}
	
>>>>>>> Stashed changes
	public Resident findResident(String ssn) throws DataAccessException {
		Resident resident = residentController.findResident(ssn);
		return resident;
	}
<<<<<<< Updated upstream

	public void endRental() {

=======
	
	public void endRental() throws Exception {
		rentalDB.endRental(this.rental);
		
		
>>>>>>> Stashed changes
	}

	public ResidentController getResidentController() throws DataAccessException, SQLException {
		residentController = new ResidentController();
		return residentController;
	}

	public AssistiveDeviceController getAssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		return assistiveDeviceController;

	}
<<<<<<< Updated upstream
=======
	
	
	
	
>>>>>>> Stashed changes

}
