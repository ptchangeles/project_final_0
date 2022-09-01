package com.revature.controller.view;

import java.util.Scanner;

import com.revature.services.LoginService;
import com.revature.util.LoggingUtil;

public class LoginUI {

	private static LoginService userLogin = new LoginService();
	private static Scanner sc = new Scanner(System.in);
	
	public void doLogin() {

		String username = null;
		String password = null;
		
		System.out.println("Please enter your username:");
		username = sc.nextLine();
		if (!userLogin.existingUser(username)) {
			LoggingUtil.getLogger().trace("Login attempt. No record found for user." );
			System.out.println("The username " + username + " does not exist.");
			LoginUI loginAgain = new LoginUI();
			loginAgain.doLogin();
		} else {
			System.out.println("Please enter your password:");
			password = sc.nextLine();
			if(userLogin.checkPassword(password)) {
				LoggingUtil.getLogger().trace("Login attempt. Record match for user.");
				System.out.println("Login successful!");
				LoggingUtil.getLogger().trace("Redirecting you to your account...");
			} else {
				System.out.println("Incorrect user credentials. Please try again.");
				LoginUI loginAgain = new LoginUI();
				loginAgain.doLogin();
			}
		}
			
		}
	} 

