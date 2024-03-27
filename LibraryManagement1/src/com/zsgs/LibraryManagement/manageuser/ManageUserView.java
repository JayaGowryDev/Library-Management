package com.zsgs.LibraryManagement.manageuser;

import java.util.List;
import java.util.Scanner;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.librarysetup.LibrarySetupView;
import com.zsgs.LibraryManagement.model.Book;
import com.zsgs.LibraryManagement.model.User;

public class ManageUserView {
	private ManageUserModel manageUserModel;
	public ManageUserView() {
		manageUserModel =new ManageUserModel(this);
	}
	Scanner scan=new Scanner(System.in);
	public void initAdd() {
		System.out.println("\n 1. Add User \n 2. List of User  \n3. Update User \n 4. MainMenu");
		System.out.print("Your choice ");
		
		int input=scan.nextInt();

			switch(input) {
				case 1:
					addUser();
					break;
				case 2:
					userList();
					break;
				case 3:
					updateUser();
					break;
				case 4:
					new LibrarySetupView().mainMenu();
					break;
			}
	}
	private void addUser() {
		scan.nextLine();
		System.out.println("Enter Details :");
		System.out.print("Enter name ");
		String name = scan.nextLine();
		System.out.print("Enter Username ");
		String userName = scan.nextLine();
		System.out.print("Enter Email ");
		String email=scan.nextLine();
		System.out.print("Enter age ");
		int age=scan.nextInt();
		System.out.print("Enter Phone Number ");
		long phoneNo=scan.nextLong();
		scan.nextLine();
		System.out.print("Enter Location ");
		String location=scan.nextLine();
		manageUserModel.addUser(name,userName,email,age,phoneNo,location);
		initAdd();
	}
	private void userList() {

		List<User> users=LibraryDatabase.getInstance().listUser();

		System.out.println("------------List Of User------------");
		for(User item :users) {

			System.out.println("User Name  :"+item.getUserName() +"\n"
					+"Name          : "+item.getName()+"\n"+
					"Email Id      :"+item.getEmail()+"\n"+
					"Location      :"+item.getLocation()+"\n"+
					"Phone No      :"+item.getPhoneNo()+"\n"+
					"Age           :"+item.getAge()+"\n-------------------------------------------------------------------");
		}

	}
	public void showAlert(String s) {
		System.out.println(s);
	}
//	//private void removeUser(){
//		System.out.println("Remove User in development process");
//	}
	private void updateUser() {

		System.out.println("Update user In development process");
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter username  :");
		String userName = scan.nextLine();
		List<User> user = LibraryDatabase.getInstance().listUser();
		for (User item : user) {
			if (item.getUserName().equals(userName)) {
				while (true) {
					System.out.print("Update Book details \n1. Name \n2. Age \n3. Email \n4. Phone Number \n5. Location \n6. Exit \nEnter Yout choice :  ");
					int choice = scan.nextInt();
					switch (choice) {
						case 1:
							scan.nextLine();
							System.out.print("Update Name                :");
							String name = scan.nextLine();
							item.setName(name);
							break;
						case 2:
							scan.nextLine();
							System.out.print("Update Age                 :");
							int age = scan.nextInt();
							item.setAge(age);
							break;
						case 3:
							scan.nextLine();
							System.out.print("Update Email                :");
							String email = scan.nextLine();
							item.setEmail(email);
							break;
						case 4:
							scan.nextLine();
							System.out.print("Update Phone                :");
							long phone = scan.nextLong();
							item.setPhoneNo(phone);
							break;
						case 5:
							scan.nextLine();
							System.out.print("Update Location             :");
							String location = scan.nextLine();
							item.setLocation(location);
							break;
						case 6:
							scan.nextLine();
							initAdd();
							break;

					}
				}
			}

		}
	}
}
