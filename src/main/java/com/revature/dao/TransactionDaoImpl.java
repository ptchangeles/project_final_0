package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import com.revature.models.Transaction;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class TransactionDaoImpl implements TransactionDao{

	@Override
	public void enterTransType(int transType) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("UPDATE transactions SET trans_type = ? WHERE acc_id = ?");
			st.setInt(3, transType);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful update of transaction type of user data.");
		}
	     catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update user data.", e);
		}
	}
	@Override
	public Transaction viewTransByDate(LocalDateTime transDate) {
		Transaction getByTransDate = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from transactions WHERE trans_date = ?");
			st.setObject(4, transDate);
			ResultSet rs = st.executeQuery();
			
			int t_transNo;
			int t_accountId;
			int t_transType;
			LocalDateTime t_transDate;
			
			if ((rs.next())){
				t_transNo = rs.getInt("trans_no");
				t_accountId = rs.getInt("acc_id");
				t_transType = rs.getInt("trans_type");
				t_transDate = (LocalDateTime) rs.getObject("trans_date");
			
					
				getByTransDate= new Transaction(t_transNo, t_accountId, t_transType, t_transDate);
			LoggingUtil.getLogger().info("Single record(Customer registration) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Customer Registration.");
	} 	return getByTransDate;
		
	}

	@Override
	public Transaction viewTransByType(int transType) {
		Transaction getByTransType = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from transactions WHERE trans_type = ?");
			st.setInt(3, transType);
			ResultSet rs = st.executeQuery();
			
			int t_transNo;
			int t_accountId;
			int t_transType;
			LocalDateTime t_transDate;
			
			if ((rs.next())){
				t_transNo = rs.getInt("trans_no");
				t_accountId = rs.getInt("acc_id");
				t_transType = rs.getInt("trans_type");
				t_transDate = (LocalDateTime) rs.getObject("trans_date");
			
					
				getByTransType= new Transaction(t_transNo, t_accountId, t_transType, t_transDate);
			LoggingUtil.getLogger().info("Single record(Customer registration) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Customer Registration.");
	} 	return getByTransType;
		
	}

	@Override
	public Transaction viewTransByAccount(int accountId) {
		Transaction getByAcc = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from transactions WHERE acc_id = ?");
			st.setInt(2, accountId);
			ResultSet rs = st.executeQuery();
			
			int t_transNo;
			int t_accountId;
			int t_transType;
			LocalDateTime t_transDate;
			
			if ((rs.next())){
				t_transNo = rs.getInt("trans_no");
				t_accountId = rs.getInt("acc_id");
				t_transType = rs.getInt("trans_type");
				t_transDate = (LocalDateTime) rs.getObject("trans_date");
			
					
				getByAcc = new Transaction(t_transNo, t_accountId, t_transType, t_transDate);
			LoggingUtil.getLogger().info("Single record(Customer registration) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Customer Registration.");
	} 	return getByAcc;
		
	}

	@Override
	public Set<Transaction> getAllTransaction() {
		Set<Transaction> getAllTrans = new TreeSet<Transaction>();
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from transactions");
			ResultSet rs = st.executeQuery();
			
			Transaction tempTrans;
			int t_transNo;
			int t_accountId;
			int t_transType;
			LocalDateTime t_transDate;
			
			if ((rs.next())){
				t_transNo = rs.getInt("trans_no");
				t_accountId = rs.getInt("acc_id");
				t_transType = rs.getInt("trans_type");
				t_transDate = (LocalDateTime) rs.getObject("trans_date");
				
				tempTrans = new Transaction(t_transNo, t_accountId, t_transType, t_transDate);
				getAllTrans.add(tempTrans);
			}
		} catch (SQLException e) {
			LoggingUtil.getLogger().warn("Unable to display database data", e);
		} LoggingUtil.getLogger().trace(getAllTrans.size() + " currently listed data");
		
	return getAllTrans;
	}

	@Override
	public void recordTransaction(Transaction transaction) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("INSERT into user values (?, ?, ?)");
			st.setInt(2, transaction.getAccountId());
			st.setInt(3, transaction.getTransType());
			st.setObject(4, transaction.getTransDate());
			
			st.execute();
			LoggingUtil.getLogger().info("Successful Attempt to record single transaction.");
	} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to record single transaction.");
	} 
		
	}
	public void toString(LocalDateTime transDate) {
		// TODO Auto-generated method stub
		
	}

	

}
