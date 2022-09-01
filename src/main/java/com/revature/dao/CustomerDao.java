package com.revature.dao;

import com.revature.models.Customer;

public interface CustomerDao {

	
	//Register for an account
	int registerCustomer(Customer customer);
	
	
	//Display registered information
	Customer viewCustomerInfo(int userId);
	
	//Update registered information
	int updateCustomerInfo(int userId, String fname, String lname, String address);
	
	//Delete registered information
	void deleteCustomerInfo(int accountId);
}
