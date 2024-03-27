package com.zsgs.LibraryManagement.model;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;

import java.util.Date;

public class Borrow {
	private int id;
	private int count= LibraryDatabase.getInstance().listBorrow().size()+1;
	private int bookId;
	private Date borrowDate;
	private Date returnDate;
	private String username;

	public Borrow(int bookId, Date borrowDate, String username) {
		this.id = count++;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.username = username;
	}

	public  int getId() {
		return id;
	}


	public int getBookId() {
		return bookId;
	}



	public Date getBorrowDate() {
		return borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public String getUsername() {
		return username;
	}

}
