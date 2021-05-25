package databases;

import model.Municipality;

public interface IMunicipalityDB {
	Municipality findMunicipality(int id) throws DataAccessException;
}
