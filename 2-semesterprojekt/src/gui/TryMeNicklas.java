package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;

public class TryMeNicklas {

	public static void main(String[] args) throws DataAccessException, SQLException {
		AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		AssistiveDeviceDB ass2 = new AssistiveDeviceDB();
		
//		for (AssistiveDeviceInstance q : ass.findInstancesByDeviceId(1)) {
//			System.out.println(q.getBarcode() + ", " + q.getRegisteredDate() + ", " + q.getNote());
//		}
//
//		for (AssistiveDevice q : ass2.findAssistiveDevices(101337)) {
//			System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
//			for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
//				System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
//			}
//		}
		
		for (AssistiveDevice q : ass2.findAssistiveDevicesByName("k")) {
			System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
			for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
				System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
			}
		}
	}

}
