package individual.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UpdateDelete")
public class UpdateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Update and delete any task information
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter to check load, update or delete task details
		String theCommand = request.getParameter("command");
		try {
			switch (theCommand) {
			case "LOAD":
				loadTask(request,response);
				break;
			case "UPDATE":
				updateTask(request,response);
				break;
			case "DELETE":
				deleteTask(request,response);
				break;
			}
		}catch (Exception e) {
			System.out.println(e + "2");
		}
	}

	private void loadTask(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Fetch name of the task
		String name = request.getParameter("Id");
		
		// DAO class object
		DbUtil dbUtil = new DbUtil();
		
		// get task details based on task name
		GetSet getSet = dbUtil.getTask(name);
		
		// getting session
		HttpSession session = request.getSession();
		
		// setting task details to session
 		session.setAttribute("TASK",getSet);
	
 		// resposd to view page
 		response.sendRedirect(request.getContextPath()+	"/update.jsp");
 	/*	RequestDispatcher dispatch = request.getRequestDispatcher("update.jsp");
		dispatch.forward(request, response);*/
	}
		
	private void updateTask(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		// GetSet object to store data
		GetSet get = new GetSet();
		
		// fetching up html data
		String taskname = request.getParameter("Id");
		String label = request.getParameter("label");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String reminder = request.getParameter("reminder");
		
		// set html data tp getset object
		get = new GetSet( label, title, name, reminder);
		
		// DbUtil object to update task
		DbUtil db = new DbUtil();
		
		// update the Task
		db.updateTask(get,taskname);
		
		// respond to view page, first context to 'Individual' servlet
		response.sendRedirect(request.getContextPath()+	"/Individual");
	}
	
	private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// take name of task
		String taskname = request.getParameter("Id");
		
		// DAO object
		DbUtil db = new DbUtil();
		
		// delete the task
		db.deleteTask(taskname);

		// respond to view page, first context to 'Individual' servlet
		response.sendRedirect(request.getContextPath()+ "/Individual");
	}

}
