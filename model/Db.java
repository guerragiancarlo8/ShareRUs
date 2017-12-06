package model;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Car;
import model.Booking;

public class Db {

	private ArrayList<Car> carDb;
	private ArrayList<Booking> bookingDb;
	private static File userDb;

	//Uses buffered writer/reader on top of file writer/reader as a more efficient version 
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	BufferedWriter bw = null;

	public Db() {
		//initializes databases
		carDb = new ArrayList<Car>();
		bookingDb = new ArrayList<Booking>();
		userDb = new File("userDb.txt");
	}

	public void addCar(Car C1) {
		carDb.add(C1);
	}

	public void removeCar(int carId) {
		int i = 0;
		while (carId != carDb.get(i).getCarId()) {
			i++;
		}
		carDb.remove(i);
	}

	public Car getCar(int carId) {
		int i = 0;
		for (i = 0; i < carDb.size(); i++) {
			if (carId == carDb.get(i).getCarId()) {
				break;
			}
		}
		return carDb.get(i);
	}

	public int getCarCount() {
		int carCount = carDb.size();
		return carCount;
	}

	public Car getUsersCar(String username) {
		Car c1 = new Car();
		c1 = null;

		int i = 0;
		while (carDb.size() > i) {
			if (username.equals(carDb.get(i).getOwnerUserame())) {
				c1 = carDb.get(i);
				break;
			}
			i++;
		}
		return c1;
	}

	public void addBoking(Booking B1) {
		bookingDb.add(B1);
	}

	public void removeBooking(int bookingId) {
		int i = 0;
		while (bookingId != bookingDb.get(i).getBookingId()) {
			i++;
		}
		bookingDb.remove(i);
	}

	public void addAdministrator(Administrator A1) {
		//Writes administrator details to userdb.txt file and ends new line, ready to write next user
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(userDb, true))) {
			String administrator = A1.getUserType() + " " + A1.getUsername() + " " + A1.getPassword() + " " + A1.getFirstName() + " " + A1.getLastName() + " " + A1.getCpr() + " " + "\n";
			bw.write(administrator);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(Customer C1) {
		//Writes customer details to userdb.txt file and ends new line, ready to write next user
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(userDb, true))) {
			String customer = C1.getUserType() + " " + C1.getUsername() + " " + C1.getPassword() + " " + C1.getFirstName() + " " + C1.getLastName() + " " + C1.getCpr() + " " + "\n";
			bw.write(customer);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUser(String username) {
		//Loop runs through file line (user) by line (user) (as long as line is not empty) 
		//exits and store user details in string currentLine when username matches the line. 
		//returns userDetails
		String userDetails = "";
		try {
			String currentLine = "";
			fr = new FileReader(userDb);
			br = new BufferedReader(fr);
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.indexOf(username) != -1) {
					userDetails = currentLine;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return userDetails;
	}
	
	public ArrayList<String[]> browseCarBy(int decision) {
		//Runs through carDb ArrayList, finds/adds certain (available) car info (given the passed decision) and ID to browsedCars ArrayList
		ArrayList<String[]> browsedCars = new ArrayList<String[]>();
		int count = 0;

		switch (decision) {
		//browse by price
		case 1:
			while (carDb.size() > count) {
				if (carDb.get(count).getIsAvailable() == true) {
					String car[] = { Integer.toString(carDb.get(count).getCarId()),
							Double.toString(carDb.get(count).getHourlyPrice()) };
					browsedCars.add(car);
				}
				count++;
			}
			break;
		//browse by location
		case 2:
			while (carDb.size() > count) {
				if (carDb.get(count).getIsAvailable()) {
					String car[] = { Integer.toString(carDb.get(count).getCarId()), carDb.get(count).getCarLocation() };
					browsedCars.add(car);
				}
				count++;
			}
			break;
		//browse by brand and model
		case 3:
			while (carDb.size() > count) {
				if (carDb.get(count).getIsAvailable()) {
					String car[] = { Integer.toString(carDb.get(count).getCarId()),
							carDb.get(count).getBrand() + " " + carDb.get(count).getModel() };
					browsedCars.add(car);
				}
				count++;
			}
		}
		return browsedCars;
	}

	public ArrayList<String[]> carRentalCalender(int carId) {
		//Given the passed carId, finds booked time slots for the car and adds them to arraylist which is returned
		ArrayList<String[]> carRentalCalender = new ArrayList<String[]>();
		for (int i = 0; i < bookingDb.size(); i++) {
			if (bookingDb.get(i).getCarId() == carId) {
				carRentalCalender.add(bookingDb.get(i).getTimeSlot());
			}
		}
		return carRentalCalender;
	}

	public boolean checkTimeSlot(int carId, String startTime, String endTime) {
		//Compares passed timeslot (based on user input) with occupied timeslots in the carRentalCalender arraylist.
		//returns false if the passed timeslot does not overlap wit any existing timeslot - true if overlap exists
		
		boolean timeOverlap = false;

		ArrayList<String[]> carRentalCalender = carRentalCalender(carId);

		if (carRentalCalender.size() == 0) {
			timeOverlap = false;
		}
		else if (carRentalCalender.size() != 0) {
			DateFormat format = new SimpleDateFormat("H-d-M");
			
			try {
				Date start1 = format.parse(startTime);
				System.out.println(start1);
				Date end1 = format.parse(endTime);
				System.out.println(end1);
				for (int i = 0; i < carRentalCalender.size(); i++) {
					Date start2 = format.parse(carRentalCalender.get(i)[0]);
					Date end2 = format.parse(carRentalCalender.get(i)[1]);

					timeOverlap = (end2.after(start1)) && (end1.after(start2));

					if (timeOverlap) {
						break;
					}
				}

			}
			catch (ParseException ex) {
				ex.printStackTrace();
			}
		}
		return timeOverlap;
	}
}
