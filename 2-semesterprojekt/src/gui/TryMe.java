package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDeviceInstance;

public class TryMe {
	//private static AssistiveDeviceInstanceDB ass;
	
	public static void main(String[] args) throws DataAccessException, SQLException {
		 AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		 AssistiveDeviceInstance instance = ass.findInstanceByDeviceId(1);
		 System.out.println(instance.getBarcode() + " " + instance.getRegisteredDate() + " " + instance.getNote());
		
	}
}
