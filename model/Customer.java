package model;

public class Customer extends User {
	public Customer(String firstName, String lastName, String cpr) {
		this.firstName = firstName;
		this.lastName =lastName;
		this.cpr = cpr;
		this.userType = "customer";
		this.username = setUsername();
		this.password = setPassword();
	}
}
