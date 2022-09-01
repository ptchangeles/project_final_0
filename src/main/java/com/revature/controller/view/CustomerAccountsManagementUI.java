package com.revature.controller.view;

import java.util.Scanner;


import com.revature.dao.AccountDaoImpl;
import com.revature.services.AccountService;


public class CustomerAccountsManagementUI {
	
	private static Scanner sc = new Scanner(System.in);
	private static AccountService as = new AccountService();
	
	public void manageAccounts() {
		
		System.out.println("Welcome to Customer Accounts Management");
		System.out.println("Please select an option:");
		System.out.println("1 - View all customer accounts.");
		System.out.println("2 - Search for a customer account.");
		System.out.println("3 - View Approved accounts.");
		System.out.println("4 - View Denied accounts.");
		System.out.println("5 - Approve/Deny an account.");
		System.out.println("6 - Cancel an account.");
		System.out.println("Enter input:");
		int input = sc.nextInt();
		switch (input){
		case 1:
			as.viewAllAccounts();
			break;
		case 2:
			System.out.println("Type account ID:");
			int accountId = sc.nextInt();
			as.viewAccount(accountId);
			break;
		case 3:
			boolean status = true;
			as.viewApprovedAccounts(status);
			break;
		case 4:
			boolean status2 = false;
			as.viewApprovedAccounts(status2);
			break;
		case 5:
			System.out.println("Type account ID:");
			int accountId1 = sc.nextInt();
			as.viewAccount(accountId1);
			System.out.println("Do you want to approve or deny this account?");
			System.out.println("1 - Approve");
			System.out.println("2 - Deny");
			System.out.println("Enter your choice:");
			int input2 = sc.nextInt();
			if (input2 == 1) {
				as.setStatus(true);
				System.out.println("Account approved.");
			}
			as.setStatus(false);
			System.out.println("Account denied.");
			break;
		case 6:
			System.out.println("Please input your employee ID to gain access.");
			//DRAFT
			break;
		default:
			System.out.println("No input received. Please try again.");
		}
		
	}
}
