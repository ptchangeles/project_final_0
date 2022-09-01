package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public int createUser(User user) {
		String SQL = "INSERT into users(username, password, email)" +
				"VALUES (?, ?, ?)";
		int id = 0;
		try (Connection c = ConnectionFactory.getConnection();
		PreparedStatement st = c.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
				st.setString(1, user.getUsername());
				st.setString(2, user.getPassword());
				st.setString(3, user.getEmailAdd());
	
				int affectedRows = st.executeUpdate();
				if(affectedRows> 0) {
					try(ResultSet rs = st.getGeneratedKeys()){
						if (rs.next()) {
									id = rs.getInt(1);
						}  
					}catch (SQLException e) {
									System.out.println(e.getMessage());
						} 
					}
					} catch (SQLException e) {
									System.out.println(e.getMessage());
						}
						return id;
		}
	@Override
	public Set<User> getAllUsers() {
			Set<User> getAll = new TreeSet<User>();
			String SQL = "SELECT * from users";
			
			try {
				Connection c = ConnectionFactory.getConnection();
				PreparedStatement st = c.prepareStatement(SQL);
				ResultSet rs = st.executeQuery();
				
				User tempUser;
				String uName;
				String uPass;
				String uEmail;
				
				while (rs.next()) {
					uName = rs.getString("username");
					uPass = rs.getString("password");
					uEmail = rs.getString("email");
					
					tempUser = new User(uName, uPass, uEmail);
					getAll.add(tempUser);
				}
			} catch (SQLException e) {
				LoggingUtil.getLogger().warn("Unable to display database data", e);
			} LoggingUtil.getLogger().trace(getAll.size() + " currently listed data");
			
		return getAll;
	}

	@Override
	public User getUserById(int userId) {
		String SQL = "SELECT * from users WHERE user_id = ?";		
		
		User getById = null;
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();
			
			
			String uName;
			String uPass;
			String uEmail;
			
			if ((rs.next())){
					
					uName = rs.getString("username");
					uPass = rs.getString("password");
					uEmail = rs.getString("email");
					
					getById = new User(uName, uPass, uEmail);
			LoggingUtil.getLogger().trace("Successful attempt");
			} else {
			LoggingUtil.getLogger().warn("Unsuccessful attempt to retrieve data");	
			}
			}catch (SQLException e){
			LoggingUtil.getLogger().warn("Unable to retrieve data.",e);
		} return getById;
	}

	@Override
	public User readUser(String username) {
			User getByUs = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from users WHERE username = ?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			
			String uName;
			String uPass;
			String uEmail;
			
			if ((rs.next())){
					
					uName = rs.getString("username");
					uPass = rs.getString("password");
					uEmail = rs.getString("email");
					
					getByUs= new User(uName, uPass, uEmail);
			LoggingUtil.getLogger().info("Successful attempt");
			} else {
			LoggingUtil.getLogger().info("Unsuccessful attempt to revtrieve data");
			}
			}catch (SQLException e){
			LoggingUtil.getLogger().warn("Unable to access database", e);
		} return getByUs;
		
	}

	@Override
	public boolean existingUser(String username) {
		User existUser = this.readUser(username);
		if(existUser == null) {
			return false;
		} else {
		return true;
		}
	}

	@Override
	public int updateUser(int userId, String username, String password, String emailAdd) {
		String SQL = "UPDATE users SET username = ?, password = ?, email =?" 
							+ "WHERE user_id = ?";		
		int affectedRows = 0;
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, emailAdd);
			st.setInt(4, userId);
			
			affectedRows = st.executeUpdate();
		LoggingUtil.getLogger().trace("Successful update of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update user data.", e);
		}
		return affectedRows;
	}

	@Override
	public void deleteUserById(int userId) {
		String SQL = "DELETE FROM users where user_id = ?";
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement(SQL);
			st.setInt(1, userId);
			st.execute();
		LoggingUtil.getLogger().trace("Successful deletion of user data.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to delete user data.", e);
		}
		
	}

	@Override
	public void deleteUser(User user) {
		deleteUserById(user.getUserId());
		
	}

	@Override
	public User readPassword (String password) {
		User getByPass = null;
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from users WHERE password = ?");
			st.setString(1, password);
			ResultSet rs = st.executeQuery();
			
			String uName;
			String uPass;
			String uEmail;
			
			if ((rs.next())){
					
					uName = rs.getString("username");
					uPass = rs.getString("password");
					uEmail = rs.getString("email");
					
					getByPass = new User(uName, uPass, uEmail);
			LoggingUtil.getLogger().info("Successful attempt");
			} else {
			LoggingUtil.getLogger().info("Unsuccessful attempt to revtrieve data");
			}
			}catch (SQLException e){
			LoggingUtil.getLogger().warn("Unable to access database", e);
		} return getByPass;
	}

	@Override
	public boolean checkPassword(String password) {
		User rightPass = this.readPassword(password);
		if(rightPass == null) {
			return false;
		} else {
		return true;
		}
	  }
   }
  

