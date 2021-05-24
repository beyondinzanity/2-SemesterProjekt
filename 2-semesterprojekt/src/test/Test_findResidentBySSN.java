package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import databases.DataAccessException;
import databases.ResidentDB;

public class Test_findResidentBySSN {

	@BeforeEach
	void setup() throws DataAccessException, SQLException {

	}

	@Test
	void testid1() throws DataAccessException, SQLException {
		// Arrange
		ResidentDB db = new ResidentDB();
		String bruhSSN = "4700540903";

		// Act

		// Assert
		assertEquals(bruhSSN, db.findResidentBySsn("4700540903").getSsn());
	}
}
