/**
 * FILE:    BusCount.java
 * AUTHOR:  Richard Cheung
 * DATE:    9 December 2019
 * USE:     Inputs bus route and how delayed the bus was. Terminating will display the latest route and how long it took
 * DESC:    Program asks for bus and late inputs cased in a while loop. Whilst the loop is still active, it checks
 *          whether the last route entered had a longer delay or not. If it did, the input route and delay will then
 *          be stored in its own variable as the longest delayed bus. When the program terminates, the program prints
 *          the longest delayed bus and how long it was delayed by.
 */

import java.util.Scanner;

class BusCount {
	public static void main(String[] param) {
		int counter = 0;
		int longestRoute = 0;
		int longestDelay = 0;
		int inputRoute = -1; // Any value as long as it isn't 0 so
		int inputDelay = 0; // the while loop can be initialised

		while (inputRoute != 0) {
			// When a longer delay is found, the Long variables will be replaced
			if (inputDelay > longestDelay) {
				longestRoute = inputRoute;
				longestDelay = inputDelay;
			} else {
				counter = counter + 1;
				inputRoute = inputInt("Which bus passed? (Enter 0 to terminate)");
				if (inputRoute != 0) {
					inputDelay = inputInt("How many minutes late was it?");
				}
			}   // else 0 would have been entered, breaking the loop.
		}

		print("Busses passed: " + (counter - 1) + "\nMost Delayed Route: " + longestRoute + "\nMinutes Delayed: " + longestDelay);
		System.exit(0);
	} // End method main

	/**
	 * METHODS USED TO SIMPLIFY CODE BY USING KEYWORDS
	 */

	// Ask for a string with given message; return string given by user
	public static String input(String message) {
		Scanner scan = new Scanner(System.in);
		String userInput;
		print(message);
		userInput = scan.nextLine();
		return userInput;
	}

	// Ask for an integer with given message; returns integer given by user
	// If a valid integer is not found, will ask again
	public static int inputInt(String message) {
		String userInput;
		int integer;
		userInput = input(message);
		while (userInput.matches(".*[^0-9].*") || userInput.matches("")) {
			print("This is not a valid input. Enter an INTEGER, not STRING.");
			userInput = input(message);
		}
		integer = Integer.parseInt(userInput);
		return integer;
	}

	// Print a message to the screen
	public static void print(String message) {
		System.out.println(message);
	}
} // End class BusCount
