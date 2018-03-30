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
				Timestamp ts = rs.getTimestamp("taskCreateTime");
				// adding tasks to list
				GetSet set = new GetSet(label, title, task ,reminder,ts);
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
	public void addTask(int id,String label, String title, String name, String priority, String reminder,Timestamp ts) throws Exception{
	
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
			String sql = "insert into individual values(NULL,?,?,?,?,?,?)";
			
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
			
			stmt.setTimestamp(6, ts);
			
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

	public List<GetSet> getCalenderList(int id, String date, String month, String year) {
		System.out.println(" date,month,year for id = " + date +" " + month + " " + year+ " " + id );
		if(id == 0 ) {
			id = GetSet.id;
		}
		List<GetSet> lists = new ArrayList<>();
		DataBaseDAO dd = new DataBaseDAO();
		lists =  dd.getList(id);
		
		List<GetSet> updatedList = new ArrayList<>();
		try {
		int da = Integer.parseInt(date);
		int mo = Integer.parseInt(month);
		int ye = Integer.parseInt(year);
		
		for(int i = 0 ; i < lists.size() ; i++) {
			
			String yea = "";
			int y1 = 0, m1 = 0, d1 = 0 ;
			int y = 0, m = 0, d = 0;
			
			String findYear = lists.get(i).getTimestamp().toString();
			
			for(int l= 0 ; l < 4 ; l++) {
				yea += findYear.charAt(l);
			}
			 y = Integer.parseInt(yea);
			
			String mon = "" ;
			mon += findYear.charAt(5);
			mon += findYear.charAt(6);
			
			 m = Integer.parseInt(mon);
			
			String dday = "" ;
			dday += findYear.charAt(8);
			dday += findYear.charAt(9);
	
			 d = Integer.parseInt(dday);
			
		//	System.out.println("create : "+ i + "y m d : " + y+" "+m+ " "+d);
			
			String end = lists.get(i).getReminder();
			
			if(end != null) {
			if(end == null || end == "") {
				y1 = 0 ; m1 = 0 ; d1 = 0;
			}
			else {
				yea = "";
				for(int l= 0 ; l < 4 ; l++) {
					yea += end.charAt(l);
				}
				 y1 = Integer.parseInt(yea);
				 
				 String mon1 = "" ;
					mon1 += end.charAt(5);
					mon1 += end.charAt(6);
					
					m1 = Integer.parseInt(mon1);
					
					String dday1 = "" ;
					
					dday1 += end.charAt(8);
					dday1 += end.charAt(9);
					
					d1 = Integer.parseInt(dday1);
			}
			}
		//	System.out.println("end : " +i + "y m d : " + y1+" "+m1+ " "+d1);
			if( (end != null) ) {
				
				if( (da == d && mo == m && ye == y) || (da == d1 && mo == m1 && ye == y1)) {
					updatedList.add(lists.get(i));
				}
			}
			else if( end == null ){
		
				if( (da == d && mo == m && ye == y) ) {
					updatedList.add(lists.get(i));
				}
			}
		}
		}catch (Exception e) {
			System.out.println(e+" update task ");
		}
		return updatedList;

		
/*		 		
 		List<GetSet> updatedList = new ArrayList<>();
 		int da = Integer.parseInt(date);
		int mo = Integer.parseInt(month);
		int ye = Integer.parseInt(year);
		
		for(int i = 0 ; i < lists.size() ; i++) {
			String yea = "";
			String findYear = lists.get(i).getTimestamp().toString();
			for(int l= 0 ; l < 4 ; l++) {
				yea += findYear.charAt(l);
			}
			int y = Integer.parseInt(yea);
			int m = lists.get(i).getTimestamp().getMonth()+1;
			int d = lists.get(i).getTimestamp().getDate();
			//System.out.println("create : "+ i + "y m d : " + y+" "+m+ " "+d);
			
			String end = lists.get(i).getReminder();
			Timestamp t = Timestamp.valueOf(end);
			
			findYear = String.valueOf(t.getYear());	
			int y1 = Integer.parseInt(yea);
			int m1 = t.getMonth()+1;
			int d1 = t.getDate();
		//	System.out.println("end : " +i + "y m d : " + y1+" "+m1+ " "+d1);
			if( (da == d && mo == m && ye == y) || (da == d1 && mo == m1 && ye == y1)) {
				updatedList.add(lists.get(i));
			}
		}
		return updatedList;
*/
	}
}
