package individual.user;

public class GetSet {
	
	// parameters
	public static int id = 0 ;
	int indid;
	int logid ;
	String label;
	String title;
	String name;
	int priority;
	String reminder;
	
	// constructors
	public GetSet() {
	}
	
	public GetSet(String label) {
		this.label = label;
	}
	
	public GetSet(int id, String name) {
		this.logid = id ;
		this.name = name;
	}

	public GetSet(String label, String title, String name,  String reminder) {
		super();
		this.label = label;
		this.title = title;
		this.name = name;
		this.reminder = reminder;
	}
	
	public GetSet(int id,String label, String title, String name, String reminder) {
		super();
		this.logid = id ;
		this.label = label;
		this.title = title;
		this.name = name;
		this.reminder = reminder;
	}	

	// getter-setter methods
	public int getLogid() {
		return logid;
	}

	public void setLogid(int logid) {
		this.logid = logid;
	}

	public int getIndid() {
		return indid;
	}

	public void setIndid(int indid) {
		this.indid = indid;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	
	// toString method
	@Override
	public String toString() {
		return "GetSet [label=" + label + ", name=" + name + "]";
	}
	
}
