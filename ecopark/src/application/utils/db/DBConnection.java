package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection conn;
	
	public DBConnection() {
		
	}
	
	public static Connection openConnection() throws SQLException {
		try {
			// Register driver
			Class.forName(Config.JDBC_DRIVER);
			// Open connection
			conn = DriverManager.getConnection(Config.CONNECTION_URL, Config.USER, Config.PASS);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
