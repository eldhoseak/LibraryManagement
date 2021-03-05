package com.library.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.library.bean.User;
import com.library.util.ReadData;

public class LibraryService {

	public static List<String> bookNames = new ArrayList<String>();
	
	static {
		try {
		      File myObj = new File("D:\\Library\\books\\books.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	

	public void registerCustomer() {

		System.out.println();
		System.out.println("=====================================");
		System.out.println("\tLibrary Management");
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
		try {
			FileOutputStream fileOut =
					new FileOutputStream("D:\\Library\\User\\"+userId.substring(0,6)+".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("User details saved succesfully userid "+userId.substring(0,5));


	}


}
