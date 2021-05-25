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
