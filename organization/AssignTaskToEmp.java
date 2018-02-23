package organization;

import java.io.IOException;

/*
 import javax.servlet.RequestDispatcher;
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignTaskToEmp")

public class AssignTaskToEmp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get employee
		String emp = request.getParameter("emps");
		
		// get task
		String task = request.getParameter("tasks");
		
		// AddClass object - DAO class
		AddClass assign = new AddClass();
		
		// TaskToEmp method to assign task
		assign.TaskToEmp(emp,task);
		
		// redirect to - OrganizationBoard
		response.sendRedirect("OrganizationBoard");		
	}
}
