package com.revature.services;

import java.util.Set;

import com.revature.dao.AccountDaoImpl;
import com.revature.models.Account;
import com.revature.util.LoggingUtil;

public class AccountService {

	private static AccountDaoImpl aDao = new AccountDaoImpl();

	public AccountService() {
		super();
	}
	
	public AccountService(AccountDaoImpl ai) {
		aDao = ai;
	}
	//DRAFT!!
	
	public int createAccount(int accountId, int accountBal, boolean status) {
		return aDao.createAccount(accountId, accountBal, status);
	}
	
	public Account checkBalance(int accountId) {
		return aDao.checkBalance(accountId);
	}
	
	public Account viewAccount(int accountId) {
		return aDao.viewAccount(accountId);
	}
	
	public Set<Account> viewAllAccounts(){
		return aDao.viewAllAccounts();
	}
	
	public void approveAccountBy(int accountId, int approveBy, boolean status) {
		aDao.approveAccountBy(accountId, approveBy, status);
	}
	
	public void denyAccountBy(int accountId, int deletedBy, boolean status) {
		aDao.denyAccountBy(accountId, deletedBy, status);
	}
		
	public Account viewApprovedAccounts(boolean status) {
		return aDao.viewApprovedAccounts(status);
	}
	public Account viewDeniedAccounts(boolean status) {
		return aDao.viewDeniedAccounts(status);
	}
	
	public Boolean setStatus(boolean status) {
		return aDao.setStatus(status);
	}
	
	void cancelAccount(int accountId) {
		aDao.cancelAccount(accountId);
	}
	
	public void makeDeposit(int accountBal, int accountId) {
		aDao.makeDeposit(accountBal, accountId);
		
	}
			
	public void makeWithdrawal(int accountBal, int accountId) {
		if (aDao.checkBalance(accountBal) != null) {
				System.out.println("You do not have enough balance for this transaction");
			} else {
				aDao.makeWithdrawal(accountBal, accountId);
		}
	}
	
	public void makeTransfer(int accountBal, int accountId) {
		if (aDao.checkBalance(accountBal) != null) {
		} else {
		aDao.makeTransfer(accountBal, accountId);
		}
	}
	
}
