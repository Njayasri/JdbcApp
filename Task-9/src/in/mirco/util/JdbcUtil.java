package in.mirco.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getJdbcConnection() throws SQLException, IOException {

//		// Take the data from properties file
//		FileInputStream fis = new FileInputStream("C:\\Users\\Trilok\\OneDrive\\Desktop\\AssignmentCoreJava\\Task-9\\src\\in\\micro\\properties\\application.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//
//		// Step2. Establish the Connection
//		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
//				properties.getProperty("username"), properties.getProperty("password"));
		
//		return connection;
		
		HikariConfig config = new HikariConfig("C:\\Users\\Trilok\\OneDrive\\Desktop\\AssignmentCoreJava\\Task-9\\src\\in\\micro\\properties\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();

	}


	

}
