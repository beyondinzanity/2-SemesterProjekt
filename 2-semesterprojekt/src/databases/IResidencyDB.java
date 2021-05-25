package databases;

import java.util.List;

import model.Residency;

public interface IResidencyDB {
	List<Residency> findResidencyByResidentId(int id) throws DataAccessException;
}
