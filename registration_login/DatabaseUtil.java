package registration_login;

import java.sql.*;

public class DatabaseUtil {

	// For registration of user, insert data into 'registration' and 'login' tables
	public int registerUser(GetterSetter set, String regQuery, String logQuery) throws Exception{
		
		Connection conn = null;
		int i = 0;
		int j = 0 ;
		try {
			conn = CreateConnection.ConnectionGet();
			PreparedStatement stmt = conn.prepareStatement(regQuery);
			stmt.setString(1, set.getFirstName());
			stmt.setString(2, set.getLastName());
			stmt.setString(3, set.getUserName());
			stmt.setString(4, set.getPassword());
			stmt.setString(5, set.getCategory());
			stmt.setString(6, set.getEmail());
			stmt.setString(7, set.getMobile());
		//	stmt.setInt(8, set.getOrgType());
			stmt.setInt(8, 0);
			i = stmt.executeUpdate();
			
			PreparedStatement stmt1 = conn.prepareStatement(logQuery);
			stmt1.setString(1, set.getUserName());
			stmt1.setString(2, set.getPassword());
			stmt1.setString(3, set.getCategory());
		//	stmt1.setInt(4, set.getOrgType());
			stmt1.setInt(4, 0);
			j = stmt1.executeUpdate();
			System.out.println(i+ " " + j);
			conn.close();
			stmt.close();
			stmt1.close();
			
		}catch(Exception e) {
			System.out.println(e+"100-1");
		}
		return i;
	}

	// For login of user, check the credentials  in 'registration' table
	public String loginUser(GetterSetter set, String validateQuery) {
		Connection conn = null ;
		conn = CreateConnection.ConnectionGet();
		
		// Login form data
		String user = set.getUserName();
		String passw = set.getPassword();
		String role = set.getCategory();
		
		try {
			
			ResultSet r1 = null;
			Statement stmt1 = null ;
			String dbuser1 = "" , dbpass1 = "" , dbrole1 = "";
			stmt1 = conn.createStatement();
			r1 = stmt1.executeQuery(validateQuery);
			
			while(r1.next()) {
				// 'registration' table data
				dbuser1 = r1.getString("userName");
				dbpass1 = r1.getString("password");
				dbrole1 = r1.getString("category");
				
				// if 'individual' user
				if(user.equals(dbuser1) && passw.equals(dbpass1) && role.equals(dbrole1) && role.equals("individual")) {
					return "individual";
				}
				// if 'organization-admin' iser
				else if(user.equals(dbuser1) && passw.equals(dbpass1) && role.equals(dbrole1) && role.equals("organization")) {
						return "organization";
					}
			}
			conn.close();
			
			r1.close();
			stmt1.close();
			
		}
		catch(Exception e) {
			System.out.println(e + "52");
		}
		
		return "invalid";
	}
// Future enhancement- If different types of organization
/*
	public int registerOrganization(String regQuery, String logQuery) {
		Connection conn = null;
		int i = 0, j = 0 ;
		GetSet get = new GetSet();
		try {
			conn = CreateConnection.ConnectionGet();
			PreparedStatement stmt = conn.prepareStatement(regQuery);
			stmt.setString(1, get.getFirstName());
			stmt.setString(2, get.getLastName());
			stmt.setString(3, get.getUserName());
			stmt.setString(4, get.getPassword());
			stmt.setString(5, get.getCategory());
			stmt.setString(6, get.getEmail());
			stmt.setString(7, get.getMobile());
			stmt.setInt(8, get.getOrgType());
			i = stmt.executeUpdate();
			
			PreparedStatement stmt1 = conn.prepareStatement(logQuery);
			stmt1.setString(1, get.getUserName());
			stmt1.setString(2, get.getPassword());
			stmt1.setString(3, get.getCategory());
			stmt1.setInt(4, get.getOrgType());
			j = stmt1.executeUpdate();
			System.out.println(i + " " + j);
			conn.close();
			stmt.close();
			stmt1.close();
			
		}catch(Exception e) {
			System.out.println(e+ "100");
		}
		return i;
	}
	*/
}
