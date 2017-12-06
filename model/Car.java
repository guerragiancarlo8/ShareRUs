package model;

public class Car {
	private String ownerUserame;
	private String brand;
	private String model;
	private int carId;
	private double hourlyPrice;
	private String carLocation;
	private Boolean isAvailable;

	static int carCounter = 0;

	public Car() {
		// No-arg constructor
	}

	public Car(String ownerUsername, String brand, String model, double hourlyPrice, String carLocation) {
		carCounter++;
		this.carId = carCounter;
		this.ownerUserame = ownerUsername;
		this.brand = brand;
		this.model = model;
		this.hourlyPrice = hourlyPrice;
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

	public double getHourlyPrice() {
		return hourlyPrice;
	}

	public void setHourlyPrice(double hourlyPrice) {
		this.hourlyPrice = hourlyPrice;
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

	public String getOwnerUserame() {
		return ownerUserame;
	}

	public void setOwnerUserame(String ownerUserame) {
		this.ownerUserame = ownerUserame;
	}
}
