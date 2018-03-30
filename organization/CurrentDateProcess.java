package organization;

import java.util.Calendar;

public class CurrentDateProcess {
	public String current() 
{
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DATE);		
	String s = day+" " + (month+1) + " " + year;
	
	return s;
}

}
