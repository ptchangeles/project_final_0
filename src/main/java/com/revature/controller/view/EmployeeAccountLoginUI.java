package com.revature.controller.view;

import java.util.Scanner;

import com.revature.dao.EmployeeDaoImpl;

public class EmployeeAccountLoginUI {

	private static Scanner sc = new Scanner(System.in);
	EmployeeDaoImpl emp = new EmployeeDaoImpl();
	
	public void doEmployeeAccess(){
		
		System.out.println("Please enter your employee ID to gain access:");
		int employeeId = sc.nextInt();
		emp.viewEmployeeRecordById(employeeId);
		int role = sc.nextInt();
		///DRAFT
		if (role != 2) {
			System.out.println("Access denied.");
		}
		System.out.println("Access approved.");
		
		System.out.println("Please select an option");
		System.out.println("1 - Manage customer accounts.");
		System.out.println("2 - Manage transactions.");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("Redirecting you to Customer Accounts Management.");
			
		}
		System.out.println("Redirecting you to Transaction Records Management");
	}
}
