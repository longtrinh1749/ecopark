package application.utils.db;

//this class define static const String for db connection
public class Config {
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "ecobikerentaldb";
	public static final String HOST_NAME = "localhost";
	public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME;
	public static final String USER = "root";
	public static final String PASS = "1091999";

}
