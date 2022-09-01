package com.revature.controller.view;

import java.util.Scanner;

import com.revature.dao.TransactionDaoImpl;
import com.revature.models.Transaction;
import com.revature.services.TransactionService;

public class TransactionRecordsManagement {

	Scanner sc = new Scanner(System.in);
	TransactionService ts = new TransactionService();
	TransactionDaoImpl td = new TransactionDaoImpl();
	Transaction t = new Transaction(0, 0, 0, null);
	
	public void manageTransactions() {
		
		System.out.println("Welcome to Transaction Records Management");
		System.out.println("Please select an option:");
		System.out.println("1 - Record a transaction.");
		System.out.println("2 - View transaction by date.");
		System.out.println("3 - View transaction by type.");
		System.out.println("4 - View transaction by account.");
		System.out.println("5 - View all transaction history.");
		System.out.println("Enter input:");
		int input = sc.nextInt();
		switch (input){
			case 1: 
				t.getAccountId();
				break;
			case 2:
				System.out.println("Type transaction date:");
				System.out.println("yyyy-mm-dd");
				//draft
				break;
			case 3:
				int type = sc.nextInt();
				ts.viewTransByType(type);
			case 4:
				int account = sc.nextInt();
				ts.viewTransByAccount(account);
			case 5:
				ts.getAllTransaction();
			
		}
	} 	public static void main(String[] args) {
		TransactionRecordsManagement t = new TransactionRecordsManagement();
		t.manageTransactions();
} 
}
