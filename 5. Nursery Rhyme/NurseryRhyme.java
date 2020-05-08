/**
 * FILE:    NurseryRhyme.java
 * AUTHOR:  Richard Cheung
 * DATE:    1 December 2019
 * USE:     Input an integer and a nursery rhyme will initiate counting down from the input number
 * DESC:    Program will ask for a number and a nursery rhyme will be initialised based on the input
 *          and count down until 1, where the for loop will end.
 */

import java.util.Scanner;

class NurseryRhyme {
	public static void main(String[] param) {
		int initial = howMany();
		verse(initial);
		System.exit(0);
	} // End method main

	// Asks the user how many are in the bed and checks to see if a valid number can be used
	public static int howMany() {
		int initial = inputInt("How many are there in the bed?");
		while (initial < 1) {
			print("This is not a valid input. Enter a number GREATER than or EQUAL to 1");
			initial = inputInt("How many are there in the bed?");
		}
		return initial;
	} // End method howMany

	// Counter from initial input to zero, reducing by one each iteration
	public static void verse(int initial) {
		for (int current = initial; current > 0; --current) {
			if (current == 1) { // If 1 check comes first to make sure it doesn't possibly stop at 0 or 2 instead
				print("\nThere was " + current + " in the bed and the little one said,\nGood Night.");
			} else { // Generic case if the value isn't 1
				print("\nThere were " + current + " in the bed and the little one said,\nRoll Over, Roll Over,\nSo they all rolled over and one fell out...");
			}
		}
	} // End method verse

	// Combination of string input and integer parsing
	// If the input isn't an integer, it will loop
	public static int inputInt(String message) {
		Scanner scan = new Scanner(System.in);
		print(message);
		String userInput = scan.nextLine();
		while (userInput.matches(".*[^0-9].*") || userInput.matches("")) {
			print("This is not a valid input. Enter an INTEGER, not STRING.");
			print(message);
			userInput = scan.nextLine();
		}
		return Integer.parseInt(userInput);
	}

	// Print a message to the screen
	public static void print(String message) {
		System.out.println(message);
	}
} // End class NurseryRhyme
