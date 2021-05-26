package databases;

import java.time.LocalDate;
import java.util.List;

import model.Rental;

public interface IRentalDB {
	public List<Rental> findRentalsByDateAndAssistiveDeviceId(int assistiveDeviceId, LocalDate startDate, LocalDate endDate) throws DataAccessException;
}