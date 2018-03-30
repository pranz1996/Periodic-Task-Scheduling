package individual.user;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/CalendarIndividual")
public class CalendarIndividual extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// List all the 'tasks' on Individual Dashboard
			listTasks(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listTasks(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");

		int userId = 0 ;
	    String uID = request.getParameter("userId");
	     System.out.println(" uID " + uID);
	    if(uID.equals("") || uID.equals(null)) {
	        	userId = GetSet.id;
	    }
	    else {
	        	userId = Integer.parseInt(uID);
	    }
	 
		try {
			// DAO object
			DataBaseDAO dataBaseDAO = new DataBaseDAO();
		
			// DAO method : get all the tasks based on particular 'id'- unique for each user 
			List<GetSet> set = dataBaseDAO.getCalenderList(userId,date,month,year);
	
			HttpSession session = request.getSession();
			
			System.out.println(set);
			
			// set the TASK to show on 'view' page
			session.setAttribute("THE_TASKS", set);

			
			}catch(Exception e) {
				System.out.println(e+"603-1");
			}
			
			// context sending to view page
			response.sendRedirect(request.getContextPath()+	"/individual.jsp");	
	}
}

