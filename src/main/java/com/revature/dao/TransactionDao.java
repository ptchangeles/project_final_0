package com.revature.dao;

import java.time.LocalDateTime;
import java.util.Set;

import com.revature.models.Transaction;

public interface TransactionDao {

			//Create transaction entry
			void recordTransaction(Transaction transaction);
	
			//Update transaction type for account
			void enterTransType(int transType);
			
			//View transaction history by date
			Transaction viewTransByDate(LocalDateTime transDate);
			
			//View transaction history by transaction type
			Transaction viewTransByType(int transType);
			
			//View transaction history of account holder
			Transaction viewTransByAccount(int accountId);
			
			//View all transaction history of all accounts
			Set<Transaction> getAllTransaction();
}
