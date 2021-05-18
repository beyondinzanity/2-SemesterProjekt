package databases;

import model.Resident;

public class testResident {
	
	static ResidentDB db;
	private static Resident Resident;
	
	public testResident() throws Exception {
		ResidentDB db = new ResidentDB();
	}
	
	public static Resident residentRun() throws Exception {
		return db.findCustomerByEmail("Felix@gmail.dk");
	}
	
	public static void main(String[] args) throws Exception {
		
		Resident a = residentRun();
		
		System.out.println(a.getName());
		
	}
	
	
	

}
