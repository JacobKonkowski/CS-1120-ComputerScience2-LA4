package edu.wmich.cs1120.LA4.JakeKonkowski;

import java.util.Scanner;

public class StoreClass {
	
	static User sUser;
	
	public static void main(String[] args) {
		Lookup lookup = new Lookup();
		sUser = promptForCredentials(lookup);
		
		mainMenu(lookup);
		
	}

	private static void mainMenu(Lookup lookup) {
		int mainOption = -1;
		
		while (mainOption != 0) {
			
			System.out.println("Store List Menu:");
			System.out.println("1- Book Store");
			System.out.println("2- Music Store");
			System.out.println("3- Movie Store");
			System.out.println("4- My Library");
			System.out.println("0- Quit");
			System.out.println("Select one of these options: ");
			
			mainOption = promptForInt();
			
			if (mainOption == 1) {
				bookMenu(lookup);
			}
			if (mainOption == 2) {
				multiMediaMenu(2, lookup);
			}
			if (mainOption == 3) {
				multiMediaMenu(3, lookup);
			}
			if (mainOption == 4) {
				for (int i = 0; i < sUser.getLibrary().length; i++) {
					if (sUser.getLibrary()[i] != null) {
						System.out.println(sUser.getLibrary()[i]);
					}
				}
			}
		}
	}
	
	private static void bookMenu(Lookup lookup) {
		
		lookup.printBookList();
		 
		 System.out.println("***************************************");
		 System.out.println("1- Download Book");
		 System.out.println("0- Return to Store list menu");
		 
		 int option = -1;
		 
		 while (option != 0) {
			
			option = promptForInt();
			
			if (option == 1) {
				downloadBook(lookup);
			}	
			
		}
		
		mainMenu(lookup);
	}
	
	private static void downloadBook(Lookup lookup) {
		while (true) {
			
			System.out.println("Enter Book Key");
			int key = promptForInt();
			Item item = lookup.getItemById(key);
			
			
			if (item != null) {
				if (sUser.hasItem(item)) {
					System.out.println("Download Successfully Completed");
					break;
				} else if (item.isFree) {
					sUser.addItemToTheLibrary(item);
					System.out.println("Download Successfully Completed");
					break;
				} else {
					purchaseItem(item, lookup);
					break;
				}
			}
			System.out.println("This key is not existing");
		}
		
		bookMenu(lookup);
	}
	
	private static void multiMediaMenu(int storeType, Lookup lookup) {
		String name = "Music";
		 if (storeType == 3) {
			lookup.printMovieList();
			name = "Movie";
		 } else {
			 lookup.printMusicList();
		 }
		 
		 System.out.println("***************************************");
		 System.out.println("1- Play or Purchase " + name);
		 System.out.println("0- Return to Store list menu");
		 
		 int option = -1;
		 
		 while (option != 0) {
			
			option = promptForInt();
			
			if (option == 1) {
				playMultimedia(lookup, name, storeType);
			}	
			
		}
		
		mainMenu(lookup);
	}

	private static void playMultimedia(Lookup lookup, String name, int storeType) {
		while (true) {
		
			System.out.println("Enter " + name + " Key");
			int key = promptForInt();
			Multimedia mm = (Multimedia) lookup.getItemById(key);
			
			
			if (mm != null) {
				if (mm.Play()) {
					System.out.println("Playing!");
					break;
				} else if (mm.isFree) {
					sUser.addItemToTheLibrary(mm);
					mm.isPlay = true;
					System.out.println("Playing!");
					break;
				} else {
					purchaseItem(mm, lookup);
					break;
				}
			}
			System.out.println("This key is not existing");
		}
		
		multiMediaMenu(storeType, lookup);
	}

	private static void purchaseItem(Item item, Lookup lookup) {
		double enteredPrice = -1.0;
		
		while (enteredPrice != item.getPrice() && enteredPrice != 0) {
			System.out.println("This item is not free, "
					+ "the total cost after taxes = " + item.getPrice());
			System.out.println("Enter the price to continue or 0 to exit");
			
			enteredPrice = promptForDouble();
		}
		
		if (enteredPrice == item.getPrice()) {
			sUser.addItemToTheLibrary(item);
			System.out.println("Playing!");
		}
	}
	
	public static int promptForInt() {
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNextInt()) {
			int input = sc.nextInt();
			if (input >= 0) {
				return input;
			} else {
				System.out.println("Invalid input. Please enter a valid input.");
				return -1;
			}
		}
		
		return -1;
	}
	
	public static double promptForDouble() {
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNextDouble()) {
			double input = sc.nextDouble();
			if (input >= 0.0) {
				return input;
			} else {
				System.out.println("Invalid input. Please enter a valid input.");
				return -1;
			}
		}
		
		return -1;
	}
	
	public static User promptForCredentials(Lookup lookup) {
		User user = null;
		Scanner sc = new Scanner(System.in);
		
		while (user == null) {
			String username = "", password = "";
			System.out.println("Enter your UserName:");
			if (sc.hasNext()) {
				username = sc.next();
			}
			
			System.out.println("Enter your Password:");
			if (sc.hasNext()) {
				password = sc.next();
			}
			
			user = lookup.checkLoginAuth(username, password);
			
			if (user != null) {
				System.out.println("Login Successful!");
				break;
			}
			
			System.out.println("Incorrect username or password");
			
		}
		
		return user;

	}

}
