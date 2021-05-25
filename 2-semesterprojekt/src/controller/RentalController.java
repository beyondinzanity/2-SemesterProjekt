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
import model.Employee;
import model.Rental;
import model.Resident;

public class RentalController {
	private AssistiveDeviceController assistiveDeviceController;
	private RentalDB rentalDB;
	private ResidentController residentController;
	private List<AssistiveDevice> assistiveDeviceList;
	private List<Resident> residentList;
	private Employee employee;
	Rental rental;

	public RentalController() throws DataAccessException, SQLException {
		createRental();

		assistiveDeviceController = new AssistiveDeviceController();
		residentController = new ResidentController();
		rentalDB = new RentalDB();
		assistiveDeviceList = new ArrayList<>();
		residentList = new ArrayList<>();
	}

	public void createRental() {
		rental = new Rental();
	}

	public void setEmployee() {
		employee = new Employee(1, 1432, "Hans", "Nielsen", "1211650337", "12345678", "hansNiels@gmail.com");
		rental.setEmployee(employee);
	}
	
	public String setResident(String ssn) throws DataAccessException {
		Resident resident = null;
		boolean residentNotFound = true;		
		while(residentNotFound == true) {	
			for (int i = 0; i <= residentList.size() - 1; i++) {
				if(ssn.equals(residentList.get(i).getSsn())) {
					residentNotFound = false;
					System.out.println("Found resident --> " + ssn);
					resident = residentList.get(i);
				}
			}
		}
		
		rental.setResident(resident);
		return "Added " + resident.getSsn();

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


	public AssistiveDeviceInstance addAssistiveDeviceInstance(int hmi, String barcode)
			throws DataAccessException, SQLException {
		AssistiveDevice assistiveDevice = null;
		AssistiveDeviceInstance instance = null;
		boolean assistiveDeviceNotFound = true;
		boolean assistiveDeviceInstanceNotFound = true;
		while (assistiveDeviceNotFound) {
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

	public List<AssistiveDevice> findAssistiveDevices(String userInput) throws DataAccessException, SQLException {
		assistiveDeviceList = assistiveDeviceController.findAssistiveDevices(userInput);
		return assistiveDeviceList;
		
	}

	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException, SQLException {
		residentList = residentController.findResidentBySsn(ssn);
		return residentList;
	}

	public void endRental() throws Exception {
		rentalDB.endRental(this.rental);
		createRental();

	}
	
	public Rental getRental() {
		return rental;
	}

	public ResidentController getResidentController() throws DataAccessException, SQLException {
		residentController = new ResidentController();
		return residentController;
	}

	public AssistiveDeviceController getAssistiveDeviceController() throws DataAccessException, SQLException {
		assistiveDeviceController = new AssistiveDeviceController();
		return assistiveDeviceController;
	}

	public int setRentalNumber(int rentalNumber) {
		// TODO Auto-generated method stub
		int rentNr = rental.setRentalNumber(rentalNumber);
		return rentNr;
		
	}

}
