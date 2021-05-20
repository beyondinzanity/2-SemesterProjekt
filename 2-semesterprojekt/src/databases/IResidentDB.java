package databases;

import model.Resident;

public interface IResidentDB {
	public Resident findResidentBySsn(int ssn) throws DataAccessException;
	public Resident findResidentByName(String name) throws DataAccessException;

}
