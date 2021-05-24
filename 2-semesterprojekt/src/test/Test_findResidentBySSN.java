package test;

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
		int JoestarSSN = 4700540903;
		// Act
		residentdb.findResidentBySsn(4700540903);
		// Assert
	}
}
