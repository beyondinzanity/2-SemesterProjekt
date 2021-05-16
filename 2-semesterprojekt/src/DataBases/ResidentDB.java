package DataBases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelLayer.DBConnection;

public class ResidentDB {
	
	private static final String FIND_BY_ID = "select * from Customer where id = ?";
	private static final String FIND_BY_EMAIL = "select * from Customer where email = ?";
	private PreparedStatement findCustomerByIdPS;
	private PreparedStatement findCustomerByEmailPS;

	public ResidentDB() throws Exception {

		Connection con = DBConnection.getInstance().getConnection();

		findCustomerByIdPS = con.prepareStatement(FIND_BY_ID);
		findCustomerByEmailPS = con.prepareStatement(FIND_BY_EMAIL);

	}

}
