package com.zsgs.LibraryManagement.manageuser;

import java.util.List;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.model.User;

class ManageUserModel {
	private ManageUserView manageUserView;
	
	ManageUserModel(ManageUserView manageUserView){
		this.manageUserView=manageUserView;
	}	
	
	public void addUser(String name,String userName,String email,int age,long phoneNo, String location) {
		List<User> val=LibraryDatabase.getInstance().listUser();
		boolean sameUsername=false;
		for( User item:val){
			if(item.getUserName().equals(userName)) {
				manageUserView.showAlert(userName + " username is already exist");
				sameUsername=true;
			}
		}
		if(sameUsername==false){
			System.out.println("enter the deailsss");
			User user =new User(name, userName,age, email, phoneNo, location);
			LibraryDatabase.getInstance().addUser(user);
			LibraryDatabase.getInstance().serializeUserList(LibraryDatabase.getInstance().listUser());
			manageUserView.showAlert(" User Added Successfully ");
		}


		}
	
	
}
