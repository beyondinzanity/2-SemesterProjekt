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

	/**
	 * Used to create new Rental object, and then gives the Rental object, a random
	 * rental number, and a employee witch is hard coded
	 * 
	 */
	public void createRental() {
		rental = new Rental();
		int randomRentalNumber = (int) (System.currentTimeMillis() * -1);
		setRentalNumber(randomRentalNumber);
		setEmployee();

	}

	/**
	 * Used for hard coding an Employee witch is will be connected to a Rental
	 * 
	 */
	public void setEmployee() {
		employee = new Employee(1, 1432, "Hans", "Nielsen", "1211650337", "12345678", "hansNiels@gmail.com");
		rental.setEmployee(employee);
	}

	/**
	 * Used to setting renting period for a rental object Method also converts
	 * string to LocalDate
	 * 
	 * @param startDate , A String written in LocalDate format to represent starting
	 *                  date of rental object
	 * @param endDate   , A String written in LocalDate format to represent ending
	 *                  date of rental object
	 */
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

	/**
	 * Used to setting renting period for a rental object Method also converts
	 * string to LocalDate
	 * 
	 * @param startDate , A String written in LocalDate format to represent starting
	 *                  date of rental object
	 * @param endDate   , A String written in LocalDate format to represent ending
	 *                  date of rental object
	 */
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
	 * Loops through list of AssistiveDevices by hmi search, and then loops through
	 * instances of that same AssistiveDevice by using barcodes.
	 * 
	 * Loops stops when an AssistiveDeviceInstance with matching hmiNumber and
	 * barcode is found.
	 * 
	 * @param hmi      , used to identify an AssistiveDevice
	 * @param barcode, used to identify an AssistiveDeviceInstance
	 * @return object of AssistiveDeviceInstance
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

				} else {
					assistiveDeviceNotFound = false;
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

	/**
	 * Returns a list of AssistiveDevice objects by calling
	 * AssistiveDeviceController
	 * 
	 * @param userInput , A String
	 * @return List of AssistiveDevice objects
	 * @throws SQLException        If a SQL exception occurred
	 * @throws DataAccessException If a data access exception occurred
	 */
	public List<AssistiveDevice> findAssistiveDevices(String userInput) throws DataAccessException, SQLException {
		assistiveDeviceList = assistiveDeviceController.findAssistiveDevices(userInput);
		return assistiveDeviceList;

	}

	/**
	 * Returns a list of Resident objects by calling ResidentController
	 * 
	 * @param ssn , A String meant to represent a social security number
	 * @return List of Resident objects
	 * @throws SQLException        If a SQL exception occurred
	 * @throws DataAccessException If a data access exception occurred
	 */
	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException, SQLException {
		residentList = residentController.findResidentBySsn(ssn);
		return residentList;
	}

	/**
	 * Saves a rental object to database, and creates new rental object to be build
	 * 
	 * @throws Exception, if exceptions occurred.
	 */
	public void endRental() throws Exception {
		rentalDB.endRental(this.rental);
		createRental();

	}

	public Rental getRental() {
		return rental;
	}

	/**
	 * Gives rental object a unique number for identification
	 * 
	 * @param rentalNumber, an int that will be used as rental number on a rental
	 *                      object
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
