package control;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.*;
import java.util.Date;

import model.*;
import view.*;

public class Controller {

	Render R1 = new Render();
	Db Db1 = new Db();
	String currentUsername;

	public static void main(String[] args) {
		Controller M1 = new Controller();
		M1.addInitialCars();
		M1.handleMenu();
	}

	public void handleMenu() {
		R1.renderWelcome();
		while (true) {
			int decision = R1.renderStartMenu();
			int decision2 = 0;
			switch (decision) {
			case 1: //New user registration
				handleRegistration();
				break;
			case 2: //Existing user login	
				boolean loggedIn = handleLoginWindow();
				//User is logged in
				if(loggedIn) { 
					R1.renderLoginMessage();
					while (true) {
						int decision1 = R1.renderCustomerMenu();
						//Browse cars chosen
						if (decision1 == 1) {
							while (true) {
								decision2 = handleBrowseCarsWindow();
								//new booking chosen
								if (decision2 == 1) {
									handleBooking();
									break;
								//exit chosen
								} else if (decision2 == 2) {
									break;
								}
								continue;
							}
						//Manage existing cars chosen
						} else if (decision1 == 2) {
							handleCarOwnerActions();
							continue;
						//exit chosen
						} else if (decision1 == 3) {
							currentUsername = "";
							break;
						}
					}
				//Login failed - program terminated
				} else if (!loggedIn) {
					System.exit(0);
				}
				break;
			//Terminate program
			case 3:
				System.exit(0);
			}
		}
	}

	public void handleRegistration() {
		//Takes new user details, creates new customer object, adds customer to db file and renders details
		String[] info = R1.renderRegistrationWindow();
		Customer C1 = new Customer(info[0], info[1], info[2]);
		Db1.addCustomer(C1);
		R1.renderUserdetails(C1);
	}

	public boolean handleLoginWindow() {
		//Takes user login details and compares to db file 
		//Returns true if match and false if no match
		int tries = 0;
		boolean verified = false;
		boolean matchU;
		boolean matchP;

		while (tries < 4) {
			String[] info = R1.renderLoginWindow(tries);
			String userDetails = Db1.getUser(info[0]);

			if (userDetails.equals("")) {
				tries++;
				continue;
			}

			String username = userDetails.split(" ")[1];
			String password = userDetails.split(" ")[2];

			matchU = username.equals(info[0]);
			matchP = password.equals(info[1]);

			if (matchU && matchP) {
				currentUsername = info[0];
				verified = true;
				break;
			}
			tries++;
		}
		return verified;
	}

	public int handleBrowseCarsWindow() {
		//Initiates new arraylist, adds car details to list and renders them.
		//Return user decision book car or exit
		ArrayList<String[]> browsedCars = null;
		int i = 0;
		int decision = R1.renderBrowseCarDb(i, browsedCars);
		browsedCars = Db1.browseCarBy(decision);
		i = 1;
		decision = R1.renderBrowseCarDb(i, browsedCars);
		
		return decision;
	}

	public void handleBooking() {
		//Renders booking window in loop and takes wished car id and timeslot as long as time overlap exists (is true) with previous booking
		//Creates new Booking instance and adds this to db
		//Renders receipt and payment window
		
		boolean timeOverlap = true;
		int carId = 1;
		String duration = "1";
		String startTime = "";
		String endTime = "";
		int count = 1;
		int carCount = Db1.getCarCount();
		
		while (timeOverlap) {
			String decision[] = R1.renderBookingWindow(count, carCount);
			startTime = decision[1];
			duration = decision[2];
			int endHour = Integer.parseInt(startTime.split("-")[0]) + Integer.parseInt(duration);
			endTime = String.valueOf(endHour) + "-" + startTime.split("-")[1] + "-" + startTime.split("-")[2];
			carId = Integer.parseInt(decision[0]);
			timeOverlap = Db1.checkTimeSlot(carId, startTime, endTime);

			//Unavailable timeslot when timeOverlap is true
			if (timeOverlap) {
				R1.unavailableTimeslot();
			}
			count++;
		}
		String[] timeSlot = { startTime, endTime };
		Booking B1 = new Booking(currentUsername, carId, Integer.parseInt(duration), Db1.getCar(carId).getHourlyPrice(), timeSlot);
		Db1.addBoking(B1);
		double totalPrice = Double.parseDouble(duration) * Db1.getCar(carId).getHourlyPrice();
		R1.renderReceipt(Db1.getCar(carId).getModel(), Db1.getCar(carId).getBrand(), timeSlot, Db1.getCar(carId).getCarLocation(), totalPrice);
		R1.renderPaymentWindow();
	}

	public void handleCarOwnerActions() {
		// Search for car in db for the current username
		Car c1 = Db1.getUsersCar(currentUsername);
		int decision = R1.renderCarOwnerMenu();

		// Register car if user don't have one already
		if (decision == 1) {
			if (c1 == null) {
				String[] carInfo = R1.renderCarRegistration(1);
				Car C1 = new Car(currentUsername, carInfo[0], carInfo[1], Double.parseDouble(carInfo[2]), carInfo[3]);
				Db1.addCar(C1);
			} else if (c1 != null) {
				R1.renderCarRegistration(0);
			}
		}

		// Updates car if it exists
		else if (decision == 2) {
			if (c1 == null) {
				R1.renderUpdateCar(0, false);
			} else if (c1 != null) {
				String availability = "";
				if (c1.getIsAvailable() == true) {
					availability = "available";
				} else if (c1.getIsAvailable() == false) {
					availability = "unavailable";
				}

				R1.renderCarDetails(c1.getBrand(), c1.getModel(), c1.getCarLocation(), availability,
						c1.getHourlyPrice());

				String[] update = R1.renderUpdateCar(decision, c1.getIsAvailable());

				// Update location
				if (Integer.parseInt(update[0]) == 1) {
					c1.setCarLocation(update[1]);
				}
				// Update price
				else if (Integer.parseInt(update[0]) == 2) {
					c1.setHourlyPrice(Double.parseDouble(update[1]));
				}
				// Change availability
				else if (Integer.parseInt(update[0]) == 3) {
					c1.setIsAvailable(Boolean.parseBoolean(update[1]));
				}
				// Delete car
				else if (Integer.parseInt(update[0]) == 4) {
					Db1.removeCar(c1.getCarId());
					;
				}
			}
		} else if (decision == 3) {
			}
	}

	public void addAdministrator(Administrator A1) {
		Db1.addAdministrator(A1);
	}

	public void addInitialCars() {
		Car car1 = new Car("mk", "ferrari", "458", 400, "vesterbro");
		Car car2 = new Car("mk", "ferrari", "daytona", 400, "vesterbro");
		Car car3 = new Car("mk", "ferrari", "california", 500, "kbh k");
		Car car4 = new Car("mk", "ferrari", "250gto", 600, "kbh k");
		Car car5 = new Car("mk", "ferrari", "f12", 600, "kbh k");

		Db1.addCar(car1);
		Db1.addCar(car2);
		Db1.addCar(car3);
		Db1.addCar(car4);
		Db1.addCar(car5);
	}
}
