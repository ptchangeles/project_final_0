package com.revature.main;


import java.util.TreeSet;


import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.services.AccountService;



public class Driver {

	public static void main(String[] args) {
		
		UserDaoImpl us = new UserDaoImpl();
		//create user - working 
		User user = new User("John", "Doe", "john@email.com");
		us.createUser(user);
		//System.out.println(user.getUsername() + user.getPassword() + id);
		
		
		//get user by id - working
		//User user = us.getUserById(3);
		//System.out.println();
	
		//get all users - printing only one
		//TreeSet<User> tSetUsers = new TreeSet<User>();
		//tSetUsers.add(new User());
		//us.getAllUsers();
		//System.out.println(us.getAllUsers());
	
		//working - update user
		//us.updateUser(3, "user3", "pass3", "email3@email.com");
		
		//working - deleting user
		//us.deleteUserById(3);
		
		//working - existinguser, readuser, checkpassword
		
		//SignUpLoginUI signUp = new SignUpLoginUI();
		//signUp.signUpLoginCredentials();
		
		//CustomerDaoImpl cs = new CustomerDaoImpl();
		//create customer - working
		//Customer customer = new Customer(1, "Patch", "Angeles", "Bellflower");
		//int accountId = cs.registerCustomer(customer);
		//System.out.println(accountId);
		
		//view customer - working
		//Customer customer = cs.viewCustomerInfo(1);
		//System.out.println(customer);
		
		//update customers -working
		//cs.updateCustomerInfo(1, "Evan", "Angeles", "LA");
		
		//delete customer - working
		//cs.deleteCustomerInfo(4);
		
		//create an account  - working 
		AccountService ac = new AccountService();
		//ac.createAccount(12, 2000000, true);
		
		//view account - working
		//Account account = ac.viewAccount(23);
		//System.out.println(account);
		
		//approve account - working
		//ac.approveAccountBy(22, 1, true);
		
		//deny account - working
		//ac.denyAccountBy(23, 2, false);
		
		//check balance - needs work
		Account account = ac.checkBalance(12);
		String values = account.toString();
		String s2 = String.valueOf(account);
		System.out.println(values);
		System.out.println(s2);
		
		//update balance - working
		//ac.makeDeposit(2000000, 22);
		
		
	}
	
}
