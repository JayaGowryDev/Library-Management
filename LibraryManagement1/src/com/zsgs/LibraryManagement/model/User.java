package com.zsgs.LibraryManagement.model;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;

public class User {
	private int count = LibraryDatabase.getInstance().listUser().size()+1;
	private  int  id;
	private String name;
	private String userName;
	private int age;
	private String email;
	private long phoneNo;
	private String Location;
	
	
	
	
	public User(String name,String userName, int age, String email, long phoneNo, String location) {
		this.id=count++;
		this.name = name;
		this.userName=userName;
		this.age = age;
		this.email = email;
		this.phoneNo = phoneNo;
		Location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}
}
