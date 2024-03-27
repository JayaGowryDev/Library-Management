package com.zsgs.LibraryManagement.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.zsgs.LibraryManagement.model.Book;
import com.zsgs.LibraryManagement.model.Borrow;
import com.zsgs.LibraryManagement.model.Library;
import com.zsgs.LibraryManagement.model.User;
import com.zsgs.LibraryManagement.serialize.ConvertJson;
//import com.google.gson.Gson;

public class LibraryDatabase {
	private static LibraryDatabase libraryDatabase;
	
	private Library library;
	private List<Book> bookList = new ArrayList();
	private List<User> userList=new ArrayList();
	private List<Borrow> borrowList =new ArrayList();

	public static LibraryDatabase getInstance() {
		if(libraryDatabase==null) {
			libraryDatabase=new LibraryDatabase();
		}
		return libraryDatabase;
	}
	public Library getLibrary() {
		return library;
	}
	
	public Library insertLibrary(Library val) {
		this.library=val;
		this.library.setId(1);
		return library;
	}
	public void insertBook(Book book) {
		bookList.add(book);
	}
	public List<Book> listBook() {
		return bookList;
	}
	
	// user 
	public void addUser(User user) {
		userList.add(user);
	}
	public List<User> listUser(){
		return userList;
	}

	// borrow
	public void addBorrow(Borrow borrow){borrowList.add(borrow);}
	public List<Borrow> listBorrow(){
		return borrowList;
	}



	//serialization
	public void serializeBookList(List<Book> bookList1){
		ConvertJson.getConvertJson().serialize(bookList1,"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\bookList.json");
	}
	public void serializeLibrary(Library library1){
		ConvertJson.getConvertJson().serialize(library1,"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\library.json");
	}
	public void serializeUserList(List<User> userList1){
		ConvertJson.getConvertJson().serialize(userList1,"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\userList.json");
	}
	public void serializeBorrowList(List<Borrow> borrowList1){
		ConvertJson.getConvertJson().serialize(borrowList1,"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\borrowList.json");
	}




	//deserialization
	private void deserializeBookList(){
		List<Book> bookList=ConvertJson.getConvertJson().deserialize(new TypeToken<List<Book>>(){},"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\bookList.json");
		if(bookList!=null)
		{
			this.bookList=bookList;
		}
	}
	private void deserializeUserList(){
		List<User> userList=ConvertJson.getConvertJson().deserialize(new TypeToken<List<User>>(){},"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\userList.json");
		if(userList!=null){
			this.userList=userList;
		}
	}
	private void deserializeBorrowList(){
		List<Borrow> borrowList=ConvertJson.getConvertJson().deserialize(new TypeToken<List<Borrow>>(){},"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\borrowList.json");
		if(borrowList!=null){
			this.borrowList=borrowList;
		}
	}
	private void deserializeLibrary(){
		this.library=ConvertJson.getConvertJson().deserialize(Library.class,"E:\\LibraryManagement1\\src\\com\\zsgs\\LibraryManagement\\data\\Library.json");
	}
	public void deserialize(){
		deserializeBookList();
		deserializeLibrary();
		deserializeUserList();
		deserializeBorrowList();
	}


}
