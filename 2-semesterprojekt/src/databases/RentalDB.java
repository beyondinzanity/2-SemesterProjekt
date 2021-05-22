package databases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Rental;



public class RentalDB {
	private static final String INSERT_RENTAL = "insert into Rental values (?, ?, ?, ?, ?, ?)";
	
	private PreparedStatement insertRental;
	Connection con; 
	
	public RentalDB() throws Exception{
		con = DBConnection.getInstance().getConnection();
		insertRental = con.prepareStatement(INSERT_RENTAL, PreparedStatement.RETURN_GENERATED_KEYS);
	}

	public void endRental(Rental rental) throws Exception {
		
		insertRental.setInt(1, rental.getRentalNumber());
		insertRental.setDate(2, rental.getStartDate());
		insertRental.setDate(3, rental.getEndDate());
		insertRental.setInt(4, rental.getEmployee().getEmployeeId());
		insertRental.setInt(5, rental.getAssistiveDeviceInstance().getId());
		insertRental.setInt(6, rental.getResident().getResidentId());
	
		rental.setRentalId(executeInsertWithIdentity(insertRental));
		
	}
	
    public int executeInsertWithIdentity(PreparedStatement ps) throws Exception {
        // requires prepared statement to be created with the additional argument PreparedStatement.RETURN_GENERATED_KEYS  
        int res = -1;
        try {
            res = ps.executeUpdate();
            if (res > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                res = rs.getInt(1);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new Exception("Could not execute insert", e);
        }
        return res;
    }

}
