package view;

import java.util.Scanner;
import java.util.ArrayList;
import model.User;
//import control.Controller;

public class Render {

	Scanner input = new Scanner(System.in);

	public void renderWelcome() {
		System.out.println("Welcome to ShareRUs \n");
	}

	public void renderLoginMessage() {
		System.out.println("\nSucces! You are logged in.");
	}

	public int renderStartMenu() {
		int decision;
		System.out.print("\nHere are your options: Enter 1 as new user, 2 as existing user and 3 to exit: ");
		decision = input.nextInt();
		while (decision != 1 && decision != 2 && decision != 3) {
			System.out.print("Invalid input. Please enter 1 as new user, 2 as existing user and 3 to exit: ");
			decision = input.nextInt();
		}
		return decision;
	}

	public int renderCustomerMenu() {
		int decision = 0;
		System.out.print("\nEnter 1 to browse cars, 2 to manage your own car and 3 to log out: ");
		decision = input.nextInt();

		while (decision != 1 && decision != 2 && decision != 3) {
			System.out.println(
					"Invalid input. Please enter 1 to browse cars, 2 to manage your own car and 3 to log out: ");
			decision = input.nextInt();
		}
		return decision;
	}

	public String[] renderRegistrationWindow() {
		//Renders and takes user details and passes them to control
		System.out.println("You have chosen to register as a new user. \n");
		System.out.print("Enter your first name: ");
		input.nextLine(); // throw away the \n not consumed by nextInt()
		String firstName = input.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = input.nextLine();
		System.out.print("Enter your CPR number: ");
		String cpr = input.nextLine();
		while (cpr.length() != 10) {
			System.out.println("Please enter a valid 10 digit CPR number: ");
			cpr = input.nextLine();
		}
		String[] info = { firstName, lastName, cpr };
		return info;
	}

	public void renderUserdetails(User User) {
		System.out.println("\nYour Username is " + User.getUsername() + " and your Password is " + User.getPassword());
	}

	public String[] renderLoginWindow(int tries) {
		String[] info = new String[2];
		String userNameAttempt = "";
		String passwordAttempt = "";
		
		//renders 1st login try
		if (tries == 0) {
			System.out.println("\nYou have " + (3 - tries) + " login attempts left\n");
			System.out.print("Enter your username: ");
			input.nextLine(); // throw away the \n not consumed by nextLine()
			userNameAttempt = input.nextLine();
			System.out.print("Enter your password: ");
			// input.nextLine(); //throw away the \n not consumed by nextLine()
			passwordAttempt = input.nextLine();
		}

		//2nd login try
		else if (tries == 1) {
			System.out.println("\nYou have " + (3 - tries) + " login attempts left\n");
			System.out.print("Enter your username: ");
			userNameAttempt = input.nextLine();
			System.out.print("Enter your password: ");
			// input.nextLine(); //throw away the \n not consumed by nextInt()f
			passwordAttempt = input.nextLine();
		}

		//3rd login try
		else if (tries == 2) {
			System.out.println("\nYou have " + (3 - tries) + " login attempts left\n");
			System.out.print("Enter your username: ");
			userNameAttempt = input.nextLine();
			System.out.print("Enter your password: ");
			// input.nextLine(); //throw away the \n not consumed by nextInt()f
			passwordAttempt = input.nextLine();
		}
		//Error message for 3 wring tries
		else if (tries == 3) {
			System.out.print("Too many attempts. Try again later.");
		}
		info[0] = userNameAttempt;
		info[1] = passwordAttempt;
		return info;
	}

	public int renderBrowseCarDb(int i, ArrayList<String[]> browsedCars) {
		int decision = 0;
		//renders browse menu
		if (i == 0) {
			System.out.print("\nEnter 1 to browse cars by daily price, 2 for by location and 3 for by brand and model: ");
			decision = input.nextInt();
			while ((decision != 1 && decision != 2 && decision != 3)) {
				System.out.println("Invalid input. Enter 1 to browse cars by daily price, 2 for by location and 3 for by brand and model: ");
				decision = input.nextInt();
			}
		}
		//renders browse by price, location or brand/model
		if (i == 1) {
			System.out.println("");
			for (int j = 0; j < browsedCars.size(); j++) {
				System.out.println("Car " + browsedCars.get(j)[0] + ": " + browsedCars.get(j)[1]);
			}
			System.out.print("\nEnter 1 too Book a car and 2 to Exit: ");
			decision = input.nextInt();
		}
		return decision;
	}

	public int renderCarOwnerMenu() {
		int decision;
		//renders menu when user wants to manage their own car
		System.out.print("\nEnter 1 to register a new car, 2 to update current car and 3 to exit: ");
		decision = input.nextInt();
		while ((decision != 1 && decision != 2 && decision != 3)) {
			System.out
					.print("\nInvalid input. Enter 1 to register a new car, 2 to update current car and 3 to exit:  ");
			decision = input.nextInt();
		}
		return decision;
	}

	public String[] renderCarRegistration(int i) {
		//renders and takes user input for new car registration 
		String[] carDetails = { "", "", "", "" };
		//Renders error message when users already have the maximum of 1 car registered
		if (i == 0) {
			System.out.print("You already have the maximum number of cars (1) registered.\n"
					+ "Delete this car to register a new or update the details of your current car.");
		}
		//renders car registration and takes user input
		else if (i == 1) {
			System.out.print("Please enter the Brand of your car: ");
			input.nextLine(); // throw away the \n not consumed by nextInt()
			String carBrand = input.nextLine();
			System.out.print("Please enter your car Model: ");
			String carModel = input.nextLine();
			System.out.print("Please enter the the hourly Price of your car: ");
			String hourlyPrice = input.nextLine();
			System.out.print("Please enter the Location of your car: ");
			String carLocation = input.nextLine();
			System.out.println("Your car is now available for rental");
			
			carDetails[0] = carBrand;
			carDetails[1] = carModel;
			carDetails[2] = hourlyPrice;
			carDetails[3] = carLocation;
		}
		return carDetails;
	}

	public void renderCarDetails(String brand, String model, String location, String availability, double hourlyPrice) {
		System.out.println("\nHere are the details of your car: \n" + "\n" + "Brand: " + brand + "\n" + "Model: "
				+ model + "\n" + "Location: " + location + "\n" + "Hourly Price: " + hourlyPrice + "\n"
				+ "The car is currently " + availability + " for rental");
	}

	public String[] renderUpdateCar(int decision, boolean availability) {
		String[] output = { "", "" };
		String update = "";
		int decision1 = decision;
		//renders message when user tries to update non-existing car
		if (decision1 == 0) {
			System.out.print("\nYou have no car registered with ShareRUs");
		}
		//renders menu and takes user choice when they want to update existing car
		else if (decision1 == 2) {
			System.out.print("\nEnter 1 to update car Location, 2 to change the Hourly Price, 3 switch its Availability and 4 to delete car: ");
			decision1 = input.nextInt();
			//update car location
			if (decision1 == 1) {
				System.out.print("\nEnter the new Location of your car: ");
				input.nextLine();
				update = input.nextLine();
				System.out.print("\nThe location of your car has been changed to " + update);
			//update price
			} else if (decision1 == 2) {
				System.out.print("\nEnter the new Hourly Price of your car: ");
				input.nextLine();
				update = input.nextLine();
				System.out.println("\nThe hourly price of your car has been changed to " + update);
			//Switches availability
			} else if (decision1 == 3) {
				String isAvailable = "";
				if (availability = true) {
					isAvailable = "Unavailable";
					update = "false";
				} else if (availability = false) {
					isAvailable = "Available";
					update = "true";
				}
				System.out.print("Your car has been switched to: " + isAvailable);
			}
			//deletes car
			else if (decision1 == 4) {
				System.out.print("Your car has been deleted");
			}
		}
		output[0] = String.valueOf(decision1);
		output[1] = update;
		
		return output;
	}

	public String[] renderBookingWindow(int count, int carCount) {
		//renders and takes user input for car booking
		String carId = "0";
		//choose car id
		while (Integer.parseInt(carId) > carCount || Integer.parseInt(carId) < 1) {
			if (count == 1) {
				System.out.print("\nPlease enter the ID of the car you wish to book: ");
				input.nextLine(); // throw away the \n not consumed by nextInt()
				carId = input.nextLine();
			} else {
				System.out.print("Please enter the ID of the car you wish to book: ");
				carId = input.nextLine();
			}
			count++;
		}
		//choose start time of booking (hh-dd-mm)
		System.out.print("\nPlease enter the start hour (between 7 \n"
				+ "and 19) and date of your booking in the format hh-dd-mm: ");
		String startTime = input.nextLine();
		while (startTime.length() > 8 || startTime.length() < 8 || !startTime.matches("..[-]..[-]..")) {
			System.out.print("The format must be hh-dd-mm: ");
			startTime = input.nextLine();
		}
		//choose duration of booking
		System.out.print("Please enter the hourly duration of your booking (max 4 hours): ");
		String duration = input.nextLine();

		String[] decision = { carId, startTime, duration };

		return decision;
	}

	public void unavailableTimeslot() {
		System.out.println("\nThe chosen timeslot is unavailable for this car. Try again.");
	}

	public void renderPaymentWindow() {
		String phoneNumber = "";
		String creditCardNumber = "";
		int count = 1;
		//following booking, render payment menu
		System.out.print("For Payment, please enter 1 to use Credit Card and 2 for Mobile Pay: ");
		int decision = input.nextInt();
		//credit card
		if (decision == 1) {
			while (creditCardNumber.length() != 10) {
				if (count == 1) {
					System.out.print("\nPlease enter your 10 digit Credit Card number: ");
					input.nextLine(); // throw away the \n not consumed by nextInt()
					creditCardNumber = input.nextLine();
				} else {
					System.out.print("Please enter your 10 digit Credit Card number: ");
					creditCardNumber = input.nextLine();
				}
				count++;
			}
		//mobile pay
		} else if (decision == 2) {
			while (phoneNumber.length() != 8) {
				if (count == 1) {
					System.out.print("\nPlease enter your 8 digit phone number: ");
					input.nextLine(); // throw away the \n not consumed by nextInt()
					phoneNumber = input.nextLine();
				} else {
					System.out.print("Please enter your 8 digit phone number: ");
					phoneNumber = input.nextLine();
				}
				count++;
			}
		}
		System.out.println("\nYour payment has been confirmed. Thank you for using ShareRUs!");
	}

	public void renderReceipt(String carType, String carBrand, String[] timeSlot, String location, Double totalPrice) {
		System.out.println("\nYour booking is confirmed. Here are the details: \n" + "\n" + "Car type: " + carType
				+ "\n" + "Car brand: " + carBrand + "\n" + "Time slot: " + timeSlot[0] + " - " + timeSlot[1] + "\n"
				+ "Location: " + location + "\n" + "Total price: " + totalPrice + "\n" + "\n");
	}

}
