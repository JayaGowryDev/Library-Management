package com.zsgs.LibraryManagement.librarysetup;

import java.util.Scanner;

import com.zsgs.LibraryManagement.LibraryManagement;
import com.zsgs.LibraryManagement.login.LoginView;
import com.zsgs.LibraryManagement.manageBorrow.ManageBorrowView;
import com.zsgs.LibraryManagement.managebook.ManageBookView;
import com.zsgs.LibraryManagement.manageuser.ManageUserView;
import com.zsgs.LibraryManagement.model.Library;

public class LibrarySetupView {
	private LibrarySetupModel librarySetupModel;
	
	public LibrarySetupView() {
		librarySetupModel=new LibrarySetupModel(this);
	}
	public void init() {
		librarySetupModel.startSetup();
	}
	
	public void initiateSetup() {
		System.out.println("Enter library details:");
		Scanner scan = new Scanner(System.in);
		Library library = new Library();
		System.out.print("Enter library name:");
		library.setName(scan.nextLine());
		System.out.print("Enter library email:");
		library.setEmail(scan.nextLine());
		librarySetupModel.createLibrary(library);
	}
	public void onSetupComplete(Library library) {
		System.out.print("\n----------------Library setup completed------------------\n");
		System.out.print("\n------------Welcome to  " + library.getName() +"  Library---------------");
		mainMenu();

	}
	public void mainMenu(){
		Scanner scan=new Scanner(System.in);
		boolean val=true;
		while (val) {
			System.out.print(
					"\n 1. Manage Book\n 2. Manage User  \n 3. List of Book \n 4. Manage Borrow Book \n 5. Logout \n 0. Exit \n Enter your Choice :");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					new ManageBookView().initBook();
					break;
				case 2:
					new ManageUserView().initAdd();
					break;
				case 3:
					System.out.println("Total List of Book is Here");
					new ManageBookView().listOfBook();
					break;
				case 4:
					new ManageBorrowView().initBorrow();
				case 5:
					System.out.println("\n-- You are logged out successfully -- \n\n");
					new LoginView().init();
					return; // Exit from the current session
				case 0:
					System.out.println("\n-- Thanks for using " + LibraryManagement.getInstance().getAppName() + " --");
					return; // Exit from the application
				default:
					System.out.println("\nPlease Enter valid choice\n");
					break;
			}
		}

	}

	public void showAlert(String alert) {
		System.out.println(alert);
		initiateSetup();
	}
}
