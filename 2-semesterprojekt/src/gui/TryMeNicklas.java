package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceDB;
import databases.DataAccessException;
import databases.ResidentDB;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;
import model.Residency;
import model.Resident;

public class TryMeNicklas {

	public static void main(String[] args) throws DataAccessException, SQLException {
//		//AssistiveDeviceInstanceDB ass = new AssistiveDeviceInstanceDB();
//		AssistiveDeviceDB ass2 = new AssistiveDeviceDB();
//		
//		for (AssistiveDevice q : ass2.findAssistiveDevices("k")) {
//			System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
//			
//			for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
//				System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
//			}
//		}
		
		ResidentDB residentDB = new ResidentDB();
		Resident resident = residentDB.findResidentById(2);
		System.out.println(resident.getEmail());
		
		for(Residency r : resident.getResidencyList()) {
			System.out.println(r.getResident().getFname() + ", " + r.getMunicipality().getName());
		}
		
		//System.out.println(residency.getResident().getFname()+ residency.getMunicipality().getName());
		
	}

}
