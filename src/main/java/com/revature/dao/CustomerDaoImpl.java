package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public int registerCustomer(Customer customer) {
		String SQL = "INSERT into customers(user_id, first_name, last_name, address)" +
				"VALUES (?, ?, ?, ?)";
		int id = 0;
		try (Connection c = ConnectionFactory.getConnection();
		PreparedStatement st = c.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
				st.setInt(1, customer.getUserId());		
				st.setString(2, customer.getFname());			
				st.setString(3, customer.getLname());
				st.setString(4, customer.getAddress());
				st.execute();
				
				int affectedRows = st.executeUpdate();
				if(affectedRows> 0) {
					try(ResultSet rs = st.getGeneratedKeys()){
						if (rs.next()) {
								st.setInt(1, customer.getAccountId());
				  }			
				}catch (SQLException e) {
			LoggingUtil.getLogger().info("Single record(Customer registration) has been inserted.");
			} 
		}
	} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to create single record(Customer Registration.");
			}
				return id;
	} 
	@Override
	public Customer viewCustomerInfo(int userId) {
		String SQL = "SELECT * from customers WHERE user_id = ?";
	
			Customer getByCus = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();
			
			int c_userId;	
			 String c_fname;
			 String c_lname;
			 String c_address;
			
			if ((rs.next())){
				c_userId = rs.getInt("user_id");
				c_fname = rs.getString("first_name");
				c_lname = rs.getString("last_name");
				c_address = rs.getString("address");
					
				getByCus= new Customer(c_userId, c_fname, c_lname, c_address);
			LoggingUtil.getLogger().info("Single record(Customer registration) has been viewed.");
			} 
			}catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt to view single record(Customer Registration.");
	} 	return getByCus;
		
	}

	@Override
	public int updateCustomerInfo(int userId, String fname, String lname, String address) {
		String SQL = "UPDATE customers SET first_name = ?, last_name = ?, address = ?" +
							"WHERE user_id = ?";
		int affectedRows = 0;
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, fname);
			st.setString(2, lname);
			st.setString(3, address);
			st.setInt(4, userId);
			
			affectedRows = st.executeUpdate();
		LoggingUtil.getLogger().trace("Successful update of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update user data.", e);
		}
		return affectedRows;
	}

	@Override
	public void deleteCustomerInfo(int accountId) {
		String SQL = "DELETE FROM customers where acc_id = ?";
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, accountId);
			st.execute();
		LoggingUtil.getLogger().trace("Successful deletion of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to delete user data.", e);
		}
		
	}

}
