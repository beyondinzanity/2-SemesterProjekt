package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RentalController;
import databases.DataAccessException;

public class Test_setResident {

	@BeforeEach
	void setup() throws DataAccessException, SQLException {

	}

	@Test
	void testid1() throws DataAccessException, SQLException {
		// Arrange
		RentalController rt = new RentalController();
		String testFname = "Hening";

		// Act
		rt.findResidentBySsn("1804646469");
		rt.setResident("1804646469");

		// Assert
		assertEquals(testFname, rt.getRental().getResident().getFname());
	}

	@Test
	void testid2() throws DataAccessException, SQLException {

	}
}
