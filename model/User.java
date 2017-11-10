package model;

public class User {

	private String firstName;
	private String lastName;
	private String cpr;
	private String userType;
	private String username;
	private String password;
	private boolean isLoggedIn;
	
	public User() {
		//No-arg constructor
	}
	
	public User(String firstName, String lastName, String cpr, String userType) {
		this.firstName = firstName;
		this.lastName =lastName;
		this.cpr = cpr;
		this.userType = userType;
		this.username = setUsername();
		this.password = setPassword();
		this.isLoggedIn = false;
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
	public String getCpr() {
		return cpr;
	}
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUsername() {
		return username;
	}
	public String setUsername() {
		if(this.lastName.length() > 3) {
			this.username = firstName.charAt(0) + lastName.substring(0, 3);
		}
		else {
			this.username = this.firstName.charAt(0) + this.lastName;
		}
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword() {
		if(this.lastName.length() > 3) {
			this.password = lastName.substring(0, 3) + cpr.substring(cpr.length() - 3, cpr.length());
		}
		else {
			this.password = this.lastName + this.cpr.substring(7);
		}
		return password;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public void checkLogin(String username, String password) {
		if(!(username.equals(this.username) && password.equals(this.password))) {
			this.isLoggedIn = false;
		}
		else {
			this.isLoggedIn = true;
		}
	}
}
