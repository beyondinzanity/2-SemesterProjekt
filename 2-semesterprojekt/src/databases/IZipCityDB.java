package databases;

import model.ZipCity;

public interface IZipCityDB {
	ZipCity findZipCityById(int id) throws DataAccessException;
}