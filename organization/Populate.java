package organization;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Populate")
public class Populate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// parameter for what to populate
		String decision = request.getParameter("get");
		try {
		switch(decision) {
			case "addEmp":
				addEmployee(request,response);
				break;
			case "addDept":
				addDepartment(request,response);
				break;
			case "addProj":
				addProject(request,response);
				break;
			case "addMod":
				addModule(request,response);
				break;
			case "addTask":
				addTask(request,response);
				break;
			case "assignTask":
				assignTask(request,response);
				break;
			default:
				home(request,response);
		}
		}catch(Exception e) {
			System.out.println(e + " 31");
		}
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Populate departments for 
		// adding employee to which department
		ArrayList<Task> deptList = null;
		
		try {
			deptList = ShowClass.showDepartments();
		}catch(Exception e) {
			System.out.println(e + "50");
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("THE_DEPTS", deptList);
		
		response.sendRedirect(request.getContextPath() + "/addEmployee.jsp");
		
	}

	// populate all departments
	private void addDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ArrayList<Task> deptList = null;
		try {
			deptList = ShowClass.showDepartments();
		}catch(Exception e) {
			System.out.println(e + "50");
		}
		HttpSession session = request.getSession();
		session.setAttribute("THE_DEPTS", deptList);
		
		response.sendRedirect(request.getContextPath()+ "/addDepartment.jsp");
	/*	
		RequestDispatcher dispatch = request.getRequestDispatcher("addDepartment.jsp");
		dispatch.forward(request, response);		*/
	}

	// populate all departments
	private void addProject(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ArrayList<Task> deptList = null;
		try {
			deptList = ShowClass.showDepartments();
		}catch(Exception e) {
			System.out.println(e + "50");
		}
		HttpSession session = request.getSession();
		session.setAttribute("THE_DEPTS", deptList);
		
		response.sendRedirect(request.getContextPath() + "/addProject.jsp");
				
	}
	
	// populate all projects
	private void addModule(HttpServletRequest request, HttpServletResponse response) throws Exception{
				
		ArrayList<Task> projList = null;
		try {
			projList = ShowClass.showProjects();
		}catch(Exception e) {
			System.out.println(e + "52");
		}
				
		HttpSession session = request.getSession();
		session.setAttribute("THE_PROJS", projList);
		
		response.sendRedirect(request.getContextPath() + "/addModule.jsp");
				
	}

	// populate all tasks
	private void addTask(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<Task> modList = null;
		try {
			modList = ShowClass.showModules();
		}catch(Exception e) {
			System.out.println(e + "53");
		}

		HttpSession session = request.getSession();
		session.setAttribute("THE_MODS", modList);
		response.sendRedirect(request.getContextPath()+ "/addTask.jsp");
				
	}
	
	private void assignTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// show all employees
		ArrayList<String> empList = null;
		try {
			empList = ShowClass.showEmployees();
		}catch(Exception e) {
			System.out.println(e + "501");
		}
		
		// show all tasks in todo list
		ArrayList<String> taskList = null;
		try {
			taskList = ShowClass.showTasksTODO();
		}catch(Exception e) {
			System.out.println(e + "502");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("EMPs", empList);
		session.setAttribute("TASKs", taskList);
		
		response.sendRedirect(request.getContextPath()+ "/assign.jsp");
		
	/*	RequestDispatcher dispatch = request.getRequestDispatcher("assign.jsp");
		dispatch.forward(request, response);			*/
	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("organizationBoard.jsp");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("organizationBoard.jsp");
		dispatch.forward(request, response);*/
	}

	
}
