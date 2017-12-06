package model;

public class Administrator extends User {
	public Administrator (String username, String password) {
		this.username = username;
		this.password = password;
		this.userType = "administrator";
		this.firstName = "firstName";
		this.lastName = "lastName";
		this.cpr = "cpr";
	}
}
