package model;

import java.time.LocalDate;
import model.Db;

public class Booking {
	private LocalDate date;
	private String userName;
	private int carId;
	private double totalPrice;
	private int bookingId;
	
	public Booking(String userName, int carId, int days, int dailyPrice, int bookingId) {
		this.date = LocalDate.now();
		this.userName = userName;
		this.carId = carId;
		this.totalPrice = days * dailyPrice;
		this.bookingId = bookingId;
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double dailyPrice, int days) {
		this.totalPrice = dailyPrice * days;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
}
