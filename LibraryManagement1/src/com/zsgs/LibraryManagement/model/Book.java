package com.zsgs.LibraryManagement.model;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;

public class Book {

	private int bookId;
	private  int count= LibraryDatabase.getInstance().listBook().size()+1;
	private String bookName;
	private String publication;
	private String edition;
	private String author;
	private long volume;
	private boolean availability;

	public Book(String bookName,String publication,String edition,String author,long volume)
	{
		this.bookId=count++;
		this.availability=true;
		this.bookName=bookName;
		this.edition=edition;
		this.volume=volume;
		this.publication=publication;
		this.author=author;
	}




	public int getBookId() {
		return bookId;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}
}
