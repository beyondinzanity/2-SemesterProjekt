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
	
	
	
	public Resident findResident(int ssn) throws DataAccessException {
		
		return residentDB.findResidentBySsn(ssn); 
	}

}
