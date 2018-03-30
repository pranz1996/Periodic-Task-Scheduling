package organization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CalendarWiseTask")
public class CalendarWiseTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
			
		// UserDB(DAO) object
		UserDB userDB = new UserDB();		
		
		// Fetch all tasks details
		List<Task> list = new ArrayList<>();
		
		// getting all tasks with details
		list = userDB.getAllDetails();
		
		UpdateTaskList utl = new UpdateTaskList();
		
		List<Task> upList = new ArrayList<>();
		
		upList = utl.dateWiseTask(list,date,month,year);
		
		HttpSession session = request.getSession();
		
		// setting list 
		session.setAttribute("LIST", upList);
		
		
		// respond to view page
		response.sendRedirect(request.getContextPath() + "/organizationBoard.jsp");
		}
		catch (Exception e) {
			System.out.println(e+" calneder");
		}
	}

}
