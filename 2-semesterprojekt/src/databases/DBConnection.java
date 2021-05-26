package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection = null;
	private static DBConnection dbConnection;

	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "dmab0920_1086253";
	private static final String serverAddress = "hildur.ucn.dk";
	// private static final String serverAddress = "192.168.56.2";
	private static final int serverPort = 1433;
	private static final String userName = "dmab0920_1086253";
	private static final String password = "Password1!";

	private DBConnection() {
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s",
				serverAddress, serverPort, dbName, userName, password);

		try {
			Class.forName(driverClass);

			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Could not connect to database " + dbName + "@" + serverAddress + ":" + serverPort
					+ " as user " + userName + " using password ******");
			System.out.println("Connection string was: "
					+ connectionString.substring(0, connectionString.length() - password.length()) + "....");
			e.printStackTrace();
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
	
	public void startTransaction() throws DataAccessException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not start transaction.", e);
		}
	}

	public void commitTransaction() throws DataAccessException {
		try {
			try {
				connection.commit();
			} catch (SQLException e) {
				throw e;
				// e.printStackTrace();
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not commit transaction", e);
		}
	}
	
	public void rollbackTransaction() throws DataAccessException {
		try {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw e;
				// e.printStackTrace();
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not rollback transaction", e);
		}
	}

	public boolean isDbConnected() {
		
		    try {
		        return connection != null && !connection.isClosed();
		    } catch (SQLException ignored) {}

		    return false;
		
		
	}
}
