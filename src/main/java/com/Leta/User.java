package com.Leta;

public class User {

	String userName;
	String userPassword;
	
	public User() {}
	
	public User(String userName, String password) {
		
		this.userName = userName;
		this.userPassword = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String password) {
		this.userPassword = password;
	}

	

	
	
}
