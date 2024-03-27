package com.zsgs.LibraryManagement.model;

public class Admin {
	private String name;
	private int id;
	private static int count=1;
	private String emailId;
	private String phoneNo;
	private String address;
	
	public Admin(String name, String emailId, String phoneNo, String address) {
		id=count++;
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String email) {
		this.emailId=email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phone) {
		this.phoneNo=phone;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	}
