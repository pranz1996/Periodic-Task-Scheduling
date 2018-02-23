package registration_login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import individual.user.*;

@WebServlet("/RegLogServlet")
public class RegLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hidden Paramenter from login and registration page
		String hiddenpara = request.getParameter("Page");
		
		String regQuery;
		String logQuery;
		
		// Registration request
		if(hiddenpara.equals("register")) {
			
			// fetch form data from JSP - html fields	
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String uname = request.getParameter("username");
			String category = request.getParameter("category");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
						
			// create getter-setter object to insert data into table
			// GetterSetter is like Bean that has getter and setter methods	
		    GetterSetter set = new GetterSetter(fname, lname, uname, password, category, email, mobile,0);
			
		    // Query to insert data into registration table
		    regQuery = "insert into registration values(NULL,?,?,?,?,?,?,?,?)";
		    
		    // Query to insert data into registration table
		    logQuery = "insert into login values(NULL,?,?,?,?)";
		
		    // DatabaseUtil DAO Class - Interact with Database 
		    DatabaseUtil databaseUtil = new DatabaseUtil();
		    
		    int i = 0;
		    
		    try {
		    	i = databaseUtil.registerUser(set,regQuery,logQuery);
		    }catch (Exception e) {
		    	System.out.println(e + "-1");
		    }	
			
		    // on successful registration redirect to login page
			if(i!=0) {
				response.sendRedirect("login.jsp");
				}
			else {
				response.sendRedirect("registration.jsp");
			}
		
	}
			// Login request
	    if(hiddenpara.equals("login")) {
	    	
	    	// fetch form data from JSP - html fields	
	    	String uname = request.getParameter("username");
	    	String category = request.getParameter("category");
	    	String password = request.getParameter("password");
		
	    	// Special check for Employee of Organization
	    	String ans = EmployeeCheck.check(uname,password,category);
		
	    	// If login details for an employee
	    	if(ans.equals("employee")) {
				HttpSession session = request.getSession();
				
				session.setAttribute("username", uname);
				request.setAttribute("username", uname);
			/*	RequestDispatcher dispatch = request.getRequestDispatcher("/User");
				dispatch.forward(request, response);       */
				
// 	(1)		 redirect to Servlet 'Organization/User' if user is employee of Organization
				response.sendRedirect(request.getContextPath()+ "/User");
	    	}
	    	else {
			
	    		// create gettersetter object to check whether Individual or Organization-admin
				GetterSetter set = new GetterSetter(uname,password,category);
				
				// Query to validate Login details
				String validateQuery = "select * from login";
			
				// DatabaseUtil DAO Class - Interact with Database
				DatabaseUtil databaseUtil = new DatabaseUtil();
				
				// query for validate Login details 
				String result= databaseUtil.loginUser(set,validateQuery);
			
				// if Login user is 'Individual' 
				if(result.equals("individual")){
				
					HttpSession session = request.getSession();
					DataBaseDAO dataBaseDAO = new DataBaseDAO();
					int id = dataBaseDAO.getLogId(uname);
					session.setAttribute("user",id);
					request.setAttribute("user",id);
					
				// if Login user is 'Individual'
//	(2)		 redirect to Servlet 'individual.user/Individual' if user is  Individual
					response.sendRedirect(request.getContextPath()+ "/Individual");
				}
				// if Login user is 'Organization-admin'
//	(3)		 redirect to Servlet 'organization/OrganizationBoard' if user is organization-admin
				else if(result.equals("organization")){
					
					HttpSession session = request.getSession();
					session.setAttribute("organization", uname);
					request.setAttribute("username", uname);
					
					// redirect to Servlet 'OrganizationBoard'
					response.sendRedirect(request.getContextPath()+	"/OrganizationBoard");
				}
				else {
					// false login details will redirect to login page
					response.sendRedirect("login.jsp");
				}
	    	}
	    }
	}
	
	// Future enhancement
/*	code to check organization type among :
  	standard - Organization-> Departments-> Modules-> Tasks
    medium   - Organization-> Modules -> Tasks 
    small	 - Organiation -> Tasks
*/
	
	/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int type = 0 ;
		String temp = request.getParameter("orgTypes");
		if(temp.equals("standard")) {
			type = 1 ;
		}
		else if(temp.equals("medium")) {
			type = 2 ;
		}
		else if(temp.equals("small")) {
			type = 3 ;
		}
		System.out.println(GetSet.category);
		GetSet.orgType = type;
		// Query to insert data into registration and login table
				String regQuery = "insert into registration values(NULL,?,?,?,?,?,?,?,?)";
				String logQuery = "insert into login values(NULL,?,?,?,?)";
				
				// DatabaseUtil DAO Class - 
				DatabaseUtil databaseUtil = new DatabaseUtil();
				int i = 0;
				try {
					i = databaseUtil.registerOrganization(regQuery,logQuery);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e+ "10178");
				}
				
				// on successfully registration
					if(i!=0) {
						response.sendRedirect("login.jsp");
						}
				
		} */

}

