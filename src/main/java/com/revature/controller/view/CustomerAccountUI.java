package com.revature.controller.view;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.services.AccountService;

public class CustomerAccountUI {

	public void doTransactions() {
		
		Scanner sc = new Scanner(System.in);
		AccountService ac = new AccountService();
		LoginUI log = new LoginUI();
		CustomerAccountUI ca = new CustomerAccountUI();
		
		
		System.out.println("Before continuing, please enter your account no:");
		int accNo = sc.nextInt();
		ac.viewAccount(accNo);
		
		System.out.println("What would you like to do for today?");
		System.out.println("1 - Check balance");
		System.out.println("2 - Make a deposit");
		System.out.println("3 - Make a withdrawal");
		System.out.println("4 - Make a transfer");
		System.out.println("5 - Logout");
		int input = sc.nextInt();
		
		switch (input){
		case 1:
			Account balance = ac.checkBalance(accNo);
			System.out.println(balance);
			break;
		case 2:
			System.out.println("Enter deposit amount:");
			int depAmount = sc.nextInt();
			ac.makeDeposit(accNo, depAmount);
			break;
		case 3:
			System.out.println("Enter withdrawal amount:");
			int withAmount = sc.nextInt();
			ac.makeWithdrawal(accNo, withAmount);
			break;
		case 4:
			System.out.println("Enter the account you wish to transfer to:");
			int transAccount = sc.nextInt();
			System.out.println("Enter the amount for transfer:");
			int transAmount = sc.nextInt();
			ac.makeTransfer(transAccount, transAmount);
			System.out.println("Your current balance is: ");
			Account newbalance = ac.checkBalance(accNo);
			System.out.println(newbalance);
			break;
		case 5:
			sc.close();
			log.doLogin();
			break;
		default:
			ca.doTransactions();
		}
	}
}
