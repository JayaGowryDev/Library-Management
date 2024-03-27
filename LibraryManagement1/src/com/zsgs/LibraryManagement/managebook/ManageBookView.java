package com.zsgs.LibraryManagement.managebook;

import java.util.List;
import java.util.Scanner;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.librarysetup.LibrarySetupView;
import com.zsgs.LibraryManagement.model.Book;

public class ManageBookView {
	private ManageBookModel manageBookModel;
	
	public ManageBookView(){
		manageBookModel=new ManageBookModel(this);
	}

	public void initBook(){
		System.out.print("----- Manage Books -----\n 1. Add Books \n 2. Update Books \n 3. Main menu \n Enter your choice" );
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();

			switch(choice){
				case 1:
					addBooks();
					break;
				case 2:
					updateBooks();
					break;
				case 3:
					new LibrarySetupView().mainMenu();
                    break;
		}
	}
	private void addBooks() {
		System.out.println("-----Enter Book Details-----");
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter Book name :");
		String bookName=scan.nextLine();
		System.out.print("Enter Publication name :");
		String publication=scan.nextLine();
		System.out.print("Enter edition name :");
		String edition=scan.nextLine();
		System.out.print("Enter author name :");
		String author=scan.nextLine();
		System.out.print("Enter volume name :");
		int volume=scan.nextInt();
		System.out.print("Enter No of copies :");
		int copies=scan.nextInt();
		scan.nextLine();
		manageBookModel.addBook(bookName,publication,edition,author,volume,copies);


    }
	public void onBookAdded(String bookName, int copies) {
		System.out.println("\n------- Book '" + bookName + " of "+ copies+ " copies"+ "' added successfully ------- \n");
		checkForAddNewBook();
	}

	public void onBookExist(Book book) {
		System.out.println("\n------- Book '" + book.getBookName() + "' already exist -------\n");
		checkForAddNewBook();
	}
	private void checkForAddNewBook() {
		System.out.println("\nDo you want to add more books? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			addBooks();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding books");
			initBook();
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewBook();
		}
	}
	private void updateBooks(){
		Scanner scan=new Scanner(System.in);

		System.out.print("Enter Book id  :");
		int bookId=scan.nextInt();
		List<Book> book= LibraryDatabase.getInstance().listBook();
		for(Book item : book){
			if(item.getBookId()==bookId){
				while(true){
					System.out.print("Update Book details \n1. Book namen\n2. Publication \n3. Author \n4.Edition \n5. Volume \n6. Exit \nEnter Yout choice :  ");
					int choice =scan.nextInt();
					switch (choice){
						case 1:
							scan.nextLine();
							System.out.print("Update Book Name    :");
							String bookName = scan.nextLine();
							item.setBookName(bookName);
							break;
						case 2:
							scan.nextLine();
							System.out.print("Update publication  :");
							String publication = scan.nextLine();
							item.setPublication(publication);
							break;
						case 3:
							scan.nextLine();
							System.out.print("Update author ");
							String author = scan.nextLine();
							item.setAuthor(author);
							break;
						case 4:
							scan.nextLine();
							System.out.print("Update Edition");
							String edition = scan.nextLine();
							item.setEdition(edition);
							break;
						case 5:
							scan.nextLine();
							System.out.print("Update Volume");
							int volume = scan.nextInt();
							item.setVolume(volume);
							break;
						case 6:
							scan.nextLine();
							initBook();
							break;

					}
				}
			}
		}


	}
	public void listOfBook() {
		manageBookModel.listOfBooks();
	}
	public void noBook() {
		System.out.println("Sorry, NoBook is added ");
		checkForAddNewBook();
	}
	public void bookDetails(List<Book> books) {
		System.out.println("--------------List of Books-----------------");
		System.out.println("----------------------------------------------------");
		for (Book item : books) {
			String available;
			if(item.isAvailability()){
				available="Available";
			}
			else {
				available="Not Available";
			}


			System.out.println("Book Id  :"+item.getBookId() +"\n"
					+"Book Name          : "+item.getBookName()+"\n"+
					"Author              :"+item.getAuthor()+"\n"+
					"Available        :"+item.isAvailability()+"\n------------------------------------------------------------------");

		}
		checkForAddNewBook();
        }

	}


