/* **********************************************************
	AUTHOR: RICHARD CHEUNG
	Nursery Rhyme Code Complete
	24 November 2019
	A program where the user is able to enter a number and a
	nursery rhyme will be initialised based on their input
	and count down until 1, where the for loop will end.
********************************************************** */

import java.util.Scanner;

class nurseryRhyme{
	public static void main (String[] p){
		int initial = inputInt("How many are there in the bed?");
		while(initial < 1){ // Check to see if a valid number can be used
			print("This is not a valid input. Enter a number GREATER than or EQUAL to 1");
			initial = inputInt("How many are there in the bed?");
		}
		// Counter from initial input to zero, reducing my one each iteration
		for (int current = initial; current>0; --current){
			if(current == 1){ // If 1 check comes first to make sure it doesn't possibly stop at 0 or 2 instead
				print("\nThere was " + current + " in the bed and the little one said,\nGood Night.");
			}
			else{ // Generic case if the value isn't 1
				print("\nThere were " + current + " in the bed and the little one said,\nRoll Over, Roll Over,\nSo they all rolled over and one fell out...");
			}
		}
		System.exit(0);
	}

	// Combination of string input and integer parsing
	// If the input isn't an integer, it will loop
	public static int inputInt(String message){
		Scanner scan = new Scanner(System.in);
		print(message);
		String userInput = scan.nextLine();
		while(userInput.matches(".*[^0-9].*") || userInput.matches("")){
			print("This is not a valid input. Enter an INTEGER, not STRING.");
			print(message);
			userInput = scan.nextLine();
		}
		return Integer.parseInt(userInput);
	}
	// Print a message to the screen
	public static void print(String message){
		System.out.println(message);
	}
}
