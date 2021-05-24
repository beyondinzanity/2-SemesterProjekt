package databases;

import model.Resident;

public interface IResidentDB {
	public Resident findResidentBySsn(String ssn) throws DataAccessException;

	public Resident findResidentByName(String name) throws DataAccessException;

}
