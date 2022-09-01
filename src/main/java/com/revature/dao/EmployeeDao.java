package com.revature.dao;

import java.util.Set;

import com.revature.models.Employee;

public interface EmployeeDao {

		//Create a record of an employee
		void createEmployeeRecord(Employee employee);
		
		//View a record of an employee by ID
		Employee viewEmployeeRecordById(int employeeId);
		
		//View a record of an employee by role
		Employee viewEmployeeRecordByRole(int role);
		
		//View all employee records
		Set<Employee> viewAllEmployees();
		
		//Update a record of an employee
		void updateEmployeeRecord(Employee employee);
		
		//Delete a record of an employee
		void deleteEmployeeRecordbyId(int employeeId);
		
		//Assign a role/permission of an employee
		void assignRole(int role);
		
}
