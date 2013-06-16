// package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Program {
	static String books[] = new String[4];
	
	static final int NUMBER_OF_MOVIES = 15;
	static Movie[] movies = new Movie[NUMBER_OF_MOVIES]; 
	
	static boolean loggedIn = false; 
	static int username = 0;
	static HashMap<Integer, String> usersAndPasswords = new HashMap<Integer, String>();

	public static void main(String[] args) {
		initBooks();
		initUsers();
		initMovies();
		
		while (true) {
			printMenu();
			doMenu();
		}
	}

	private static void printMenu() {
		System.out.println("\nBangalore Public Library System - Biblioteca");
		System.out.println("1. List book catalog");
		System.out.println("2. List movie catalog");
		System.out.println("3. Check out book");
		System.out.println("4. Check out movie");
		System.out.println("5. Check library number");
		System.out.println("6. Login");
	}

	private static void printMovies() {
		for (int i = 0; i < 14; i++){	
			System.out.println((i + 1) + ". " + movies[i]);  		
			if (!movies[i].hasRating())
				System.out.println("      A rating of 0 means this movie is not yet rated."); 
		}  
		
	}

	private static void printBooks() {
		for (int i = 0; i < books.length; i++){
			System.out.println(books[i]);
		}
	}

	private static void doMenu() {
		int input = readIntInput("Your selection: ");
		if (input == 1) 
			printBooks();
		else if (input == 2)
			printMovies();
		else if (input == 3)
			checkOutBook();
		else if (input == 4)
			checkOutMovie();
		else if (input == 5) 
			checkLibraryNumber();
		else if (input == 6) 
			doLogin();	
		else 
			menuError();
	}

	private static void doLogin() {
		int usernameEntered = readIntInput("Please enter your username."); 
		String passwordEntered = readStringInput("Please enter your password.");
		
		if(usersAndPasswords.containsKey(usernameEntered) && 
			usersAndPasswords.get(usernameEntered).equals(passwordEntered)){
				loggedIn = true; 
				username = usernameEntered; 
				System.out.println("You are logged in!");
			}
		
		if (!loggedIn)
			System.out.println("Not a valid username/password combination. Please try again.");
	}

	private static void initBooks() {
		books[0] = " 1. Sweet Valley High vol. 4 by John Travolta";
		books[1] = " 2. eXtreme Programming Explained by Kent Beck";
		books[2] = " 3. How to Win Friends and Influence People by Dale Carnagie";
		books[3] = " 4. How to Cheat at TWU Assignements by Anonymous";
	}

	private static void initUsers() {
		//stored users and passwords
		usersAndPasswords.put(1111111, "admin");
		usersAndPasswords.put(1111112, "ilikemaria");
		usersAndPasswords.put(1111113, "jimannoysme");
	}

	private static void initMovies() {
		movies[0] = new Movie("Avatar", "Dude", 2);
		movies[1] = new Movie("Pocahantas", "Igni", 10);
		movies[2] = new Movie("Goulash", "David Peters", 5);
		movies[3] = new Movie("Ronald Iden", "Gertie Davies", 2);
		movies[4] = new Movie("Jigg Is Up", "Span Irvig", 8); 
		movies[5] = new Movie("Winter Went Away", "Mikey Moorgabe", 3);
		movies[6] = new Movie("Day O", "Summer Liugh", 10);
		movies[7] = new Movie("Peace in England", "Awa Yee", 10);
		movies[8] = new Movie("Zombie Snowflake", "James Dean", 1);
		movies[9] = new Movie("Sailor Early", "Upsi Reese");
		movies[10] = new Movie("Hey You", "Mow Green", 0);
		movies[11] = new Movie("Sailor Early", "Upsi Reese", 11);
		movies[12] = new Movie("Everyone's Superhero II", "Chang Lee", 7);
		movies[13] = new Movie("Rice Tastes", "Josh Brown", 8);
		movies[14] = new Movie("Twenty Tons of Gold", "Robber Baron", 8);
	}

	private static void checkLibraryNumber() {
		if (loggedIn)
			System.out.println(username);
		else 
			System.out.println("Please talk to the Librarian. Thank you.");
	}

	private static void checkOutBook() {
		int bookToCheckOut = readIntInput(" Please enter the number of the book you wish to checkout: ");
		if (bookToCheckOut <= books.length && bookToCheckOut > 0)
			System.out.println(" Thank You! Enjoy the book.");
		else 
			System.out.println(" Sorry, we don't have that book yet.");
	}
	private static void checkOutMovie() {
		int movieToCheckOut = readIntInput(" Please enter the number of the movie you wish to checkout: ");
		if (movieToCheckOut <= NUMBER_OF_MOVIES && movieToCheckOut > 0)
			System.out.println(" Thank You! Enjoy the movie.");
		else 
			System.out.println(" Sorry, we don't have that movie yet.");
	}

	private static void menuError() {
		System.out.println("That is not a menu choice. Please enter an integer between 1 and 7.");
	}

	private static int readIntInput(String prompt) {
		System.out.println(prompt);
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStream);
		int input = 0;
		try {
			input = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Error. Please enter a valid integer.");
		}
		return input;
		
	}
	private static String readStringInput(String prompt) {
		System.out.println(prompt);
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStream);
		String input = "";
		try {
			input = reader.readLine(); 
		} catch (Exception e) {
			System.out.println("Error. Please enter a valid integer.");
		}
		return input;
		
	}
}
