package com.zsgs.LibraryManagement.managebook;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.model.Book;

import java.util.List;

class ManageBookModel {
	private ManageBookView manageBookView;
	
	ManageBookModel(ManageBookView manageBookView){
		this.manageBookView=manageBookView;
	}

	public void listOfBooks() {
		if(LibraryDatabase.getInstance().listBook().isEmpty()) {
			manageBookView.noBook();
		}
		else {
			manageBookView.bookDetails(LibraryDatabase.getInstance().listBook());
		}
	}

	public void addBook(String bookName, String publication, String edition, String author, int volume, int copies) {
		for(int i=1;i<=copies;i++ ){
			Book books =new Book(bookName,publication,edition,author,volume);
			LibraryDatabase.getInstance().insertBook(books);

		}
		LibraryDatabase.getInstance().serializeBookList(LibraryDatabase.getInstance().listBook());
		manageBookView.onBookAdded(bookName,copies);

	}
}
