package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;

public class TryMeNicklas {

	public static void main(String[] args) throws DataAccessException, SQLException {
		//AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		AssistiveDeviceDB ass2 = new AssistiveDeviceDB();
		
		for (AssistiveDevice q : ass2.findAssistiveDevices("k")) {
			System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
			
			for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
				System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
			}
		}
	}

}
