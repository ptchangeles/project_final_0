package com.revature.models;

public class User implements Comparable<User> {

	protected int userId;
	protected String username;
	protected String password;
	protected String emailAdd;
	
	
	public User(String username, String password, String emailAdd) {
		super();
		this.username = username;
		this.password = password;
		this.emailAdd = emailAdd;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAdd() {
		return emailAdd;
	}
	
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAdd == null) ? 0 : emailAdd.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAdd == null) {
			if (other.emailAdd != null)
				return false;
		} else if (!emailAdd.equals(other.emailAdd))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", emailAdd=" + emailAdd
				+ "]";
	}

	@Override
	public int compareTo(User o) {
		return this.getUserId() - o.getUserId();
	}


			
}
