package com.nish.security.model;

public class JwtUser {

	private String userName;
	private long id;
	private String role;

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role = role;
	}

}
