package gui;

import java.sql.SQLException;
import java.util.List;

import Controller.RentalController;
import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import databases.ResidentDB;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;
import model.Resident;

public class TryMe {
	// private static AssistiveDeviceInstanceDB ass;

	public static void main(String[] args) throws DataAccessException, SQLException {

		AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		AssistiveDeviceDB ass2 = new AssistiveDeviceDB();
		ResidentDB ass3 = new ResidentDB();

		for (Resident res : ass3.findResidentBySsn("1")) {
			System.out.println(res.getSsn());
		}

		for (AssistiveDeviceInstance q : ass.findInstancesByDeviceId(1)) {
			System.out.println(q.getBarcode() + ", " + q.getRegisteredDate() + ", " + q.getNote());
		}

		for (AssistiveDevice q : ass2.findAssistiveDevices("102771")) {
			System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
		}

		RentalController rentalController = new RentalController();
		List<Resident> a1 = rentalController.findResidentBySsn("2");
		for (Resident res : a1) {
			System.out.println(res.getEmail() + " " + res.getZipCity().getCity());
		}

	}
}
