package com.library.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.library.bean.User;
import com.library.exception.InvalidUserException;

public class FileUtil {

	public static void writeUserFile(String fileName, User user){

		try {
			FileOutputStream fileOut =
					new FileOutputStream("resources\\user\\"+fileName+".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}


	public static User readUserFile(String fileName) throws InvalidUserException{
		User user = null;
		try {
			FileInputStream fileIn =
					new FileInputStream("resources\\user\\"+fileName+".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			user = (User)in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception i) {
			throw new InvalidUserException("Invalid UserId");
		}
		return user;
	}

}
