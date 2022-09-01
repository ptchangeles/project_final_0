package com.revature.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import com.revature.dao.TransactionDaoImpl;
import com.revature.models.Transaction;

public class TransactionService {

	public static TransactionDaoImpl tDao;
	
	public TransactionService() {
		super();
		tDao = new TransactionDaoImpl();
	}

	public TransactionService(TransactionDaoImpl td) {
		super();
		tDao = td;
	}
	
	public void recordTransaction(Transaction transaction) {
		tDao.recordTransaction(transaction);
	}
	
	public void enterTransType(int transType) {
		tDao.enterTransType(transType);
	}
	
	public Transaction viewTransByDate(LocalDateTime transDate) {
		//DRAFT
		tDao.toString(transDate);
		//DRAFT
		return tDao.viewTransByDate(transDate);
	}
	
	public Transaction viewTransByType(int transType) {
		return tDao.viewTransByAccount(transType);
	}
	
	public Transaction viewTransByAccount(int accountId) {
		return tDao.viewTransByAccount(accountId);
	}
	
	public Set<Transaction> getAllTransaction(){
		return tDao.getAllTransaction();
	}
}
