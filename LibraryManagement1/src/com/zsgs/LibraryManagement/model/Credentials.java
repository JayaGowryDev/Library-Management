package com.zsgs.LibraryManagement.model;

public class Credentials {
	private int CredentialsId;
	private static int count=1;
	private String userName;
	private String password;
	public Credentials(String userName, String password) {
		
		CredentialsId = count++;
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredentialsId() {
		return CredentialsId;
	}
	
	
	
	
	
	
}
