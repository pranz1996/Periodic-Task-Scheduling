package organization;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/Organization")

public class Organization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get parameter from view page
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
				case "showEmp":
					showEmployees(request,response);
					break;
				case "ShowDept":
					showDepartments(request,response);
					break;
				case "ShowProj":
					showProjects(request,response);
					break;
				case "ShowMod":
					showModules(request,response);
					break;
				case "ShowTask":
					showTasks(request,response);
					break;
				default:
					home(request,response);
			}
		}catch(Exception e) {
			System.out.println(e + " one");
		}
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// fetch html attributes
		String empName = request.getParameter("empname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String department = request.getParameter("dept"); 
		
		// Gettersetter object to set data
		Task d1 = new Task();
		
		// setting data
		d1.setDepartment(empName,username,password,department);

		// AddClass(DAO) object
		AddClass e1 = new AddClass();
		
		// add employee
		try {
			e1.addEmployee(d1);
		}catch(Exception e) {
			System.out.println(e + " two");
		}
		
		// respond to OrganizationBoard- admin page
		// response.sendRedirect("OrganizationBoard");
		// or
		response.sendRedirect(request.getContextPath() +"/OrganizationBoard");
	}

	private void addDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// fetch html attribute
		String deptName = request.getParameter("dept");
		
		// Gettersetter object to set data
		Task d1 = new Task();
		
		// setting data
		d1.setDetpName(deptName);

		// AddClass(DAO) object
		AddClass e1 = new AddClass();
		
		// add department
		try {
			e1.addDepartment(d1);
		}catch(Exception e) {
			System.out.println(e + " four");
		}
		
		// respond to OrganizationBoard- admin page
		response.sendRedirect(request.getContextPath() +"/OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response); */
	}

	private void addProject(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		// fetch html attributes
		String projName = request.getParameter("proj");
		String department = request.getParameter("dept");
		
		// GetterSetter object to set data
		Task d1 = new Task();
		
		// setting data
		d1.setProject(projName,department);

		// AddClass(DAO) object
		AddClass e1 = new AddClass();
		
		// add project
		try {
			e1.addProject(d1);
		}catch(Exception e) {
			System.out.println(e + " six");
		}
		
		// respond to OrganizationBoard - admin page
		response.sendRedirect(request.getContextPath() +"/OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response);   		*/
	}

	private void addModule(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get html attribute
		String modName = request.getParameter("mod");
		String project = request.getParameter("proj");
		
		// GetterSetter object to set data
		Task d1 = new Task();
		
		// setting data
		d1.setModule(modName,project);

		// AddClass(DAO) object
		AddClass e1 = new AddClass();
		
		// add module
		try {
			e1.addModule(d1);
		}catch(Exception e) {
			System.out.println(e + " eight");
		}
		
		// respond to OrganizationBoard - admin page
		response.sendRedirect(request.getContextPath() +"/OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response);  */
	}

	private void addTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// get html attributes
		String taskName = request.getParameter("task");
		String module = request.getParameter("modu");
		String priortiy = request.getParameter("priority");
		String start =request.getParameter("stime");
		String end = request.getParameter("etime");
		
		int p ;
		
		if(priortiy.equals("")) {
			p = 0 ;
		}
		else {
			p = Integer.parseInt(priortiy);
		}
		
		// GetterSetter object to set data
		Task d1 = new Task();
		
		// setting data
		d1.setTask(taskName,module,p,start,end,1);

		// AddClass(DAO) object
		AddClass e1 = new AddClass();
		
		// add task
		try {
			e1.addTask(d1);
		}catch(Exception e) {
			System.out.println(e + " ten");
		}
		
		// respond to OrganizationBoard - admin page
		response.sendRedirect(request.getContextPath() +"/OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response);   		*/
	}

	private void showEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// list to store all data
		ArrayList<String> empList = null;
		
		// get all employees
		try {
			empList = ShowClass.showEmployees();
		}catch(Exception e) {
			System.out.println(e + "14");
		}
		
		// setting parameters
		HttpSession session = request.getSession();
		session.setAttribute("THE_EMPS", empList);
		
		// respond to view page
		response.sendRedirect(request.getContextPath() +"/showEmployee.jsp");

/*		RequestDispatcher dispatch = request.getRequestDispatcher("showEmployee.jsp");
		dispatch.forward(request, response);
*/		
	}

	private void showDepartments(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// list to store all data
		ArrayList<Task> deptList = null;
		
		// get all departments
		try {
			deptList = ShowClass.showDepartments();
		}catch(Exception e) {
			System.out.println(e + "twelve");
		}
		// setting parameters
		HttpSession session = request.getSession();
		session.setAttribute("THE_DEPTS", deptList);
		
		// respond to view page
		response.sendRedirect(request.getContextPath() +"/showDepartment.jsp");
		
/*		request.setAttribute("THE_DEPTS", deptList);
		RequestDispatcher dispatch = request.getRequestDispatcher("showDepartment.jsp");
		dispatch.forward(request, response);		*/
	}

	private void showProjects(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// list to store all data
		ArrayList<Task> projList = null;
		
		// get all projects
		try {
			projList = ShowClass.showProjects();
		}catch(Exception e) {
			System.out.println(e + "22");
		}

		// setting parameters
		HttpSession session = request.getSession();
		session.setAttribute("THE_PROJS", projList);
	
		// respond to view page
		response.sendRedirect(request.getContextPath() +"/showProject.jsp");
		
/*		request.setAttribute("THE_PROJS", projList);
		RequestDispatcher dispatch = request.getRequestDispatcher("showProject.jsp");
		dispatch.forward(request, response);		*/
		
	}


	private void showModules(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// list to store all data
		ArrayList<Task> modList = null;
		
		// get all modules
		try {
			modList = ShowClass.showModules();
		}catch(Exception e) {
			System.out.println(e + "21");
		}
		
		// setting parameters
		HttpSession session = request.getSession();
		session.setAttribute("THE_MODS", modList);
		
		// respond to view page
		response.sendRedirect(request.getContextPath() +"/showModule.jsp");
		
/*		request.setAttribute("THE_MODS", modList);
		RequestDispatcher dispatch = request.getRequestDispatcher("showModule.jsp");
		dispatch.forward(request, response);
*/		
	}

	private void showTasks(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// list to store todo tasks
		ArrayList<Task> taskListTODO = null;
		try {
			taskListTODO = ShowClass.showTasks(1);
		}catch(Exception e) {
			System.out.println(e + "20");
		}
		
		// lis to store doing tasks
		ArrayList<Task> taskListDOING = null;
		try {
			taskListDOING= ShowClass.showTasks(2);
		}catch(Exception e) {
			System.out.println(e + "503");
		}
		
		// lis to store done lists
		ArrayList<Task> taskListDONE = null;
		try {
			taskListDONE = ShowClass.showTasks(3);
		}catch(Exception e) {
			System.out.println(e + "504");
		}
		
		
		HttpSession session = request.getSession();
		
		// setting tasks
		session.setAttribute("TODO", taskListTODO);
		session.setAttribute("DOING", taskListDOING);
		session.setAttribute("DONE", taskListDONE);
	
		// redirect to view page
		response.sendRedirect(request.getContextPath() +"/showTask.jsp");
			
	}
		
	// default : respond to OrganizationBoard(admin)
	private void home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response); 
	}

	
}
