package organization;

import java.io.*;
// import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/OrganizationBoard")
public class OrganizationBoard extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// UserDB(DAO) object
		UserDB userDB = new UserDB();		
		
		// Fetch all tasks details
		List<Task> list = new ArrayList<>();
		
		// getting all tasks with details
		list = userDB.getAllDetails();
		
		// setting list 
		request.setAttribute("LIST", list);
		
		// respond to view page
		RequestDispatcher dispatch = request.getRequestDispatcher("/organizationBoard.jsp");
		dispatch.forward(request, response);
	}

}
