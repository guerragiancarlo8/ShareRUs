package model;

import java.util.ArrayList;
import java.io.*;
import model.Car;
import model.Booking;

public class Db {
	//Start by declaring the individual db
	private ArrayList<Car> carDb;
	private ArrayList<Booking> bookingDb;
	private File userDb;

	PrintWriter output = new PrintWriter(userDb);	
	//buffered writer
	public Db() {
		carDb = new ArrayList<Car>();
		bookingDb = new ArrayList<Booking>();
		userDb = new File("userDb.txt");
	}
	 
	public void addCar(Car C1) {
		carDb.add(C1);
	}
	
	public void removeCar(int carId) {
		int i = 0;
		while(carId != carDb.get(i).getCarId()) {
			i++;
		}
		carDb.remove(i);
	}
	
	public void updateCar(int carId) {
		
	}
	
	public Car getCar(int carId) {
		int i = 0;
		while(carId != carDb.get(i).getCarId()) {
			i++;
		}
		return carDb.get(i);
	}
	
	public void addBoking(Booking B1) {
		bookingDb.add(B1);
	}
	
	public void removeBooking(int bookingId) {
		int i = 0;
		while(bookingId != bookingDb.get(i).getBookingId()) {
			i++;
		}
		bookingDb.remove(i);
	}
	
	public void addUser(User U1) {
		output.print(U1.getFirstName() + " " + U1.getLastName() + " " + U1.getCpr() + " " + U1.getUserType() + " " + U1.getUsername() + " " + U1.getPassword() + " " + U1.isLoggedIn());
		output.close();
	}
	
	public void removeUser(String username) {
		int i = 0;
		while(username != userDb.get(i).getUsername()) {
			i++;
		}
		userDb.remove(i);
	}
	
	public void updateUser(String username) {
		
	}
	
	public User getUser(String username) {
		int i = 0;
		while(username != userDb.get(i).getUsername()) {
			i++;
		}
		return userDb.get(i);
	}
	
	public ArrayList<String> browseCarBy(int decision) {
		ArrayList<String> browsedCars = new ArrayList<String>();
		int count = 0;
		switch(decision) {
		case 1: 
			while(carDb.size() > count) {
				if (carDb.get(count).isAvailable) {
					browsedCars.add(Double.toString(carDb.get(count).getDailyPrice()));
				}
			}
			break;
		case 2:
			while(carDb.size() > count) {
				if (carDb.get(count).isAvailable) {
					browsedCars.add(carDb.get(count).getCarLocation());
				}
			}
			break;
		case 3:
			while(carDb.size() > count) {
				if (carDb.get(count).isAvailable) {
					browsedCars.add(carDb.get(count).getBrand() + "" + carDb.get(count).getModel());
				}
			}
		}
		return browsedCars;
	}
	
	public void carRentalHistory(int carId) {
		
	}
}
