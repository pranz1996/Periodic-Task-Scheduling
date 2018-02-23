package registration_login;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	public static Connection ConnectionGet() {
		Connection conn = null ;
		
		// url of database schema 'Periodic Task Scheduling'
		String url = "jdbc:mysql://localhost:3306/periodic task scheduling";
		try {
			// Registering mysql Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection establishment
			conn = DriverManager.getConnection(url,"root","root");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
