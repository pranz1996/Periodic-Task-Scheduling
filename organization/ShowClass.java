package organization;

import java.sql.*;
import java.util.*;

import registration_login.CreateConnection;

public class ShowClass {

	// return all departments
	public static ArrayList<Task> showDepartments() {
		
		Connection conn = null ;
		Statement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of departments
		ArrayList<Task> dept = new ArrayList<>();
		
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to fetch all departments
			String query = "select * from department";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("deptId");
				String name = rs.getString("deptName");
			
				Task d = new Task();
				
				d.setDeptid(id); 
				d.setDetpName(name);
				dept.add(d);
			}
		}catch(Exception e) {
			System.out.println(e + "13");
		}
		// return department lists
		return dept;
	}

	// return all projects
	public static ArrayList<Task> showProjects() {
		
		Connection conn = null ;
		Statement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of projects
		ArrayList<Task> proj = new ArrayList<>();
		
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
	
			// query to fetch all projects
			String query = "select * from project";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("projId");
				String name = rs.getString("projName");
			
				Task p = new Task();
				
				p.setProjid(id);
				p.setProjName(name);
				
				proj.add(p);
			}
		}catch(Exception e) {
			System.out.println(e + "15");
		}
		// return list of projects
		return proj;
	}
	
	// return all modules
	public static ArrayList<Task> showModules() {
		
		Connection conn = null ;
		Statement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of modules
		ArrayList<Task> modu = new ArrayList<>();
		
		try {
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to get all modules
			String query = "select * from module";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
			
				int id = rs.getInt("modId");
				String name = rs.getString("modName");
				
				Task m = new Task();
				
				m.setModid(id);
				m.setModName(name);
				
				modu.add(m);
			}
		}catch(Exception e) {
			System.out.println(e + "16");
		}
		// return list of modules
		return modu;
	}
	
	// return list of employees
	public static ArrayList<String> showEmployees() {
		
		Connection conn = null ;
		Statement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of employess
		ArrayList<String> emp = new ArrayList<>();
		
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// list of employees
			String query = "select * from employee";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				emp.add(rs.getString("userName"));
			}
		}catch(Exception e) {
			System.out.println(e + "17");
		}
		// return employees list
		return emp;
	}
	
	// return  tasks based on task status
	public static ArrayList<Task> showTasks(int status) {
		
		Connection conn = null ;
		PreparedStatement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of tasks
		ArrayList<Task> task = new ArrayList<>();
		
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
		
			// query to get tasks based on task status
			String query = "select * from task where taskStatus=? ";
		
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, status);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("taskName");
				String endtime = "";
				if(rs.getTimestamp("endTime") == null) {
					endtime = null;
				}
				else {
					endtime = rs.getTimestamp("endTime").toString();
				}
				int priority = rs.getInt("priority");
			
				Task e = new Task(name, endtime, priority);
				
				task.add(e);
			}
		}catch(Exception e) {
			System.out.println(e + "18");
		}
		// return list of tasks
		return task;
	}
	
	// returning task list (To-do)
	public static ArrayList<String> showTasksTODO() {
		
		Connection conn = null ;
		PreparedStatement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of tasks
		ArrayList<String> task = new ArrayList<>();
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to get tasks
			String query = "select * from task where taskStatus=? AND eid is NULL OR eid=?";
		
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, 1);
			stmt.setInt(2,0);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				task.add(rs.getString("taskName"));
			}
		}catch(Exception e) {
			System.out.println(e + "1008");
		}
		// return list of tasks
		return task;
	}
}
