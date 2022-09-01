package com.revature.services;

import java.util.Set;

import com.revature.dao.UserDaoImpl;
import com.revature.models.User;
import com.revature.util.LoggingUtil;

public class LoginService {

	private UserDaoImpl uDao;

	public LoginService() {
		super();
		uDao = new UserDaoImpl();
	}
	
	public LoginService(UserDaoImpl u) {
		super();
		uDao = u;
	}
	
	public void createUser(User user) {
		if (uDao.existingUser(null)) {
			LoggingUtil.getLogger().info("Duplicate record. User already exist in the database.");
		} else {
		uDao.createUser(user);
		}
	}
	
	public Set<User> getAllUsers(){
		return uDao.getAllUsers();
	}

	public User getUser(int u) {
		return uDao.getUserById(u);
	}
	
	public User readUser(String u) {
		return uDao.readUser(u);
	}
	
	public boolean existingUser(String u) {
		return uDao.existingUser(u);
	}
	
	public void deleteUser(User user) {
		uDao.deleteUser(user);
	}
	public boolean checkPassword(String password) {
		return uDao.checkPassword(password);
		
	}
}
