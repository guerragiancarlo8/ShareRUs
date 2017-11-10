package control;

import view.Render;
import model.Booking;

import java.util.Scanner;
import java.util.ArrayList;

import model.Db;
import model.User;
import model.Login;

public class Controller {
	
	Render R1 = new Render();
	Db Db1 = new Db();


	public static void main(String[] args) {
	
		//String type;
		//int currentUserId;
	}
	
	private void handleMenu() {
		int decision = R1.renderStartMenu();
		switch(decision) {
		case 1: 
			handleRegistrationWindow();
		case 2: 
			handleLoginWindow();
			break;
		case 3:
			//browsecars
		}	
	}
	
	public void handleRegistrationWindow() {
		String[] info = R1.renderRegistrationWindow();
		User U1 = new User(info[0], info[1], info[2], info[3]);
		R1.renderUserdetails(U1);
	}

	public void handleLoginWindow() {
		Login L1 = new Login();
		int count = 1;
		
		String[] info = R1.renderLoginWindow();
		//L1.login(info[0], info[1], Db1);
	}
	
	public int handleBrowseCarWindow() {
		ArrayList<String> browsedCars = new ArrayList<String>();
		int i = 0;
		int decision = R1.renderBrowseCarDb(i, browsedCars);
		browsedCars = Db1.browseCarBy(decision);
		i++;
		decision = R1.renderBrowseCarDb(i, browsedCars);
		return decision;
	}
	
	public void handleBooking(int carId) {
		//days
		//price
	}
	
	public void handlePrintReceipt() {
		Booking B1 = new Booking();
		Db1.addBoking(B1);
	}
	
	public void handleAdminActions() {
		
	}
}
