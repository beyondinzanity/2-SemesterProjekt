package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceDB;
import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;

public class TryMe {
	//private static AssistiveDeviceInstanceDB ass;
	
	public static void main(String[] args) throws DataAccessException, SQLException {
		 AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		 AssistiveDeviceDB ass2 = new AssistiveDeviceDB();
		 for (AssistiveDeviceInstance q : ass.findInstancesByDeviceId(1)) {
			 System.out.println(q.getBarcode() + ", " + q.getRegisteredDate() + ", " + q.getNote());
		 }
		 
		 for (AssistiveDevice q : ass2.findAssistiveDevices(102771)) {
			 System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
		 }
		// System.out.println(ass.findInstanceByDeviceId(1).getBarcode() + " " + ass.findInstanceByDeviceId(1).getRegisteredDate() + " " + ass.findInstanceByDeviceId(1).getNote());
		
	}
}
