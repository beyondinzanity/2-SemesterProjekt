package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
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
		String testSSN = "4700540903";

		// Act

		// Assert
		assertEquals(testSSN, db.findResidentBySsn("4700540903").get(0).getSsn());
	}

	@Test
	void testid2() throws DataAccessException, SQLException {
		// Arrange
		ResidentDB db = new ResidentDB();

		// Act

		// Assert
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			db.findResidentBySsn("1503920574").get(0).getSsn();
		});
	}

	@Test
	void testid3() throws DataAccessException, SQLException {
		// Arrange
		ResidentDB db = new ResidentDB();
		String testSSN = "120493654";

		// Act

		// Assert
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			db.findResidentBySsn("120493654").get(0).getSsn();
		});
	}
}