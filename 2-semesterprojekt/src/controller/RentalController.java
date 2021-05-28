package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import databases.DBConnection;
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
	private Rental rental;
	private boolean connectedToDB;

	public RentalController() throws DataAccessException, SQLException {
		rental = new Rental();

		assistiveDeviceController = new AssistiveDeviceController();
		residentController = new ResidentController();
		rentalDB = new RentalDB();
		assistiveDeviceList = new ArrayList<>();
		residentList = new ArrayList<>();
	}

	public void createRental() {
		rental = new Rental();
		int randomRentalNumber = (int) (System.currentTimeMillis() * -1);
		setRentalNumber(randomRentalNumber);
		setEmployee();

	}

	public void setEmployee() {
		employee = new Employee(1, 1432, "Hans", "Nielsen", "1211650337", "12345678", "hansNiels@gmail.com");
		rental.setEmployee(employee);
	}

	public void setResident(String ssn) throws DataAccessException {
		Resident resident = null;
		boolean residentNotFound = true;
		while (residentNotFound && ssn != null) {
			for (int i = 0; i <= residentList.size() - 1; i++) {
				if (ssn.equals(residentList.get(i).getSsn())) {
					residentNotFound = false;
					resident = residentList.get(i);
				}
			}
		}

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

	/**
	 * Loops through list of AssistiveDevices and then loops through AssistiveDevice
	 * Instances of same description, until the device with same hmiNumber and
	 * barcode is found
	 * 
	 * @param hmi      , number belonging to a AssistiveDevice
	 * @param barcode, number belonging to a AssistiveDevice instance
	 * @return object of AssistiveDevice Instance
	 * @throws SQLException        If a SQL exception occurred
	 * @throws DataAccessException If a data access exception occurred
	 */
	public AssistiveDeviceInstance addAssistiveDeviceInstance(int hmi, String barcode)
			throws DataAccessException, SQLException {
		AssistiveDevice assistiveDevice = null;
		AssistiveDeviceInstance instance = null;
		boolean assistiveDeviceNotFound = true;
		boolean assistiveDeviceInstanceNotFound = true;
		while (assistiveDeviceNotFound && hmi != 0 && barcode != null) {

			for (int i = 0; i <= assistiveDeviceList.size() - 1; i++) {

				if (hmi == assistiveDeviceList.get(i).getHmiNumber()) {
					assistiveDeviceNotFound = false;
					assistiveDevice = assistiveDeviceList.get(i);
				}
			}
		}

		while (assistiveDeviceInstanceNotFound && hmi != 0 && barcode != null) {

			for (int i = 0; i <= assistiveDevice.getDeviceInstanceList().size() - 1; i++) {

				if (barcode.equals(assistiveDevice.getDeviceInstanceList().get(i).getBarcode())) {
					assistiveDeviceInstanceNotFound = false;
					instance = assistiveDevice.getDeviceInstanceList().get(i);
				}
			}
		}

		rental.addAssistiveDeviceInstance(instance);
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
	
	/**
	 * Gives rental object a unique number for identification 
	 * @param rentalNumber, an int that will be used as rental number on a rental object
	 */

	public void setRentalNumber(int rentalNumber) {
		// TODO Auto-generated method stub
		rental.setRentalNumber(rentalNumber);

	}

	/**
	 * Returns a boolean result, depending on receiving access to database.
	 * 
	 * @return true, if method gets access to database. Returns false otherwise
	 */

	public boolean isDbConnected() {
		connectedToDB = DBConnection.getInstance().isDbConnected();
		if (connectedToDB == true) {

		} else {
			connectedToDB = false;
		}
		return connectedToDB;

	}

}
