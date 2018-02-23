package organization;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/User")
public class User extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String uname ;
		
		// get employee id
		if(SetId.eid == 0)
			 uname = (String) session.getAttribute("username");
		else
			uname = SetId.uname;
		
		// DAO object
		UserDB userDB = new UserDB();
		
		// list of task for particular employee
		List<Task> lists = userDB.getList(uname);
		
		// setting tasks
		request.setAttribute("data",lists);
		
		// respond to view page
		RequestDispatcher dispatch = request.getRequestDispatcher("employeeOrganization.jsp");	
		dispatch.forward(request, response);
	}
}
	
