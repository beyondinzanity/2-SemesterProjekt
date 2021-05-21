package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;

public class TryMe {
	private static AssistiveDeviceInstanceDB ass;
	public static void main(String[] args) throws DataAccessException, SQLException {
		 ass = new AssistiveDeviceInstanceDB();
		 ass.findInstanceByDeviceId(1);
		
	}
}
