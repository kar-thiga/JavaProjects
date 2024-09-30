package air;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static final String url = "jdbc:mysql://localhost:3306/Airline";
	private static final String  userName = "root";
	private static final String passWord = "karthiga@123";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,userName,passWord);
	}

}
