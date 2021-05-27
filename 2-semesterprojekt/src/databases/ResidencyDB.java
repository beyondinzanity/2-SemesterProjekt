package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Residency;

public class ResidencyDB implements IResidencyDB {
	private MunicipalityDB municipalityDB;
	private static final String FIND_BY_ID = "select * from Residency where FKresidentId = ?";
	private PreparedStatement findResidencyByResidentIdPS;

	public ResidencyDB() throws SQLException {

		Connection con = DBConnection.getInstance().getConnection();
		municipalityDB = new MunicipalityDB();

		findResidencyByResidentIdPS = con.prepareStatement(FIND_BY_ID);
	}

	@Override
	public List<Residency> findResidencyByResidentId(int id) throws DataAccessException {
		try {
			findResidencyByResidentIdPS.setInt(1, id);
			ResultSet rs = findResidencyByResidentIdPS.executeQuery();
			List<Residency> res = buildResidencyObjects(rs);

			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new DataAccessException("Could not retrieve data from Residency", s);
		}
	}

	private List<Residency> buildResidencyObjects(ResultSet rs) throws DataAccessException, SQLException {
		List<Residency> res = new ArrayList<>();
		while (rs.next()) {
			res.add(buildResidencyObject(rs));

		}
		return res;
	}

	private Residency buildResidencyObject(ResultSet rs) throws DataAccessException, SQLException {
		Residency residency = null;
		municipalityDB = new MunicipalityDB();
		try {
			residency = new Residency(rs.getInt("id"), rs.getDate("fromDate").toLocalDate(),
					(rs.getDate("toDate") != null ? rs.getDate("toDate").toLocalDate() : null));
			residency.setMunicipality(municipalityDB.findMunicipality(rs.getInt("FKmunicipalityId")));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in buildObject ResidencyDB");
		}
		return residency;
	}

}
