package com.zsgs.LibraryManagement.manageBorrow;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.librarysetup.LibrarySetupView;
import com.zsgs.LibraryManagement.managebook.ManageBookView;
import com.zsgs.LibraryManagement.model.Book;
import com.zsgs.LibraryManagement.model.Borrow;
import com.zsgs.LibraryManagement.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

class ManageBorrowModel {
    private ManageBorrowView manageBorrowView;
    public ManageBorrowModel(ManageBorrowView manageBorrowView){
        this.manageBorrowView=manageBorrowView;
    }

    public void borrowbook(String userName, int bookId){
        List<User> user= LibraryDatabase.getInstance().listUser();
        List<Book> book=LibraryDatabase.getInstance().listBook();
        boolean haveUser=false;
        boolean haveBook=false;
        for( User item:user){
            if(item.getUserName().equals(userName)) {
                haveUser=true;
            }
        }
        if(haveUser==false){
            manageBorrowView.showAlert("Username not Exist");
            new LibrarySetupView().mainMenu();
        }
        for(Book item:book) {
            if (item.getBookId() == bookId) {
                haveBook=true;
                if (item.isAvailability()) {
                    Borrow borrow = new Borrow(bookId, new Date(), userName);
                    item.setAvailability(false);
                    LibraryDatabase.getInstance().addBorrow(borrow);
                    manageBorrowView.showAlert("Borrowed Successfully");
                    LibraryDatabase.getInstance().serializeBorrowList(LibraryDatabase.getInstance().listBorrow());
                    new LibrarySetupView().mainMenu();

                } else {
                    manageBorrowView.showAlert("Book is not available");
                    new LibrarySetupView().mainMenu();
                }
            }
        }      if(!haveBook){
            manageBorrowView.showAlert("Book is not exist");
            new LibrarySetupView().mainMenu();
        }




    }
   public void returnBook(String userName, int bookId){
        List<Borrow> borrow= LibraryDatabase.getInstance().listBorrow();
        boolean hasbook=false;
        for(Borrow item : borrow){
            if(item.getUsername().equals(userName) && item.getBookId()==bookId){
                hasbook=true;
                item.setReturnDate(new Date());
                manageBorrowView.showAlert("Return successfully");
                LibraryDatabase.getInstance().serializeBorrowList(LibraryDatabase.getInstance().listBorrow());
                return;


            }

        }
        if(!hasbook){
            manageBorrowView.showAlert("Invalid UserName or BookId");
        }
       new LibrarySetupView().mainMenu();

    }


    public void listBorrow() {
        if(LibraryDatabase.getInstance().listBorrow().isEmpty()){
            manageBorrowView.showAlert("Borrow History is empty");
        }
        manageBorrowView.borrowHistory(LibraryDatabase.getInstance().listBorrow());


    }
}
