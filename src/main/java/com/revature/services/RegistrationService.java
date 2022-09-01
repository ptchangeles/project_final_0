package com.revature.services;

import com.revature.dao.CustomerDaoImpl;
import com.revature.models.Customer;

public class RegistrationService {

	private static CustomerDaoImpl cDao = new CustomerDaoImpl();

	//DRAFT!
	public RegistrationService() {
		super();
	}
	
	public RegistrationService(CustomerDaoImpl cs) {
		cDao = cs;
	}
	
	public void registerCustomer(Customer customer) {
		cDao.registerCustomer(customer);
	}
	
	Customer viewCustomerInfo(int accountId) {
		return cDao.viewCustomerInfo(accountId);
	}
	
	void updateCustomerInfo(int userId, String fname, String lname, String address) {
		cDao.updateCustomerInfo(userId, fname,lname, address);
	}
	
	void deleteCustomerInfo(int accountId) {
		cDao.deleteCustomerInfo(accountId);
	}
	
}
