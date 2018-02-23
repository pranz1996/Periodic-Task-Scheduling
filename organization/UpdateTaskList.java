package organization;

import java.sql.*;
/*		
import java.util.ArrayList;
import java.util.List;
*/

import registration_login.CreateConnection;

public class UpdateTaskList {

	// delete the task based on id of task
	public void deleteTask(int id) throws Exception{
	
		Connection conn = null ;
		PreparedStatement psmt = null ;
		
		try {
			
			// get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to delete task
			String sql = "delete from task where taskId=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id);
			
			int i = psmt.executeUpdate();
			System.out.println(i);
		}catch (Exception e) {
			System.out.println(e + "1123");
		}
	}

	// load the task details
	public Task LoadTaskDetails(int id) throws Exception{
		
		Task list = null ;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
		
			// get connection 
			conn = CreateConnection.ConnectionGet();
			
			// query to get task details
			String sql1 = "select * from task where taskId=?";
			
			psmt = conn.prepareStatement(sql1);
			
			psmt.setInt(1, id);
			
			rs =psmt.executeQuery();
			
			// get task details
			while(rs.next()) {
				String tname = rs.getString("taskName");
				String stime = "";
				if(rs.getTimestamp("startTime") == null) {
					
				}
				else {
					stime = rs.getTimestamp("startTime").toString();
				}
				String etime = ""; 
				if(rs.getTimestamp("endTime") == null) {
					
				}
				else {
					etime = rs.getTimestamp("endTime").toString();
				}
				int prio = rs.getInt("priority");
				int taskStatus = rs.getInt("taskStatus");
				System.out.println("status of task " + taskStatus);
				String status = "";
				if(taskStatus == 1) {
					status = "To Do";
				}
				else if(taskStatus == 2) {
					status = "In Progress";
				}
				else if(taskStatus == 3) {
					status = "Done";
				}
				
				list = new Task(tname, status, stime, etime, prio);
			}
		}catch(Exception e) {
			System.out.println(e+ "1501");
		}
		// return task
		return list;
	}
	
	// updating the task details
	public void updateTask(int id, String status, String emp,String task, String stime, String etime, int prio) throws Exception{
		
		Connection conn = null;
		ResultSet rs = null ;
		PreparedStatement psmt = null;
		
		int eId = 0 ;
		
		try {	
			
			// get connnection object
			conn = CreateConnection.ConnectionGet();
			
			// query to update task
			String 	q = "select eid from employee where userName=?";
				
			psmt = conn.prepareStatement(q);
		
			psmt.setString(1, emp);
		
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				eId = rs.getInt("eid");
			}
		}catch(Exception e) {
			System.out.println(e+ "8956");
		}
		psmt = null ;
		
		//  if stil task in to-do list, can change assignment
		try {
		if(status.equals("To Do")) {
			String queryWithE = "update task set eid=?,taskName=?,startTime=?,endTime=?,priority=? where taskId=?";
			psmt = conn.prepareStatement(queryWithE);
			
			psmt.setInt(1, eId);
			
			psmt.setString(2, task);
			
			if(stime.equals("") || stime.equals(null)) {
				psmt.setTimestamp(3, null);
			}
			else {
				psmt.setTimestamp(3, Timestamp.valueOf(stime));
			}
				
			if(etime.equals("") || etime.equals(null)) {
				psmt.setTimestamp(4, null);
			}
			else {
				psmt.setTimestamp(4, Timestamp.valueOf(etime));
			}
			
			psmt.setInt(5, prio);
			
			psmt.setInt(6, id);
			
			psmt.executeUpdate();
		}
		// if task is not in to-do list, then can't change assignment of task
		else {
			String queryWithoutE = "update task set taskName=?,startTime=?,endTime=?,priority=? where taskId=?";
		
			psmt = conn.prepareStatement(queryWithoutE);
				
			psmt.setString(1, task);
			
			if(stime.equals("") || stime.equals(null)) {
				psmt.setTimestamp(2, null);
			}
			else {
				psmt.setTimestamp(2, Timestamp.valueOf(stime));
			}
				
			if(etime.equals("") || etime.equals(null)) {
				psmt.setTimestamp(3, null);
			}
			else {
				psmt.setTimestamp(3, Timestamp.valueOf(etime));
			}
			
			psmt.setInt(4, prio);
			
			psmt.setInt(5, id);
			
			psmt.executeUpdate();
		}
	  }catch (Exception e) {
		System.out.println(e+"888+");
	}
	}
}
