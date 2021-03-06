package com.library.service;

import java.util.Random;

import com.library.bean.User;
import com.library.util.FileUtil;
import com.library.util.ReadData;

public class UserService {

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
		System.out.println("SUCCESS -- User details saved succesfully userid "+userId.substring(0,6));
	}
}
