package model;

import java.util.Scanner;

public class Login {
	
	public boolean checkLogin(String usernameAttempt, String passwordAttempt, String customer) {
	
		String password = customer.split(" ")[2];
		String username = customer.split(" ")[1];
		
		boolean match = username.equals(usernameAttempt) && password.equals(passwordAttempt);
		
		System.out.print("Wrong Username or Password");
		
		return match;
		
	}
		
}
