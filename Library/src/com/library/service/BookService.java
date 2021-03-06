package com.library.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.bean.User;
import com.library.exception.BookNotIssuedException;
import com.library.exception.InvalidBookException;
import com.library.exception.InvalidUserException;
import com.library.util.FileUtil;
import com.library.util.ReadData;

public class BookService {

	private final static String BOOK_LOCATION="resources\\books.txt";

	public static List<String> bookNames = new ArrayList<String>();

	static {
		populateBooks();
	}

	static void populateBooks(){
		try {
			File myObj = new File(BOOK_LOCATION);
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

	public void issueBook() throws InvalidUserException, InvalidBookException {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t Issue Book");

		System.out.println();
		System.out.print("User Id \t\t\t\t:");
		String userId= ReadData.acceptString();
		User user = FileUtil.readUserFile(userId);

		System.out.print("Book Name \t\t\t\t:");
		String bookName=ReadData.acceptString();
		if(!bookNames.contains(bookName)) {
			throw new InvalidBookException("ERROR -- Invalid Book Name!!");
		}
		
		user.setBookName(bookName);

		FileUtil.writeUserFile(user.getUserId(), user);
		System.out.println("SUCCESS -- Book Issued successfully !!");
	}

	public void returnBook() throws InvalidUserException, BookNotIssuedException, InvalidBookException {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t Return Book");

		System.out.println();
		System.out.print("User Id \t\t\t\t:");
		String userId= ReadData.acceptString();

		User user = FileUtil.readUserFile(userId);

		System.out.print("Book Name \t\t\t\t:");
		String bookName=ReadData.acceptString();
		if(!bookNames.contains(bookName)) {
			throw new InvalidBookException("ERROR -- Invalid Book Name!!");
		}
		
		if(!bookName.equalsIgnoreCase(user.getBookName())){
			throw new BookNotIssuedException("ERROR -- Book not issued to user!!");
		}

		user.setBookName("");

		FileUtil.writeUserFile(user.getUserId(), user);
		System.out.println("SUCCESS -- Book Returned successfully !!");
	}
}
