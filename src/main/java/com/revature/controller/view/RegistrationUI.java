package com.revature.controller.view;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.services.RegistrationService;

public class RegistrationUI {

	RegistrationService userRegister = new RegistrationService();
	Scanner sc = new Scanner(System.in);
	
	public void doRegister() {
		
		int userId;
		String fname = null;
		String lname = null;
		String address = null;
		String input;
	
	do {			
		System.out.println("Register for an account.");
		System.out.println("Please type your details below.");
		System.out.println("Enter your registered user_id:");
		userId = sc.nextInt();
		
		System.out.println("First name:");
		fname = sc.next();
		
		System.out.println("Last name:");
		lname = sc.next();
	
		System.out.println("Address:");
		address = sc.next();
	
		System.out.println("Confirm your details below.");
		System.out.println("First name: " + fname +"\n" + "Last name: "+ lname + "\n" +"Address: "+ address + "\n");
		System.out.println("Type Yes if it's correct. Type No if you want to edit your details.");
		input = sc.next();
		
	} while (input.equalsIgnoreCase("No"));	
		Customer customer = new Customer(userId, fname, lname, address);
		userRegister.registerCustomer(customer);
		System.out.println("Thank you! We look forward in doing business with you.");
		System.out.println("Check your email within 24 hours to see if your application has been approved.");
		System.out.println("Redirecting you to the login page...");
	
	}
}
