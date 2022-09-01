package com.revature.dao;

import java.util.Set;

import com.revature.models.Account;

public interface AccountDao {

		//Create account after Customer registration
		int createAccount(int accountId, long accountBal, boolean status);
		
		//Display account balance 
		Account checkBalance(int accountId);	
		
		//Display account details
		Account viewAccount(int accountId);
		Set<Account> viewAllAccounts();
		
		//Approve account by Employee/Admin; takes in EmployeeID as input
		void approveAccountBy(int accountId, int approveBy, boolean status);
		
		//Deny account by Employee/Admin; takes in EmployeeID as input
		void denyAccountBy(int accountId, int deletedBy, boolean status);
		
		//View all approved/denied accounts
		Account viewApprovedAccounts(boolean status);
		Account viewDeniedAccounts(boolean status);
		
		//Set approval/denial of account
		Boolean setStatus(boolean status);
	
		//Delete account
		void cancelAccount(int accountId);
		
		//Make a deposit
		void makeDeposit(int accountBal, int accountId);
				
		//Make a withdrawal
		void makeWithdrawal(int accountBal, int accountId);
		
		//Make a transfer
		void makeTransfer(int accountBal, int accountId);
}
