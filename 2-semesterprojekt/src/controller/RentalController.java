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
	private RentalDB rentalDB;

	private ResidentController residentController;
	private List<AssistiveDevice> assistiveDevices;
	Rental rental;

	public RentalController() {

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

	public List<AssistiveDevice> findAssistiveDevice(String userSearch) throws DataAccessException, SQLException {
		assistiveDevices = getAssistiveDeviceController().findAssistiveDevices(userSearch);

		return assistiveDevices;

	}

	public AssistiveDeviceInstance addAssistiveDeviceInstance(int hmi, String barcode)
			throws DataAccessException, SQLException {
		AssistiveDevice assistiveDevice = null;
		AssistiveDeviceInstance instance = null;
		boolean assistiveDeviceFound = false;
		boolean assistiveDeviceInstanceFound = false;
		while (assistiveDeviceFound == false) {

			for (int i = 0; i < assistiveDevices.size(); i++) {

				if (hmi == assistiveDevices.get(i).getHmiNumber()) {
					assistiveDeviceFound = true;
					assistiveDevice = assistiveDevices.get(i);

				}
			}

		}

		while (assistiveDeviceInstanceFound == false) {

			for (int i = 0; i < assistiveDevice.getDeviceInstanceList().size(); i++) {

				if (barcode.equals(assistiveDevice.getDeviceInstanceList().get(i).getBarcode())) {
					assistiveDeviceInstanceFound = true;
					instance = assistiveDevice.getDeviceInstanceList().get(i);

				}

			}

		}

		rental.addAssistiveDeviceInstance(instance);
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
