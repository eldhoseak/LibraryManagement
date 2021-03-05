package com.library.test;
import com.library.service.LibraryService;
import com.library.util.ReadData;

public class MainMenu {

	private LibraryService service=new LibraryService();

	public void display(){

		boolean flag=false;
		do{
			// Displaying the Menu
			System.out.println();
			System.out.println("=====================================");
			System.out.println("\t Library Management System");
			System.out.println("=====================================");
			System.out.println("\t1. User Registration");
			System.out.println("\t2. Issue Book");
			System.out.println("\t3. Return Book");
			System.out.println("\t4. Exit");

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

			try{

				switch(choice){
				// Call method to register user
				case 1: System.out.println();
				service.registerUser();
				break;
				
				// Call method to issue book
				case 2: System.out.println();
				service.issueBook();
				break;

				// Call method to return book
				case 3: System.out.println();
				service.returnBook();
				break;

				case 4: System.exit(0);
				default: System.out.print("Invalid Choice!");
				System.out.println("Enter the choice between <1-4>");
				System.out.println();
				break;
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}

		}while(!flag);

	}

	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.display();
	}
}
