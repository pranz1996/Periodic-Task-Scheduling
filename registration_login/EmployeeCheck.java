package registration_login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeCheck {

	public static String check(String uname, String password,String category) {
		
		Connection conn = null ;
		ResultSet rs = null;
		Statement stmt = null ;
		
		// get connection to schema 'Periodic Task Scheduling'
		conn = CreateConnection.ConnectionGet();
		
		String user = uname;
		String passw = password;
		
		String dbuser = "" , dbpass = "" ;
		
		try{
		
			// select all employees from 'employee' Table
			String query = "select * from employee ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs != null) {
				while(rs.next()) {
					
					dbuser = rs.getString("userName");
					dbpass = rs.getString("password");
					
					// check if login credential match to 'employee'
					if(user.equals(dbuser)  && passw.equals(dbpass) && category.equals("organization")) {
						return "employee";
					}
				}
			}
		}catch (Exception e) {
			System.out.println(e + "51");
		}
		return "abc";
	}
}
