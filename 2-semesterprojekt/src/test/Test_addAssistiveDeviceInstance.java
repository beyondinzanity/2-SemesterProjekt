package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RentalController;
import databases.DataAccessException;

public class Test_addAssistiveDeviceInstance {

	@BeforeEach
	void setup() throws DataAccessException, SQLException {

	}

	@Test
	void testid1() throws DataAccessException, SQLException {
		// Arrange
		RentalController rtc = new RentalController();
		String testBarcode = "1337";

		// Act
		rtc.findAssistiveDevices("Kran");
		rtc.addAssistiveDeviceInstance(102273, "1337");
		// Assert
		assertEquals(testBarcode, rtc.getRental().getAssistiveDeviceInstance().getBarcode());
	}

	@Test
	void testid2() throws DataAccessException, SQLException {
		RentalController rtc = new RentalController();

		System.out.println(rtc.addAssistiveDeviceInstance(0, null));

//		Assertions.assertThrows(NullPointerException.class, () -> {
//			rtc.addAssistiveDeviceInstance(0, null);
//		});

		assertEquals(null, rtc.addAssistiveDeviceInstance(0, null));
	}
}