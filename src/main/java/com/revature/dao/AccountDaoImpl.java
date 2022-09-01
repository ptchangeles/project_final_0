package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public int createAccount(int accountId, long accountBal, boolean status) {
		String SQL = "INSERT INTO accounts(acc_id, acc_bal, status)" +
							"VALUES (?, ?, ?)";
		
		int id = 0;
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);{
				
				st.setInt(1, accountId);
				st.setLong(2, accountBal);
				st.setBoolean(3, status);
				
				int affectedRows = st.executeUpdate();
				
				if(affectedRows > 0) {
					try (ResultSet rs = st.getGeneratedKeys()){
						if(rs.next()) {
							id = rs.getInt(1);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} 
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return id;
	}
	@Override
	public Account viewAccount(int accountId) {
		String SQL = "SELECT * FROM accounts WHERE acc_id = ?";
		Account getByAcc= null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, accountId);
			ResultSet rs = st.executeQuery();
			
			int a_accountBal;
			 boolean a_status;
			
			if ((rs.next())){
				a_accountBal = rs.getInt("acc_bal");
				a_status = rs.getBoolean("status");
					
				getByAcc= new Account(accountId, a_accountBal, a_status);
			LoggingUtil.getLogger().info("Single record(Account details) has been viewed.");
			} 
			}catch (SQLException e) {
				
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Account Details).");
	} return getByAcc;
		
	
}
	@Override
	public void approveAccountBy(int accountId, int approveBy, boolean status) {
		String SQL = "UPDATE accounts SET approved_by = ?, status = ?" +
				"WHERE acc_id = ?";
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, approveBy);
			st.setBoolean(2, status);
			st.setInt(3, accountId);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful approval update of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to approve user data.", e);
		}
}
	@Override
	public void denyAccountBy(int accountId, int deletedBy, boolean status) {
		String SQL = "UPDATE accounts SET deleted_by = ?, status = ?" +
				"WHERE acc_id = ?";
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, deletedBy);
			st.setBoolean(2, status);
			st.setInt(3, accountId);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful deletion update of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update user data.", e);
		}
	}

@Override
	public Account viewApprovedAccounts(boolean status) {
		Account getByApp= null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from accounts WHERE status = true");
			st.setBoolean(7, status);
			ResultSet rs = st.executeQuery();
			
			 int a_accountId;
			 int a_accountBal;
			 int a_approveBy;
			 LocalDateTime a_appDate;
			 int a_deletedBy;
			 LocalDateTime a_delDate;
			 boolean a_status;
			
			if ((rs.next())){
				a_accountId = rs.getInt("acc_id");
				a_accountBal = rs.getInt("acc_bal");
				a_approveBy = rs.getInt("approved_by");
				a_appDate = (LocalDateTime) rs.getObject("a_appDate");
				a_deletedBy = rs.getInt("a_deletedBy");
				a_delDate = (LocalDateTime) rs.getObject("deleted_date");
				a_status = rs.getBoolean("status");
					
				getByApp= new Account(a_accountId, a_accountBal, a_status);
			LoggingUtil.getLogger().info("Single record(Approved account) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Approved account).");
	} 	return getByApp;
		
	}

	@Override
	public Account viewDeniedAccounts(boolean status) {
		Account getByDen= null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from accounts WHERE status = false");
			st.setBoolean(7, status);
			ResultSet rs = st.executeQuery();
			
			 int a_accountId;
			 int a_accountBal;
			 boolean a_status;
			
			if ((rs.next())){
				a_accountId = rs.getInt("acc_id");
				a_accountBal = rs.getInt("acc_bal");
			/*	a_approveBy = rs.getInt("approved_by");
				a_appDate = (LocalDateTime) rs.getObject("a_appDate");
				a_deletedBy = rs.getInt("a_deletedBy");
				a_delDate = (LocalDateTime) rs.getObject("deleted_date"); */
				a_status = rs.getBoolean("status");
					
				getByDen= new Account(a_accountId, a_accountBal, a_status);
			LoggingUtil.getLogger().info("Single record(Approved account) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Approved account).");
	} 	return getByDen;
	}

	@Override
	public Boolean setStatus(boolean status) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("UPDATE accounts SET status = ? WHERE acc_id = ?");
			st.setBoolean(7, status);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful approval update of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update user data.", e);
		}
		return status;
	}

	@Override
	public Set<Account> viewAllAccounts() {
		Set<Account> getAllAcc = new TreeSet<Account>();
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from accounts");
			ResultSet rs = st.executeQuery();
			
			 Account tempAcc;
			 int a_accountId;
			 int a_accountBal;
			 int a_deletedBy;
			 boolean a_status;
			
			if ((rs.next())){
				a_accountId = rs.getInt("acc_id");
				a_accountBal = rs.getInt("acc_bal");
				a_deletedBy = rs.getInt("a_deletedBy");
				a_status = rs.getBoolean("status");
				
				tempAcc = new Account(a_accountId, a_accountBal, a_status);
				getAllAcc.add(tempAcc);
			}
		} catch (SQLException e) {
			LoggingUtil.getLogger().warn("Unable to display database data", e);
		} LoggingUtil.getLogger().trace(getAllAcc.size() + " currently listed data");
		
	return getAllAcc;
	}

	@Override
	public Account checkBalance(int accountId) {
		String SQL = "SELECT * FROM accounts WHERE acc_id = ?";
		
		Account getByBal= null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, accountId);
			ResultSet rs = st.executeQuery();
			
			int a_acc_id;
			int a_accountBal;
			Boolean a_status;
			
			if ((rs.next())){
				
				a_acc_id = rs.getInt("acc_id");
				a_accountBal = rs.getInt("acc_bal");
				a_status = rs.getBoolean("status");
				
				getByBal = new Account(a_acc_id, a_accountBal, a_status);
				
			LoggingUtil.getLogger().info("Single record(Account details) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Account Details).");
	}
		return getByBal;
	}

	@Override
	public void cancelAccount(int accountId) {
		String SQL = "DELETE FROM accounts WHERE acc_id = ?";
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, accountId);
			st.execute();
		LoggingUtil.getLogger().trace("Successful cancellation of account.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to cancel account.", e);
		}
		
	}

	@Override
	public void makeDeposit(int accountBal, int accountId) {
		String SQL = "UPDATE accounts SET acc_bal = ? WHERE acc_id = ?";
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setLong(1, accountBal);
			st.setInt(2, accountId);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful update of account balance.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update account balance.", e);
		}
	}

	@Override
	public void makeWithdrawal(int accountBal, int accountId) {
	String SQL = "UPDATE accounts SET acc_bal = ? WHERE acc_id = ?";
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setLong(1, accountBal);
			st.setInt(2, accountId);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful update of account balance.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update account balance.", e);
		}
	}

	@Override
	public void makeTransfer(int accountBal, int accountId) {
		String SQL = "UPDATE accounts SET acc_bal = ? WHERE acc_id = ?";
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setLong(1, accountBal);
			st.setInt(2, accountId);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful update of account balance.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update account balance.", e);
		}
	}
}
