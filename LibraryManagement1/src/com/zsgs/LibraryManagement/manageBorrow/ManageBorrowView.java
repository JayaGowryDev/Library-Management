package com.zsgs.LibraryManagement.manageBorrow;

import com.zsgs.LibraryManagement.librarysetup.LibrarySetupView;
import com.zsgs.LibraryManagement.managebook.ManageBookView;
import com.zsgs.LibraryManagement.model.Borrow;

import java.util.List;
import java.util.Scanner;

public class ManageBorrowView {
    private ManageBorrowModel manageBorrowModel;
    public ManageBorrowView(){
        manageBorrowModel =new ManageBorrowModel(this);
    }
    Scanner scan=new Scanner(System.in);
    public void initBorrow(){
        System.out.print("Borrow Menu : \n 1. Borrow Book \n2. Return Book \n 3. Borrow History \n 4. Main menu \n Enter your choice : ");

        int choice=scan.nextInt();
        switch(choice){
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                manageBorrowModel.listBorrow();
                break;
            case 4:
                new LibrarySetupView().mainMenu();
                break;
        }

    }
    private void borrowBook(){
        scan.nextLine();
        System.out.println("Enter Username");
        String username= scan.nextLine();
        System.out.println("Enter Book Id");
        int bookId=scan.nextInt();
        manageBorrowModel.borrowbook(username,bookId);
        initBorrow();
    }
    private void returnBook(){
        scan.nextLine();
        System.out.print("Enter Username");
        String username=scan.nextLine();
        System.out.print("Enter the book id");
        int bookId=scan.nextInt();
        manageBorrowModel.returnBook(username,bookId);
        initBorrow();
    }

    public void borrowHistory(List<Borrow> borrow){
        System.out.print("Borrow details are");
        System.out.println("----------------------------------------------------");
        for(Borrow item :borrow){

            System.out.println("Borrow Id  :"+item.getId() +"\n"
                    +"User Name          : "+item.getUsername()+"\n"+
                    "Borrow Date         :"+item.getBorrowDate()+"\n"+
                    "Return Date         :"+item.getReturnDate()+"\n------------------------------------------------------------------");

        }
        initBorrow();
    }

    public void showAlert(String msg){
        System.out.println(msg);
    }

}
