package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Municipality;

public class MunicipalityDB implements IMunicipalityDB {

	private static final String FIND_BY_ID = "select * from Municipality where id = ?";
	private PreparedStatement findMunicipalityById;

	public MunicipalityDB() throws SQLException {

		Connection con = DBConnection.getInstance().getConnection();
		findMunicipalityById = con.prepareStatement(FIND_BY_ID);
	}

	/**
	 * Returns a Resident object
	 * This method executes the PreparedStatement
	 * "select * from Municipality where id = ?"
	 * where it replaces the questionmark ("?") with the user input (id)
	 * and returns the matching Municipality from the database with the given id.
	 * @param id Surrogate key of Municipality 
	 * @return Municipality
	 * @throws DataAccessException 
	 */
	@Override
	public Municipality findMunicipality(int id) throws DataAccessException {

		try {
			findMunicipalityById.setInt(1, id);
			ResultSet rs = findMunicipalityById.executeQuery();
			Municipality res = buildResidentObject(rs);
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Resident", s);
		}

	}

	/**
	 * Returns a Municipality object after the object has been built.
	 * The constructor takes values from the database ResultSet and
	 * enters builds the object with the returned values
	 * @param rs ResultSet
	 * @return Municipality object
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	private Municipality buildResidentObject(ResultSet rs) throws SQLException, DataAccessException {

		Municipality municipality = null;

		try {
			if (rs.next()) {
				municipality = new Municipality(rs.getInt("id"), rs.getString("name"), rs.getString("region"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return municipality;
	}

}
