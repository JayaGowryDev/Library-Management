package com.zsgs.LibraryManagement.login;
import java.util.Scanner;

import com.zsgs.LibraryManagement.LibraryManagement;
import com.zsgs.LibraryManagement.librarysetup.LibrarySetupView;
public class LoginView {

	private LoginModel loginModel;

	public LoginView() {
		loginModel=new LoginModel(this);
	}
	public void init() {
		System.out.println("---" +LibraryManagement.getInstance().getAppName()+"--- version"+ LibraryManagement.getInstance().getAppVersion());
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please login to proceed.");
		System.out.print("Enter default user name:");
		String userName = scanner.nextLine();
		System.out.print("Enter default password:");
		String password = scanner.nextLine();
		loginModel.validateUser(userName, password);
	}
	public void onSuccess() {
		System.out.flush();
		System.out.println("-----Login successful----");
		LibrarySetupView librarySetupView = new LibrarySetupView();
		librarySetupView.init();
		
	}
	public void showAlert(String alertText) {
		System.out.println(alertText);
	}
	public void signUp(){
		System.out.println("Do you want to \n 1. signup \n 2.login");
	}
}
