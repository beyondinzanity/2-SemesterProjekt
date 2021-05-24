package controller;

import java.sql.SQLException;

import databases.DataAccessException;
import databases.ResidentDB;
import model.Resident;

public class ResidentController {
	private ResidentDB residentDB;

	public ResidentController() throws DataAccessException, SQLException {
		residentDB = new ResidentDB();
	}
<<<<<<< Updated upstream

	public Resident findResident(String ssn) throws DataAccessException {

		return residentDB.findResidentBySsn(ssn);
=======
	
	
	
	public Resident findResident(String ssn) throws DataAccessException {
		
		return residentDB.findResidentBySsn(ssn); 
>>>>>>> Stashed changes
	}

}
