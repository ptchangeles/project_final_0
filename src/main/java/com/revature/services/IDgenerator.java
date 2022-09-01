package com.revature.services;

import java.util.Random;

public class IDgenerator {

	public int empIdGen() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(20000);
	}
	
	public int accNoGen() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(50000);
	}

	public static void main(String[] args) {

		IDgenerator empId = new IDgenerator();
		int employeeId = empId.empIdGen();
		int accountNo = empId.accNoGen();
		System.out.println(employeeId);
		System.out.println(accountNo);
}
}