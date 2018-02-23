package individual.user;

import java.util.*;
import java.sql.*;

import registration_login.CreateConnection;

public class DataBaseDAO {

	// based on unique ID - get all task details
	public List<GetSet> getList(int id) {
		
		// list of all the tasks
		List<GetSet> lists = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		try {
			// fetch connection 
			conn = CreateConnection.ConnectionGet();
			
			// Query
			String sql = "select * from individual where logId=? order by indid DESC";
			stmt = conn.prepareStatement(sql);

			// setting parameters to query
			GetSet.id = id ;
			stmt.setInt(1, id);
			
			// query execution
			rs = stmt.executeQuery();
			
			// fetch database data
			while(rs.next()) {
				String label = rs.getString("taskLabel");
				String title = rs.getString("taskTitle");
				String task = rs.getString("taskName");
				String reminder = rs.getString("taskReminder");
			
				// adding tasks to list
				GetSet set = new GetSet(label, title, task ,reminder);
				lists.add(set);	
			}
		}
		catch(Exception e) {
			System.out.println(e + "1");
		}
		// return all tasks
		return lists;
	}
	
	// get all the tasks under particular label
	public List<GetSet> getListOfLabel(int id,String label) {
		
		// list of all tasks
		List<GetSet> lists = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		try {
			// fetch connection
			conn = CreateConnection.ConnectionGet();
			
			// Query
			String sql = "select * from individual where logId=? AND taskLabel=?  order by indid DESC";
			stmt = conn.prepareStatement(sql);

			// setting parameters Query
			GetSet.id = id ;
			stmt.setInt(1, id);
			stmt.setString(2, label);
			
			// Query execute
			rs = stmt.executeQuery();
			
			// fetching database data
			while(rs.next()) {
				String title = rs.getString("taskTitle");
				String task = rs.getString("taskName");
				String reminder = rs.getString("taskReminder");
				
				// adding tasks to list
				GetSet set = new GetSet(label, title, task, reminder);
				lists.add(set);
			}
		}
		catch(Exception e) {
			System.out.println(e + "1");
		}
		// return list of tasks
		return lists;
	}

	// adding new task 
	public void addTask(int id,String label, String title, String name, String priority, String reminder) throws Exception{
	
		Connection conn = null ;
		PreparedStatement stmt = null ;
		
		// if empty html fields, set it to null to store in database
		if(label.equals("")) {
			label = null;
		}
		if(title.equals("")) {
			title = null;
		}
		
		try {
			// fetch database connection
			conn = CreateConnection.ConnectionGet();
			
			// Query to insert new task
			String sql = "insert into individual values(NULL,?,?,?,?,?)";
			
			// setting parameters
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2,label);
			stmt.setString(3, title);
			stmt.setString(4, name);
		
			Timestamp t = null;
			if(reminder.equals("")) {
				stmt.setTimestamp(5, null);
			}
			else {
				t = Timestamp.valueOf(reminder);
				stmt.setTimestamp(5, t);
			}
			
			// Query execute
			stmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	// get Login id - based on username
	public int getLogId(String uname){
		
		Connection conn = null ;
		ResultSet rs = null ;
		PreparedStatement stmt = null ;
		
		int id = 5;
		
		try {
			
			// fetch connection
			conn = CreateConnection.ConnectionGet();
			
			// query to fetch login id from username
			String query = "select logId from login where userName=?";
		
			stmt = conn.prepareStatement(query);
			
			// setting parameter
			stmt.setString(1, uname);
		
			// Query execute
			rs = stmt.executeQuery();
			
			// fetch login ID
			while(rs.next()) {
				id = rs.getInt("logId");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return id;
	}
}
