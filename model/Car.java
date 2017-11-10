package model;

public class Car {
	String brand;
	String model;
	int carId;
	double dailyPrice;
	String carLocation;
	Boolean isAvailable;
	
	public Car() {
		//No-arg constructor
	}
	
	public Car(String brand, String model, int carId, double dailyPrice, String carLocation) {
		this.brand = brand;
		this.model = model;
		this.carId = carId;
		this.dailyPrice = dailyPrice;
		this.carLocation = carLocation;
		this.isAvailable = true;
	}

	public void toggleAvailability() {
		this.isAvailable = !isAvailable;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getCarLocation() {
		return carLocation;
	}

	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
