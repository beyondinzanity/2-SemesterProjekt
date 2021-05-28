package controller;

import java.sql.SQLException;
import java.util.List;

import databases.DataAccessException;
import databases.ResidentDB;
import model.Resident;

public class ResidentController {
	private ResidentDB residentDB;

	public ResidentController() throws DataAccessException, SQLException {
		residentDB = new ResidentDB();
	}


	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException {
		
		return residentDB.findResidentBySsn(ssn);
	}
}
