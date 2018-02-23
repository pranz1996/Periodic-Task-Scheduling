package organization;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TaskStartEndProcessing")
public class TaskStartEndProcessing extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// fetch status of task
		String type = request.getParameter("tasking");
	
		int status = 0 ;
		
		String task = "" ;
		
		// to-do to doing
		if(type.equals("start")) {
			task = request.getParameter("task");
			status = 2;
		// doing to done
		}else if(type.equals("end")) {
			task = request.getParameter("task1");
			status = 3;
		}
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		
		java.sql.Timestamp start = null ,end = null ;
		
		// setting time and date for starting & ending of task
		
		if(status == 2) {
			start = date;
			end = null;
		}else if(status == 3) {
			end = date;
			start = null ;
		}

		// UserDB obejct
		UserDB userDB = new UserDB();
		
		// method that changes the status
		userDB.changeTaskStatus(status,task,start,end);
		
		// respond to Servlet
		RequestDispatcher dispatch = request.getRequestDispatcher("ServletTask");
		dispatch.forward(request, response);

	}
}
