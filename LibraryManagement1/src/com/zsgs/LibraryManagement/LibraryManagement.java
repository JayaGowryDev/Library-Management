package com.zsgs.LibraryManagement;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.login.LoginView;

public class LibraryManagement {
	private static  LibraryManagement libraryManagement;

	private String appName = "Library Management System";
	
	private String appVersion = "0.0.1";
	
	private LibraryManagement() {
		
	}
	
	public static LibraryManagement getInstance() {
		if(libraryManagement == null) {
			libraryManagement = new LibraryManagement();
		}
		return libraryManagement;
	}
	
	private void create() {
		LoginView loginView = new LoginView();
		loginView.init();
	}
	public String getAppName() {
		return appName;
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	
	public static void main(String[] args) {
		LibraryDatabase.getInstance().deserialize();
		LibraryManagement.getInstance().create();
	}

	
}
