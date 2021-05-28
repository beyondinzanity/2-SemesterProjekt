package databases;

import java.util.List;

import model.Resident;

public interface IResidentDB {
	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException;

}