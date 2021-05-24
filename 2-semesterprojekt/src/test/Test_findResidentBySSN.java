package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import databases.DataAccessException;
import databases.ResidentDB;

public class Test_findResidentBySSN {
	ResidentDB residentdb;

	@BeforeEach
	void setup() throws DataAccessException {

	}

	@Test
	void testid1() throws DataAccessException {
		// Arrange
		String bruhSSN = "4700540903";
		// Act
		residentdb.findResidentBySsn("4700540903");
		// Assert
		assertEquals(bruhSSN, residentdb.findResidentBySsn("4700540903"));
	}
}
