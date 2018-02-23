package individual.user;

import java.sql.*;
import java.util.*;

import registration_login.CreateConnection;
public class DbUtil {

	// Get task to populate before update
	public GetSet getTask(String name) {
		
		Connection conn = null ;
		PreparedStatement psmt = null ;
		ResultSet rs = null;
		GetSet set = null ;
		
		try {
		
			// get connection
			conn = CreateConnection.ConnectionGet();
			
			// Query to get task
			String query = "select * from individual where taskName=?";
			
			psmt = conn.prepareStatement(query);
			
			// set parameter
			psmt.setString(1, name);
			
			// execute the query
			rs = psmt.executeQuery();
		
			// get task details
			while(rs.next()) {
				int id = rs.getInt("logId");
				String label = rs.getString("taskLabel");
				String title = rs.getString("taskTitle");
				String remind = rs.getString("taskReminder");
		
				// set details in getset
				set = new GetSet(id,label, title, name, remind);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		// return task
		return set;
	}

	// update the task
	public void updateTask(GetSet get, String name) {

		Connection conn = null ;
		PreparedStatement psmt = null ;
		
		try {
			
			//get connection object
			conn = CreateConnection.ConnectionGet();
			
			// query to update task
			String query = "update individual set taskLabel=?, taskTitle=?, taskName=?,  taskReminder=? where taskName=?";
			
			psmt = conn.prepareStatement(query);
			
			// set parameters
			if(get.getLabel().equals("")) {
				psmt.setString(1, null);
			}
			else {
				psmt.setString(1, get.getLabel());
			}
			psmt.setString(2, get.getTitle());
			psmt.setString(3, get.getName());
			
			String reminder = get.getReminder();
		
			if(reminder.equals(null) || reminder.equals("")) {
				psmt.setString(4, null);
			}
			else {
				psmt.setTimestamp(4, Timestamp.valueOf(reminder));
			}
					
			psmt.setString(5, name);
		
			// execute the query
			psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	// delete the task
	public void deleteTask(String taskname) {
	
		Connection conn = null ;
		PreparedStatement psmt = null ;
		
		try {
			
			// fetch the connection
			conn = CreateConnection.ConnectionGet();
			
			// query to delete the task
			String query = "delete from individual where taskName=?";
			
			psmt = conn.prepareStatement(query);
			
			// setting the parameter
			psmt.setString(1, taskname);
			
			// execute query
			psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// get task which have reminders
	public List<GetSet> getTaskByReminder() {
		
		Connection conn = null ;
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		// list to store tasks
		List<GetSet> lists = new ArrayList<>();;
		try {
			
			// fetch the connection
			conn = CreateConnection.ConnectionGet();
			
			// query to fetch all tasks with reminder
			String query = "select * from individual where logId=? AND taskReminder is not NULL";
		
			stmt = conn.prepareStatement(query);
			
			// set parameters
			stmt.setInt(1, GetSet.id);
		
			// execute query
			rs = stmt.executeQuery();
		
			// fetch tasks
			while(rs.next()) {
				String label = rs.getString("taskLabel");
				String title = rs.getString("taskTitle");
				String name = rs.getString("taskName");
				String remind = rs.getString("taskReminder");
				if(remind.equals("")) {
					// if task don't have reminder
				}
				// if task have reminder, then add it to list
				else {
					GetSet data = new GetSet(label, title, name, remind);
					lists.add(data);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e + "pranjal");
		}
		//  returning tasks list
		return lists;
	}

	// get labels
	public List<GetSet> getTaskByLabel() {
		
		Connection conn = null ;
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		// list to get all labels
		List<GetSet> lists = new ArrayList<>();
		try {
			
			// fetch connection
			conn = CreateConnection.ConnectionGet();
			
			// query to fetch tasks
			String query = "select distinct(taskLabel) from individual where logId=? AND taskLabel is not NULL";
			
			stmt = conn.prepareStatement(query);
			
			// setting parameter
			stmt.setInt(1, GetSet.id);
			
			// execute the query
			rs = stmt.executeQuery();
			
			// get database data 
			while(rs.next()) {
				String label = rs.getString("taskLabel");
				GetSet data = new GetSet(label);
				lists.add(data);
			}
		}
		catch (Exception e) {
			System.out.println(e + "here");
		}
		// return list of labels
		return lists;
	}

}
