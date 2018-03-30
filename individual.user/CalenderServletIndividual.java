package individual.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import organization.CurrentDateProcess;

@WebServlet("/CalendarServletIndividual")
public class CalendarServletIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int dayToday = 0;
	static int monthToday = 0;
	static int yearToday = 0;
	static int month = 0 ;
	static int year = 0 ;
	static int day = 0 ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("traverse");
		
		
		
		if(parameter == null)
			parameter = "current";
		switch (parameter) {
		case "next":
				 month = Integer.parseInt(request.getParameter("month"));
				 year = Integer.parseInt(request.getParameter("year"));
				 
				 if (month == 12) {
					 month = 1 ;
					 year = year + 1 ;
				 }
				 else
					 month = month + 1 ;
				 
				 goCalendar(request, response);
			break;
		case "last":
				month = Integer.parseInt(request.getParameter("month"));
				year = Integer.parseInt(request.getParameter("year"));
				
				if(month == 1) {
					month = 12;
					year = year - 1 ;
				}
				else
					month = month - 1 ;
				
				goCalendar(request, response);
			break;
		case "current":
				CurrentDateProcess p = new CurrentDateProcess();
				String currentData = p.current();
				String[] str = currentData.split(" ");
				day = Integer.parseInt(str[0]);
				month = Integer.parseInt(str[1]);
				year = Integer.parseInt(str[2]);

				dayToday = day ; monthToday = month ; yearToday = year;		
				
				goCalendar(request, response);
			break;
		default:
				CurrentDateProcess p1 = new CurrentDateProcess();
				String currentData1 = p1.current();
				String[] str1 = currentData1.split(" ");
				day = Integer.parseInt(str1[0]);
				month = Integer.parseInt(str1[1]);
				year = Integer.parseInt(str1[2]);
				
				dayToday = day ; monthToday = month ; yearToday = year;		
				
				goCalendar(request, response);
			break;
		}
	}
	
	private void goCalendar(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{

		
		// months[i] = name of month i
        String[] months = {
            "",                               // leave empty so that months[1] = "January"
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };

        // days[i] = number of days in month i
        int[] days = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        // check for leap year
        if (month == 2 && isLeapYear(year)) days[month] = 29;

        // starting day
        int d = day(month, 1, year);
     
        HttpSession session = request.getSession();
	
        session.setAttribute("StartDay", d);
        session.setAttribute("Today", day);
        session.setAttribute("monthYear", months[month]+ " " + year);
        session.setAttribute("year", year);
        session.setAttribute("month", month);
        
        session.setAttribute("days", days[month]);

        session.setAttribute("dayToday",dayToday);
        session.setAttribute("monthToday",monthToday);
        session.setAttribute("yearToday",yearToday);
        
        int userId = 0 ;
        String uID = request.getParameter("userId");
        if(uID.equals("") || uID.equals(null)) {
        	session.setAttribute("user_id", GetSet.id);
        }
        else {
        	userId = Integer.parseInt(request.getParameter("userId"));
        	session.setAttribute("user_id", userId);
        }
        
       // System.out.println("GetSet id " + GetSet.id + " userId" + userId); 
       
        response.sendRedirect(request.getContextPath()+"/CalendarIndividual.jsp");
	}

	private int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
	}

	private boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
	}
}
