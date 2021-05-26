package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import databases.AssistiveDeviceInstanceDB;
import databases.DataAccessException;

public class Test_findInstanceByDeviceId {
	@BeforeEach
	void setup() throws DataAccessException, SQLException {

	}

	@Test
	void testid1() throws DataAccessException, SQLException {
		// Arrange
		AssistiveDeviceInstanceDB db = new AssistiveDeviceInstanceDB();
		int expectedId = 1;
		// Act

		// Assert
		assertEquals(expectedId, db.findInstancesByDeviceId(1).get(0).getId());
	}

	@Test
	void testid2() throws DataAccessException, SQLException {
		// Arrange
		AssistiveDeviceInstanceDB db = new AssistiveDeviceInstanceDB();
		// Act

		// Assert
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			db.findInstancesByDeviceId(10).get(0).getId();
		});
	}
}