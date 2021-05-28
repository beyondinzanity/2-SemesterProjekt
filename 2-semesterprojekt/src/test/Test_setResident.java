package test;

import static org.junit.Assert.assertEquals;

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
		RentalController rtc = new RentalController();
		String testFname = "Hening";

		// Act
		rtc.findResidentBySsn("1804646469");
		rtc.setResident("1804646469");

		// Assert
		assertEquals(testFname, rtc.getRental().getResident().getFname());
	}

	@Test
	void testid2() throws DataAccessException, SQLException {
		RentalController rtc = new RentalController();

		rtc.setResident(null);
		assertEquals(null, rtc.getRental().getResident());

//		Assertions.assertThrows(NullPointerException.class, () -> {
//			rtc.setResident(null);
//		});
	}
}