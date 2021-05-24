package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import databases.DataAccessException;
import databases.RentalDB;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;
import model.Rental;
import model.Resident;

public class RentalController {
	private AssistiveDeviceController assistiveDeviceController;
	private RentalDB rentalDB;	
	private ResidentController residentController; 
	private List<AssistiveDevice> assistiveDeviceList;
	Rental rental;

	public RentalController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		residentController = new ResidentController();
		assistiveDeviceList = new ArrayList<>();
		createRental();

	}

	public void createRental() {
		rental = new Rental();
	}

	public void setResident(String ssn) throws DataAccessException {
		Resident resident = findResident(ssn);
		rental.setResident(resident);

	}

	public void setDate(String startDate, String endDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String startD = startDate;
		// convert String to LocalDate
		LocalDate localSDate = LocalDate.parse(startD, formatter);

		String endD = endDate;

		LocalDate localEDate = LocalDate.parse(endD, formatter);

		rental.setDate(localSDate, localEDate);

	}

	public List<AssistiveDevice> findAssistiveDevices(String userInput) throws DataAccessException, SQLException {
		assistiveDeviceList = assistiveDeviceController.findAssistiveDevices(userInput);
		return assistiveDeviceList;

	}

	public AssistiveDeviceInstance addAssistiveDeviceInstance(int hmi, String barcode) throws DataAccessException, SQLException {
		AssistiveDevice assistiveDevice = null;
		AssistiveDeviceInstance instance = null;
		boolean assistiveDeviceNotFound = true;
		boolean assistiveDeviceInstanceNotFound = true;
		while (assistiveDeviceNotFound) {
			System.out.println("Why here??");
			System.out.println(assistiveDeviceList.size());
			for (int i = 0; i <= assistiveDeviceList.size() - 1; i++) {

				if (hmi == assistiveDeviceList.get(i).getHmiNumber()) {
					assistiveDeviceNotFound = false;
					assistiveDevice = assistiveDeviceList.get(i);

				}
				System.out.println("1. loop");
			}

		}

		while (assistiveDeviceInstanceNotFound) {

			for (int i = 0; i <= assistiveDevice.getDeviceInstanceList().size() - 1; i++) {

				if (barcode.equals(assistiveDevice.getDeviceInstanceList().get(i).getBarcode())) {
					assistiveDeviceInstanceNotFound = false;
					instance = assistiveDevice.getDeviceInstanceList().get(i);

				}
				System.out.println("2. loop");

			}

		}

		rental.addAssistiveDeviceInstance(instance);
		System.out.println("Added Instance --> " + instance.getBarcode());
		return instance;

	}

	public Resident findResident(String ssn) throws DataAccessException {
		Resident resident = residentController.findResident(ssn);
		return resident;
	}

	public void endRental() throws Exception {
		rentalDB.endRental(this.rental);

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
