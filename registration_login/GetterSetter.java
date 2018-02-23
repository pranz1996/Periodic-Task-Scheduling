package registration_login;

public class GetterSetter {
	
	// parameters
	String id ;
	String firstName ;
	String lastName ;
	String userName ;
	String password ;
	String category ;
	String email ;
	String mobile;
	
	// constructors
	public GetterSetter() {
	}

	public GetterSetter(String uname, String password, String category) {
		this.userName = uname;
		this.password = password;
		this.category = category;
	}
	
	public GetterSetter(String firstName, String lastName, String userName, String password, String category,
			String email, String mobile, int orgType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.category = category;
		this.email = email;
		this.mobile = mobile;
	}
	
	// getter-setter methods
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
