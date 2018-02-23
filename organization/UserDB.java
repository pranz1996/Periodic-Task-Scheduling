package organization;

import java.sql.*;
import java.util.*;

import registration_login.CreateConnection;

public class UserDB {
	
	// get all tasks details
	public List<Task> getAllDetails(){
		
		// list of task details
		List<Task> list = new ArrayList<>();
		
		Connection conn = null;
		ResultSet rs =  null ;
		PreparedStatement psmt = null ;
		ResultSet rs1 = null ;
		PreparedStatement psmt1 = null;
		
		try {
			// fetch database connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to fetch all the tasks
			String query = "select * from task order by endTime";
		
			psmt = conn.prepareStatement(query);
			
			// execute query
			rs = psmt.executeQuery();
			
			// get task details
			while(rs.next()) {
			
				rs1 = null ;
				psmt1 = null ;
				
				String tname = "";
				int eid = 0;
				int status = 0 ;
				
				String empname = "";
				String tstatus = "";
				
				// setting taskName 
				tname = rs.getString("taskName");
				
				// setting employee name from 'employee id-unique'
				eid = rs.getInt("eid");
				if(eid != 0) {
				
					// fetch employee Name query 
					String getEmp = "select empName from employee where eid=?";
					psmt1 = conn.prepareStatement(getEmp);
					psmt1.setInt(1, eid);
					rs1 = psmt1.executeQuery();
					while(rs1.next()) {
						empname = rs1.getString("empName");
					}
				}
				else {
					empname = "";
				}
						
				psmt1 = null; 
				rs1 = null ;
				
				// 1 : To Do
				// 2 : In Progress
				// 3 : Done
				// taskStatus setting
				status = rs.getInt("taskStatus");
				
				if(status == 1) {
					tstatus = "To Do";
				}
				else if(status == 2) {
					tstatus = "In Progress";
				}
				else if(status == 3) {
					tstatus = "Done";
				}
				
				// setting start time 
				String stime = "";
				Timestamp st = null;
				st = rs.getTimestamp("startTime");
				if(st != null) { 	
					stime = st.toString();
				}
				else {
					stime = "";
				}
							
				// setting deadline
				String etime = "";
				Timestamp et = null ;
				et = rs.getTimestamp("endTime");
				if(et != null) {
					etime = et.toString();
				}
				else {
					etime = "";
				}

				psmt1 = null; 
				rs1 = null ;
			
				// setting module name from 'module id-unique'
				int modid = rs.getInt("modId");
				
				String getMod = "";
				
				// module name fetch query
				getMod = "select modName from module where modId=?";
				psmt1 = conn.prepareStatement(getMod);
				psmt1.setInt(1, modid);
				rs1 = psmt1.executeQuery();
				String modName = "";
				while(rs1.next()) {
					modName = rs1.getString("modName");
				}
				
				psmt1 = null ;
				rs1 = null ;
				
				// setting project name from 'project id-unique'
				int projid = rs.getInt("projId");
				
				// project name fetch query
				String getProj = "select projName from project where projId=?";
				psmt1 = conn.prepareStatement(getProj);
				psmt1.setInt(1, projid);
				rs1 = psmt1.executeQuery();
				String projName = "";
				while(rs1.next()) {
					projName = rs1.getString("projName");
				}
			
				psmt1 = null ;
				rs1 = null ;
				
				// setting department name from 'department id-unique'
				int deptid = rs.getInt("deptId");
				
				// department name fetch query
				String getDept = "select deptName from department where deptId=?";
				psmt1 = conn.prepareStatement(getDept);
				psmt1.setInt(1, deptid);
				rs1 = psmt1.executeQuery();
				String deptName = "";
				while(rs1.next()) {
					deptName = rs1.getString("deptName");
				}
								
				int priority = rs.getInt("priority");
				
				int taskId = rs.getInt("taskId");
				
				// settting task with all details
				Task details = new Task(taskId,tname, empname, tstatus, stime, etime, priority, modName, projName, deptName);
				
				// add task to task-list
				list.add(details);
			}
		}
		catch(Exception e) {
			System.out.println(e+ " 1000");
		}
		// return list of tasks
		return list;
	}
	
	
	// changing task status
	public void changeTaskStatus(int statusId, String taskname, Timestamp start, Timestamp end) {
		
		String query1 = "" , query2 = "";
		
		Connection conn = null;
		PreparedStatement psmt = null , psmt1 = null;
		
		try {
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// from to-do to doing
			if(statusId == 2) {
				
				// update taskStatus query
				query1 = "update task set taskStatus=?,startTime=? where taskName=? order by endTime";
	
				psmt = conn.prepareStatement(query1);
				
				// setting parameters
				psmt.setInt(1, statusId);
				psmt.setTimestamp(2, start);
				psmt.setString(3, taskname);
				
				// executing the query
				psmt.executeUpdate();
			
			}
			// from doing to done
			else if(statusId == 3) {
				
				// update taskStutus query
				query2 = "update task set taskStatus=?,endTime=? where taskName=?";
				
				psmt1 = conn.prepareStatement(query2);
				
				// setting parameters
				psmt1.setInt(1, statusId);
				psmt1.setTimestamp(2, end);
				psmt1.setString(3, taskname);
			
				// executing the query
				psmt1.executeUpdate();
			}
		}catch(Exception e) {
			System.out.println(e + "601");
		}
	}
	
	
	
	// show Tasks to-do, doing and done list-wise
	public  ArrayList<Task> showTasks(int id,int status) {
		
		Connection conn = null ;
		PreparedStatement stmt =  null ;
		ResultSet rs = null ; 
		
		// list of task 
		ArrayList<Task> task = new ArrayList<>();
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to get task
			String query = "select * from task where eid=? AND taskStatus=? ";
			
			stmt = conn.prepareStatement(query);
			
			// setting parameters
			stmt.setInt(1, id);
			stmt.setInt(2, status);
			
			// exexuting the query
			rs = stmt.executeQuery();
			
			// all tasks
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
		// tasks' list
		return task;
	}
	
	
	
	// get all tasks for particular employee
	public List<Task> getList(String uname){
		
			// getting username 
			SetId.uname = uname;
			
			// list of tasks
			List<Task> lists = new ArrayList<>();
			
			Connection conn = null ; 
			conn = CreateConnection.ConnectionGet();
			ResultSet rs = null ;
			PreparedStatement psmt = null; 
		
			int id = 0 ;
			
			try {
				// fetch employee-id(unique) based on username 
				String query = "select eid from employee where userName=?";
				
				psmt = conn.prepareStatement(query);
				
				// setting parameters
				psmt.setString(1, uname);
				
				// executing query
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					id = rs.getInt("eid");
				}
				
				// setting employee-id(unique)
				SetId.eid = id;
			}catch(Exception e) {
				System.out.println(e + "511");
			}
			
			rs = null ; 
			psmt = null ;
			
			try {

					String query1 = "select deptId,modId,projId,taskName,taskStatus from task where eid=?";
					
					psmt = conn.prepareCall(query1);
					psmt.setInt(1, id);
					
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						
						int deptid = rs.getInt("deptId");
						int projid = rs.getInt("projId");
						int modid = rs.getInt("modId");
						String task = rs.getString("taskName");
						int status = rs.getInt("taskStatus");
						
						// Fetch data 
						
						ResultSet rs1 = null ;
						PreparedStatement psmt1 = null; 
						String deptname = "";
						
						// fetch department name from 'deptId-unique'
						try {
							String q1 = "select deptName from department where deptId=?";
							psmt1 = conn.prepareStatement(q1);
							psmt1.setInt(1, deptid);
							rs1 = psmt1.executeQuery();
							while(rs1.next()) {
								deptname = rs1.getString("deptName");
							}
						}catch(Exception e) {
							System.out.println(e + "514");
						}
						
						rs1 = null ; psmt1 = null;
						
						String projname = "";
						
						// fetch project name from 'projId-unique'
						try {
							String q2 = "select projName from project where projId=?";
							psmt1 = conn.prepareStatement(q2);
							psmt1.setInt(1, projid);
							rs1 = psmt1.executeQuery();
							while(rs1.next()) {
								projname = rs1.getString("projName");
							}
						}catch(Exception e) {
							System.out.println(e + "515");
						}
						
						rs1=null ; psmt1 = null ;
						String modname = ""; 
					
						// fetch module name from 'modId-unique'
						try {
							String q3 = "select modName from module where modId=?";
							psmt1 = conn.prepareStatement(q3);
							psmt1.setInt(1, modid);
							rs1 = psmt1.executeQuery();
							while(rs1.next()) {
								modname = rs1.getString("modName");
							}
						}catch(Exception e) {
							System.out.println(e + "516");
						}
						
						
						String taskStatus = "";
						if(status == 1) {
							taskStatus = "TO-DO";
						}else if(status == 2) {
							taskStatus = "IN PROGRESS";
						}else if(status == 3) {
							taskStatus = "DONE";
						}
						
						// setting task date
						Task t1 = new Task(deptname,projname,modname,task,taskStatus);
						
						// add task to list
						lists.add(t1);
					} 
			}catch(Exception e) {
				System.out.println(e + "513");
			}
		// returning list of tasks
		return lists;
	}
}
