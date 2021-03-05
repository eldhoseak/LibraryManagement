package com.library.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.library.bean.User;
import com.library.exception.BookNotIssuedException;
import com.library.exception.InvalidUserException;
import com.library.util.FileUtil;
import com.library.util.ReadData;

public class LibraryService {

	public static List<String> bookNames = new ArrayList<String>();

	static {
		populateBooks();
	}

	static void populateBooks(){
		try {
			File myObj = new File("I:\\Library\\LibraryManagement\\Library\\resources\\books.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				bookNames.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void registerUser() {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t User Registration");
		User user=new User();

		System.out.println();
		// Entering customer details
		System.out.print("User Name \t\t\t\t:");
		String name= ReadData.acceptString();
		user.setName(name);

		System.out.print("User Address \t\t\t\t:");
		String address=ReadData.acceptString();
		user.setAddress(address);

		Random r = new Random();
		String userId = user.getName().substring(0,3)+r.nextInt();
		user.setUserId(userId.substring(0,6));
		FileUtil.writeUserFile(userId.substring(0,6), user);
		System.out.println("User details saved succesfully userid "+userId.substring(0,6));
	}


	public void issueBook() throws InvalidUserException {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t Issue Book");

		System.out.println();
		System.out.print("User Id \t\t\t\t:");
		String userId= ReadData.acceptString();
		User user = FileUtil.readUserFile(userId);

		System.out.print("Book Name \t\t\t\t:");
		String bookName=ReadData.acceptString();
		user.setBookName(bookName);

		FileUtil.writeUserFile(user.getUserId(), user);
		System.out.println("Book Issued successfully !!");
	}

	public void returnBook() throws InvalidUserException, BookNotIssuedException {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t Return Book");

		System.out.println();
		System.out.print("User Id \t\t\t\t:");
		String userId= ReadData.acceptString();

		User user = FileUtil.readUserFile(userId);

		System.out.print("Book Name \t\t\t\t:");
		String bookName=ReadData.acceptString();

		if(!bookName.equalsIgnoreCase(user.getBookName())){
			throw new BookNotIssuedException("Book not issued to user.");
		}

		user.setBookName("");

		FileUtil.writeUserFile(user.getUserId(), user);
		System.out.println("Book Returned successfully !!");
	}
	
}
