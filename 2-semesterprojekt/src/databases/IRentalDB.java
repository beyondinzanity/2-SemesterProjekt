package databases;

import java.time.LocalDate;
import java.util.List;

import model.Rental;

public interface IRentalDB {
	public List<Rental> findRentalsByDateAndAssistiveDeviceInstanceId(int assistiveDeviceId, LocalDate startDate, LocalDate endDate) throws DataAccessException;
}