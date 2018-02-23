package organization;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTask")
public class ServletTask extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// fetch id of employee
		int id = SetId.eid;
		
		// DAO object - handle db operations
		UserDB userDB = new UserDB();
		
		// list of to-do tasks
		ArrayList<Task> taskListTODO = null;
		try {
			taskListTODO = userDB.showTasks(id,1);
		}catch(Exception e) {
			System.out.println(e + "561");
		}
		
		// list of doing tasks
		ArrayList<Task> taskListDOING = null;
		try {
			taskListDOING= userDB.showTasks(id,2);
		}catch(Exception e) {
			System.out.println(e + "562");
		}
		
		// list of done tasks
		ArrayList<Task> taskListDONE = null;
		try {
			taskListDONE = userDB.showTasks(id,3);
		}catch(Exception e) {
			System.out.println(e + "563");
		}
		
		// setting todo tasks
		request.setAttribute("TODO", taskListTODO);
	
		// setting doing tasks
		request.setAttribute("DOING", taskListDOING);
	
		// setting done tasks
		request.setAttribute("DONE", taskListDONE);
		
		// respond to view page
		RequestDispatcher dispatch = request.getRequestDispatcher("showTasks.jsp");
		dispatch.forward(request, response);
	}

}
