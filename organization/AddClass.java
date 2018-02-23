package organization;

import registration_login.CreateConnection;
import java.sql.*;

/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;		*/


public class AddClass {

	// adding new employee
	public void addEmployee(Task d1) throws Exception{
		try {
			
			// get connection object
			Connection conn = CreateConnection.ConnectionGet();
			PreparedStatement psmt1 = null;
			PreparedStatement psmt2 = null;
			PreparedStatement psmt3 = null;
			
			int deptid = 0;
			ResultSet rs = null ;
			
			// fetch department name based on deptId
			String query = "select deptId from department where deptName=?";

			psmt1 = conn.prepareStatement(query);
			psmt1.setString(1, d1.detpName);
			
			rs = psmt1.executeQuery();
			while(rs.next()) {
				deptid = rs.getInt("deptId");
			}
			
			// insert details into employee table 
			String query1 = "insert into employee values(NULL,?,?,?,?)";
			psmt1 = conn.prepareStatement(query1);
			psmt1.setString(1, d1.empName);
			psmt1.setString(2, d1.userName);
			psmt1.setString(3, d1.password);
			psmt1.setInt(4, deptid);
			psmt1.executeUpdate();
			
			// insert details into login table 
			String query2 = "insert into login values(NULL,?,?,?,?)";
			psmt2 = conn.prepareStatement(query2);
			psmt2.setString(1,d1.userName);
			psmt2.setString(2, d1.password);
			psmt2.setString(3, "organization");
			psmt2.setInt(4, 1);
			psmt2.executeUpdate();
			psmt2.close();
			
			// insert details into registration table 
			String query3 = "insert into registration values(NULL,?,?,?,?,?,?,?,?)";
			psmt3 = conn.prepareStatement(query3);
			psmt3.setString(1, d1.empName);
			psmt3.setString(2, "");
			psmt3.setString(3, d1.userName);
			psmt3.setString(4, d1.password);
			psmt3.setString(5, "organization");
			psmt3.setString(6, "");
			psmt3.setString(7, "");
			psmt3.setInt(8, 1);
			psmt3.executeUpdate();
			psmt3.close();
			
			conn.close();
			psmt1.close();
			psmt2.close();
			psmt3.close();
		}catch (Exception e) {
			System.out.println(e + " three");
		}
	}

	// adding new department 
	public void addDepartment(Task d1) {
		try {
		
			// get connection object
			Connection conn = CreateConnection.ConnectionGet();
			
			PreparedStatement psmt = null;
			
			// query
			String query = "insert into department values(NULL,?)";
			
			psmt = conn.prepareStatement(query);
			psmt.setString(1, d1.getDetpName());
		
			psmt.executeUpdate();
			
			conn.close();
			psmt.close();
			
		}catch (Exception e) {
			System.out.println(e + " five");
		}
	}

	// adding new project
	public void addProject(Task d1) {
	
		try {
		
			// get connection object
			Connection conn = CreateConnection.ConnectionGet();
			
			PreparedStatement psmt = null;
			int deptId = 0;
			ResultSet rs = null ;
			
			// query to get department id
			String query = "select deptId from department where deptName=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, d1.detpName);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				deptId = rs.getInt("deptId");
			}
			
			// insert department ID and project name into project table
			String query1 = "insert into project values(NULL,?,?)";
			
			psmt = conn.prepareStatement(query1);
			
			psmt.setString(1, d1.projName);
			psmt.setInt(2, deptId);
				
			psmt.executeUpdate();
			
			conn.close();
			psmt.close();
			
		}catch(Exception e) {
			System.out.println(e + "seven");
		}
	}
	
	// adding new Module
	public void addModule(Task d1 ) {
		
		try {
			
			// get connection object
			Connection conn = CreateConnection.ConnectionGet();
			
			PreparedStatement psmt = null;
			
			int projid = 0;
			ResultSet rs = null ;
			
			// Query to get project id
			
			String query = "select projId from project where projName=?";
			
			psmt = conn.prepareStatement(query);
			psmt.setString(1, d1.projName);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				projid = rs.getInt("projId");
			}
				
			// insert module name and project id into module table 
			String query1 = "insert into module values(NULL,?,?)";

			psmt = conn.prepareStatement(query1);
			
			psmt.setString(1, d1.modName);
			psmt.setInt(2, projid);
			
			psmt.executeUpdate();
			
			conn.close();
			psmt.close();
			
		}catch(Exception e) {
			System.out.println(e + "nine");
		}
	}

	// adding new task
	public void addTask(Task d1) {
		
		try {

			// get connection object
			Connection conn = CreateConnection.ConnectionGet();	
			
			PreparedStatement psmt = null;
			
			int modid = 0;
			int projid = 0 ;
			
			ResultSet rs = null ;
			
			// get moduleId, projectId from module table
			String query = "select modId,projId from module where modName=?";
			
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, d1.modName);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				modid = rs.getInt("modId");
				projid = rs.getInt("projId");
			}
			
			int deptid = 0 ;
			psmt = null;
			
			// get department id from project table
			String query2 = "select deptId from project where projId=?";
			
			psmt = conn.prepareStatement(query2);
			
			psmt.setInt(1, projid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				deptid = rs.getInt("deptId");
			}
			
			// insert details into task table
			String query1 = "insert into task values(NULL,?,?,?,?,?,?,?,?,?)";
			
			psmt = conn.prepareStatement(query1);
			psmt.setString(1, d1.taskName);
			
			if(d1.getStartTime().equals("")) {
				psmt.setTimestamp(2, null);
			}
			else {
				psmt.setTimestamp(2, Timestamp.valueOf(d1.getStartTime()));
			}
		
			if(d1.getEndTime().equals("")) {
				psmt.setTimestamp(3, null);
			}
			else {
				psmt.setTimestamp(3, Timestamp.valueOf(d1.getEndTime()));
			}
			
			psmt.setInt(4, d1.priority);
			psmt.setInt(5, 0);
			psmt.setInt(6, deptid);
			psmt.setInt(7, modid);
			psmt.setInt(8, projid);
			psmt.setInt(9, 1);
			psmt.executeUpdate();
			
			conn.close();
			psmt.close(); 
			
		}catch(Exception e) {
			System.out.println(e + "eleven");
		}
	}

	// assign task to employee
	public void TaskToEmp(String emp, String task) {
		try {
			
			int empId = 0 ;
			
			// get connection object
			Connection conn = CreateConnection.ConnectionGet();	
			
			PreparedStatement psmt = null;
			
			ResultSet rs = null ;
			
			// get employee Id from employee table
			String query = "select eid from employee where userName=?";
		
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, emp);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				empId = rs.getInt("eid");
			}
	
			// change task assignment to employee
			String query1 = "update task set eid=? where taskName=?";
	
			psmt = conn.prepareStatement(query1);
			
			psmt.setInt(1, empId);
			psmt.setString(2, task);
			
			psmt.executeUpdate();
			
			conn.close();
			psmt.close();
			
		}catch(Exception e) {
			System.out.println(e + "512");
		}
	}
}
