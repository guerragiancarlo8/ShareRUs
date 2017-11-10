package view;

import java.util.Scanner;
import java.util.ArrayList;
import model.User;
//import control.Controller;

public class Render {

	Scanner input = new Scanner(System.in);
	
	public int renderStartMenu() {
		int decision;
		System.out.println("Welcome to ShareRUs");
		System.out.println("Here are your options: Enter 1 as new user, 2 as existing user and 3 to exit");
		decision = input.nextInt();
		while (!(decision == 1 || decision == 2 || decision == 3)) {
			System.out.println("Invalid input. Please enter 1 as new user, 2 as existing user and 3 to exit");
			decision = input.nextInt();	
			}
		return decision;
	}
	
	public String[] renderRegistrationWindow() {
		System.out.println("Enter your first name: ");
		String firstName = input.nextLine();
		
		System.out.println("Enter your last name: ");
		String lastName = input.nextLine();
		
		System.out.println("Enter your CPR number: ");
		String cpr = input.nextLine();
		while(cpr.length() != 10) {
			System.out.println("Please enter a valid 10 digit CPR number: ");
			cpr = input.nextLine();
		}
		
		System.out.println("Enter your usertype: \"customer\" or \"owner\"");
		String userType = input.nextLine();
		while (!(userType.equals("customer") || userType.equals("owner"))) {
			System.out.println("Plase enter a valid usertype: \"customer\" or \"owner\"");
			userType = input.nextLine();
		}
				
		String[] info = {firstName, lastName, cpr, userType};
		
		return info;
	}
	
	public void renderUserdetails(User User) {
		System.out.println("Your Username is " + User.getUsername() + " and your Password is " + User.getPassword());
	}
	
	public String[] renderLoginWindow() {
		System.out.print("Enter your username: ");
		String userNameAttempt = input.nextLine();
		System.out.print("Enter your password: ");
		String passwordAttempt = input.nextLine();
		
		String[] info = {userNameAttempt, passwordAttempt};
		
		return info;
	}
	
	public int renderBrowseCarDb(int i, ArrayList<String> browsedCars) {
		int decision = 0;
		if(i == 0) {
		System.out.print("Enter 1 to browse available cars by daily price, 2 for by location and 3 for by brand and model");
		decision = input.nextInt();
		while (!(decision == 1 || decision == 2 || decision == 3 || decision == 4)) {
			System.out.println("Invalid input. Please enter 1 as new user, 2 as existing user and 3 to exit");
			decision = input.nextInt();	
			}
		}
		
		else if (i == 1) {
			for(int j = 0; j > browsedCars.size(); j++) {
				System.out.println(browsedCars.get(j));
			}
			System.out.print("Enter the id of the car you wish to book: ");
			decision = input.nextInt();
		}
		
		return decision;
	}
	
}
