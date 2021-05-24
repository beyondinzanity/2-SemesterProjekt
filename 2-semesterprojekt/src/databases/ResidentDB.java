package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Resident;
import model.ZipCity;

public class ResidentDB implements IResidentDB {

	private static final String FIND_BY_SSN = "select * from Resident where ssn like ?";
	private PreparedStatement findResidentBySsnPS;

	public ResidentDB() throws DataAccessException, SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findResidentBySsnPS = con.prepareStatement(FIND_BY_SSN);
	}

	private Resident buildResidentObject(ResultSet rs) throws SQLException, DataAccessException {

		Resident resident = null;

		// er det her ok at gøre?

		ZipCityDB db = new ZipCityDB();
		ZipCity zipCity = db.findZipCityById(rs.getInt("FKZipCityId"));

		try {
			resident = new Resident(rs.getString("fname"), rs.getString("lname"), rs.getString("ssn"),
					rs.getString("phoneNumber"), rs.getString("email"), rs.getInt("apartmentNumber"),
					rs.getString("streetName"), rs.getInt("houseNumber"), zipCity);
			resident.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resident;
	}

	private List<Resident> buildResidentObjects(ResultSet rs) throws SQLException, DataAccessException {
		List<Resident> res = new ArrayList<>();
		while (rs.next()) {
			res.add(buildResidentObject(rs));
		}
		return res;
	}

	@Override
	public List<Resident> findResidentBySsn(String ssn) throws DataAccessException {
		ssn = "%" + ssn + "%";
		try {
			findResidentBySsnPS.setString(1, ssn);
			ResultSet rs = findResidentBySsnPS.executeQuery();
			List<Resident> res = buildResidentObjects(rs);
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Resident", s);
		}
	}

	@Override
	public List<Resident> findResidentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
