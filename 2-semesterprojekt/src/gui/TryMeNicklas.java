package gui;

import java.sql.SQLException;

import databases.AssistiveDeviceDB;
import databases.DataAccessException;
import databases.ResidencyDB;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;
import model.Residency;

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
		
//		MunicipalityDB db = new MunicipalityDB();
//		Municipality a = db.findMunicipality(1);
//		System.out.println(a.getName());
//		
//		ResidentDB resDB = new ResidentDB();
//		Resident b = resDB.findResidentById(2);
//		System.out.println(b.getFname());
		
		ResidencyDB rdb = new ResidencyDB();
		Residency residency = rdb.findResidencyByResidentId(2);

		System.out.println(residency.getMunicipality().getName());
		System.out.println(residency.getResident().getFname());
		
		//System.out.println(residency.getResident().getFname()+ residency.getMunicipality().getName());
		
	}

}
