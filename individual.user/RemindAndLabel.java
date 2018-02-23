package individual.user;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/RemindAndLabel")

 	public class RemindAndLabel extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch parameter to check whether to show all reminders or 
		// all labels or all tasks under particular label
		String info = request.getParameter("command");
		try {
			switch(info) {
				case "remind":
					showAllReminders(request,response);
					break;
				case "labels":
					showAllLabels(request,response);
					break;
				case "showTask":
					showLabelTasks(request,response);
					break;
			}
		}catch(Exception e) {
			System.out.println(e+ "pranjal 1");
		}
	}
	
	private void showAllReminders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// DbUtil is DAO class object- to access database
		DbUtil dbUtil = new DbUtil();
		
		// fetch all tasks with reminders
		List<GetSet> tasks = dbUtil.getTaskByReminder();
		
		// getting new session parameter
		HttpSession session = request.getSession();
		
		// setting tasks to session
		session.setAttribute("THE_REMINDERS", tasks);
		
		// redirect to view page
		response.sendRedirect(request.getContextPath()+	"/show.jsp");
	}
	
	private void showLabelTasks(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// id to check user
		int idName = Integer.parseInt(request.getParameter("Id"));
		
		// label name
		String labelName = request.getParameter("labelName");
		
		// DAO class object
		DataBaseDAO data = new DataBaseDAO();
		
		// get all the tasks under particular label
		List<GetSet> list = data.getListOfLabel(idName, labelName);
		
		// getting new session parameter
		HttpSession session = request.getSession();
		
		// setting tasks to session
		session.setAttribute("THE_LABELS_TASK", list);

		// redirect to view page
		response.sendRedirect(request.getContextPath()+ "/showLabelTask.jsp");
	}

	private void showAllLabels(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DAO class object
		DbUtil dbUtil = new DbUtil();
		
		// get all labels
		List<GetSet> tasks = dbUtil.getTaskByLabel();
	
		// fetch unique id
		int id1 = GetSet.id;
		
		ListResetClass listResetClass = new ListResetClass();
		
		// all lables
		List<GetSet> lists = listResetClass.set(tasks);
	
		// getting session parameter
		HttpSession session = request.getSession();
		
		// setting label list to session
		session.setAttribute("THE_LABELS", lists);
		
		// set unique id to session
		session.setAttribute("id", id1);
	
		// redirect to view page
		response.sendRedirect(request.getContextPath()+ "/showLabel.jsp");
	}
}
