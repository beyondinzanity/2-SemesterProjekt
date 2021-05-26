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
		RentalController rt = new RentalController();
		String testBarcode = "1337";

		// Act
		rt.findAssistiveDevices("Kran");
		rt.addAssistiveDeviceInstance(102273, "1337");
		// Assert
		assertEquals(testBarcode, rt.getRental().getAssistiveDeviceInstance().getBarcode());
	}
}