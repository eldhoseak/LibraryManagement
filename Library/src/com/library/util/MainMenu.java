/**
 * 
 */
package com.library.util;
import com.library.service.LibraryService;

public class MainMenu {

	/**
	 * @param args
	 */
	
	
	
	
	
	public void display(){

		boolean flag=false;
		do{
		// Displaying the Menu
		System.out.println();
		System.out.println("=====================================");
		System.out.println("\t Library Management System");
		System.out.println("=====================================");
		System.out.println("\t1. User Registration");
		System.out.println("\t1. Issue Book");
		System.out.println("\t2. Return Book");
		System.out.println("\t3. Exit");

		System.out.println();
		System.out.print("Enter Your choice:");
		String input=ReadData.acceptString();
		int choice=0;
		// Checking whether the choice is a number or not
		try{

			choice  =Integer.parseInt(input);

			}
		catch(NumberFormatException e)
		{
			System.out.print("Strings, spaces or Special");
			System.out.println(" Characters cannot be given");
		}

		if(choice==6)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}


		switch(choice){
			// calling particular method in the classes based on choice given
			case 1: System.out.println();
					LibraryService service=new LibraryService();
					service.registerCustomer();
					break;

			case 7: System.exit(0);
			default: System.out.print("Invalid Choice!");
					 System.out.println("Enter the choice between <1-7>");
					 System.out.println();
					 break;
			}

		}while(!flag);

	}
	/**
	* Instantiate the different classes based on the choice selected
	* @param args The command line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu menu = new MainMenu();
		menu.display();
	}
}
