package individual.user;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Individual")
public class Individual extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	// static variable to set 'log' variable to check if the current session or new
	private static int log = 0 ;
	
	public static void setLog(int log) {
		Individual.log = log;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// List all the 'tasks' on Individual Dashboard
			listTasks(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// adding new 'task'
			addTask(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listTasks(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// fetch session to check session
		HttpSession session = request.getSession();
		
		try {
			// DAO object
			DataBaseDAO dataBaseDAO = new DataBaseDAO();
			int id ;
		
			// when new user-login, session will '0', so set login id to static variable 'log'
			if(log == 0) {
				id = (int) session.getAttribute("user");
			}
			// when current session, fetch 'id' value from static variable value 'log'
			else {
				id = log;
			}
		
			// update static variable value
			log = id ;
		
			// DAO method : get all the tasks based on particular 'id'- unique for each user 
			List<GetSet> set = dataBaseDAO.getList(id);
	
			// set the TASK to show on 'view' page
			request.setAttribute("THE_TASKS", set);
			
			}catch(Exception e) {
				System.out.println(e+"603");
			}
			
			// context sending to view page
			RequestDispatcher dispatch = request.getRequestDispatcher("individual.jsp");
			dispatch.forward(request, response);
	}


	private void addTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DAO object
		DataBaseDAO dataBaseDAO = new DataBaseDAO();
	
		// setting the session 'ID- static variable log'
		int sessionId = log ;
		
		// fetch data of html fields
		String label = request.getParameter("label");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String priority = request.getParameter("priority");
		String reminder = request.getParameter("reminder");
		
		// DAO method : add new task details based on ID- unique of each
		dataBaseDAO.addTask(sessionId,label, title, name, priority, reminder);
		
		// after adding new task, forward to listing all tasks
		try {
			listTasks(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

