package model;

public class Booking {
	private String userName;
	private int carId;
	private double totalPrice;
	private String[] timeSlot;
	private int bookingId;

	public Booking(String userName, int carId, int hours, double hourlyPrice, String[] timeSlot) {
		this.userName = userName;
		this.carId = carId;
		this.totalPrice = hours * hourlyPrice;
		this.timeSlot = timeSlot;
		this.bookingId = setBookingId();
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

	public String[] getTimeSlot() {
		return this.timeSlot;
	}

	public void setTimeSlot(String startTime, String endTime) {
		String[] timeSlot = { startTime, endTime };
		this.timeSlot = timeSlot;
	}

	public int getBookingId() {
		return bookingId;
	}

	public int setBookingId() {
		this.bookingId = bookingId;
		return bookingId;
	}

}
