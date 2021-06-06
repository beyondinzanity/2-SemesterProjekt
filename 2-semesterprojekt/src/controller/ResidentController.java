package Controller;

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

	/**
	 * Used to find residents based on a ssn search
	 * 
	 * @return Method Returns list of residents, based an ssn numbers matching user search. 
	 * @param ssn , A String meant to represent a social security number
	 */

	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException {
		
		return residentDB.findResidentBySsn(ssn);
	}
}
