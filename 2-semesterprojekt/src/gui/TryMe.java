package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;
import model.AssistiveDeviceInstance;

public class TryMe {
	//private static AssistiveDeviceInstanceDB ass;
	
	public static void main(String[] args) throws DataAccessException, SQLException {
		 AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
		 
		 System.out.println(ass.findInstanceByDeviceId(1).getBarcode() + " " + ass.findInstanceByDeviceId(1).getRegisteredDate() + " " + ass.findInstanceByDeviceId(1).getNote());
		
	}
}
