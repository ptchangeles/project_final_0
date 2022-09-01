package com.revature.controller.view;

import java.util.Scanner;

import com.revature.dao.CustomerDaoImpl;
import com.revature.services.LoginService;
import com.revature.services.RegistrationService;

public class HomeUI {


public static void main(String[] args) {
	
	LoginUI goToLogin = new LoginUI();
	SignUpLoginUI goToSignUp = new SignUpLoginUI();

	 Scanner sc = new Scanner(System.in);
	 System.out.println("= = = = = = = = = = = = = = = = = =");
	 System.out.println(" Welcome to the RIGHT CHOICE bank! ");
	 System.out.println("= = = = = = = = = = = = = = = = = =");
	 System.out.println("Please login/register to continue.");
	 System.out.println("1 - Login Account");
	 System.out.println("2 - Register for an account");
	 System.out.println("Enter input:");
	 
	 int input = sc.nextInt();
	 if (input == 1) {
		 goToLogin.doLogin();
	 } else {
		 System.out.println("Redirecting you to the Sign Up page...");
		 goToSignUp.signUpLoginCredentials();
		 sc.close();
	 }
}
}
