package organization;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

@WebServlet("/TaskUpdateDelete")
public class TaskUpdateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// command to load, delete or update any task
		String possible = request.getParameter("command");

			switch(possible) {
				case "LOAD":
					try {
						loadTaskDetails(request,response);
					}catch (Exception e) {
						System.out.println(e+"2002");
					}
					break;
				
				case "UPDATE":
					try {
					updateTaskDetails(request,response);
					}catch(Exception e) {
						System.out.println(e+"2004");
					}
					break;

				case "DELETE":
					try {
						deleteTaskDetails(request,response);
					}catch(Exception e) {
						System.out.println(e+"2003");
					}
					break;
				
				default:{
					RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
					dispatch.forward(request, response);
				}
				
			}
	}
	
	private void loadTaskDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// id to Populate the taks
		int id = Integer.parseInt(request.getParameter("id"));
	
		String empname = request.getParameter("name");
		
		HttpSession session = request.getSession();
		
		// DAO objeect to get task details
		UpdateTaskList updateTaskList = new UpdateTaskList();

		// stores the task details
		Task taskList = null;
		try {
			taskList = updateTaskList.LoadTaskDetails(id);
		}catch (Exception e) {
			System.out.println("1500");
		}
		
		// setting parameters
		session.setAttribute("TASK", taskList);
		session.setAttribute("EMP", empname);
		
		// list of employees if want to change assignment
		List<String> emps = null ;
		try {
			emps = ShowClass.showEmployees();
		}catch (Exception e) {
			System.out.println(e + "2000");
		}
		
		// setting parameters
		session.setAttribute("EMPLOYEE", emps);
		session.setAttribute("TASKID", id);
		
		// redirect to view page
		response.sendRedirect(request.getContextPath()+"/updateTaskOrg.jsp");
		
	}
	
	private void updateTaskDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// unique id to update task
		int id = Integer.parseInt(request.getParameter("id"));
		
		// fetch parameters
		String status = request.getParameter("status");
		String emp = request.getParameter("emp");
		String stime = (request.getParameter("stime")).toString();
		String etime = (request.getParameter("etime")).toString();
		int prio = Integer.parseInt(request.getParameter("priority"));
		String task =  request.getParameter("task");
		
		// DAO object to update task
		UpdateTaskList updateTaskList = new UpdateTaskList();
		try {
			updateTaskList.updateTask(id,status,emp,task,stime,etime,prio);
		}catch(Exception e) {
			System.out.println(e+ "8787s");
		}
		
		// respond to admin page
		response.sendRedirect("OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response); 		*/
	}

	private void deleteTaskDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// unique id of task
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DAO object that delete the task
		UpdateTaskList updateTaskList = new UpdateTaskList();
		try {
			updateTaskList.deleteTask(id);
		}catch (Exception e) {
			System.out.println(e + "1122");
		}
		
		// respond to admin page
		response.sendRedirect("OrganizationBoard");
/*		RequestDispatcher dispatch = request.getRequestDispatcher("OrganizationBoard");
		dispatch.forward(request, response);*/
	}

}
