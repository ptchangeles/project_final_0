package com.revature.controller.view;

import java.util.Scanner;

import com.revature.dao.UserDaoImpl;
import com.revature.models.User;
import com.revature.services.LoginService;

public class SignUpLoginUI {
		
	LoginService userLogin = new LoginService();
	Scanner sc = new Scanner(System.in);
	UserDaoImpl us = new UserDaoImpl();
	
	public User signUpLoginCredentials(){
		
		String username = null;
		String password = null;
		String emailAdd = null;
		String input = null;
		
	do {	
		System.out.println("We are glad to have you on board!");
		System.out.println("To continue using the application , please sign up below:");
		System.out.println("Please enter your username:");
		username = sc.next();
		System.out.println("Please enter your password:");
		password = sc.next();
		System.out.println("Please enter your e-mail address:");		
		emailAdd = sc.next();
		System.out.println("Please confirm your details below:");		
		System.out.println(username + "\n" + password + "\n" + emailAdd + "\n");		
		
		System.out.println("Type Yes if it's correct. Type No if you want to edit your details.");
		input = sc.next();
	} while (input.equalsIgnoreCase("No"));	
		System.out.println("Thank you for signing up! Please take note of your user ID below that will be needed for registration.");
		
		User user = new User (username, password, emailAdd);
		int userId = us.createUser(user);
		System.out.println(userId);
		System.out.println("Your login account is confirmed. Redirecting you to login.");

		return user;
		
	}
}
