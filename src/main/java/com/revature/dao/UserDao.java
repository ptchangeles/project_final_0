package com.revature.dao;

import java.util.Set;

import com.revature.models.User;

public interface UserDao {

	//Add user
	int createUser(User user);
	
	//Display all users
	Set<User> getAllUsers();
	
	//Search user
	User getUserById(int userId);
	
	//Display user
	User readUser(String username);
	
	//If user exist
	boolean existingUser(String username);
	
	//If correct password
	User readPassword(String password);
	boolean checkPassword(String password);
	
	//Update, Edit user
	int updateUser(int userId, String username, String password, String emailAdd);
	
	//Delete user
	void deleteUserById(int userId);
	void deleteUser(User user);
	
}
