package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection = null;
	private static DBConnection dbConnection;

	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "GuldBoSund_Database";
	private static final String serverAddress = "LAPTOP-JNG5M54Q\\SQLEXPRESS";
	// private static final String serverAddress = "192.168.56.2";
	private static final int serverPort = 1433;
	//private static final String userName = "LAPTOP-JNG5M54Q/Theis Nielsen Haahr";
	//private static final String password = "secret";

	private DBConnection() {
//		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s",
//				serverAddress, serverPort, dbName, userName, password);
		String connectionString2 = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;",
				serverAddress, serverPort, dbName); //TEST M� GERNE SLETTES
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString2); //TEST M� GERNE SLETTES!
			
//			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fejl SQL"); //TEST M� GERNE SLETTES
//			System.err.println("Could not connect to database " + dbName + "@" + serverAddress + ":" + serverPort
//					+ " as user " + userName + " using password ******");
//			System.out.println("Connection string was: "
//					+ connectionString.substring(0, connectionString.length() - password.length()) + "....");
//			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public Connection getConnection() {
		return connection;
	}
}
