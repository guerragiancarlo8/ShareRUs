package model;

public class User {

	protected String firstName;
	protected String lastName;
	protected String cpr;
	protected String userType;
	protected String username;
	protected String password;

	public User() {
		// No-arg constructor
	}

	public User(String firstName, String lastName, String cpr, String userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpr = cpr;
		this.userType = userType;
		this.username = setUsername();
		this.password = setPassword();
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
		if (this.lastName.length() > 3) {
			this.username = firstName.charAt(0) + lastName.substring(0, 3);
		} else {
			this.username = this.firstName.substring(0, 3) + this.lastName.charAt(0);
		}
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword() {
		if (this.lastName.length() > 3) {
			this.password = lastName.substring(0, 3) + cpr.substring(cpr.length() - 3, cpr.length());
		} else {
			this.password = this.lastName + this.cpr.substring(7);
		}
		return password;
	}
}
