package model;

import java.util.Scanner;

public class Login {
	
	int count = 1;
	
	public void login(String usernameAttempt, String passwordAttempt, Db userDb) {
		
		while (count < 3) {
			if ((usernameAttempt.equals("test")) && (passwordAttempt.equals("test"))) {
				break;
			}
			if (!(checkLogin(usernameAttempt, passwordAttempt, userDb))) {
				count = count + 1;
				int triesLeft = 4 - count;
				System.out.println("Wrong username or password. " + triesLeft + " tries left.");
				System.out.println("Enter your username: ");
				usernameAttempt = input.nextLine();
				System.out.print("Enter your password: ");
				passwordAttempt = input.nextLine();
			} else if (checkLogin(usernameAttempt, passwordAttempt)) {
				break;
			}

		}

		if (count == 3) {
			System.out.println("Too many login attempts. Try again later.");

		} else if (count <= 3) {
			System.out.println("You are now logged in!");
			
			
		}

	}
	
	public boolean checkLogin(String username, String password, Db userDb) {
		if
		
		userDb.getUser(username).getUsername();
		boolean test = false;
		int i = 0;
		while(userDb[i].getUsername()).equals(username)) && ((customerDb[i].getPassword()).equals(password)) {
			
		}
		
		for (int i = 0; i < customerCount; i = i + 1) {
			test = ((customerDb[i].getUsername()).equals(username)) && ((customerDb[i].getPassword()).equals(password));
			if (test == true) {
				currentCustomerId = customerDb[i].getId();
				break;
			}
		}
		return test;
	}
	
	public int getCount() {
		return count;
	}
}
