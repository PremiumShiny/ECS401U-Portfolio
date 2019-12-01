/* *********************************************************************
	AUTHOR: RICHARD CHEUNG
	Bus Count v0a
	19 November 2019
	DESCRIPTION PENDING
********************************************************************* */
import java.util.Scanner;

class busCount{
	public static void main (String[] p){
		
		int counter = 0;
		int routeLong = 0;
		int delayLong = 0;
		int inputRoute = 1; // Any value as long as it isn't 0 so
		int inputDelay = 0; // the while loop can be initialised
		
		while (inputRoute != 0){
			if (inputDelay > delayLong){
				routeLong = inputRoute;
				delayLong = inputDelay;
			}	// When a longer delay is found, the Long variables will be replaced	
			else{
				counter = counter + 1;
				inputRoute = inputInt("Which bus passed? (Enter 0 to terminate)");
					if (inputRoute !=0){
						inputDelay = inputInt("How many minutes late was it?");
					}
			}		// else 0 would have been entered, breaking the loop.
		}
		
		print("Busses passed: " + (counter-1) + "\nMost Delayed Route: " + routeLong + "\nMinutes Delayed: " + delayLong);	
		System.exit(0);
    }
	
	// Ask for a string with given message; return string given by user
	public static String input(String message){
		Scanner scan = new Scanner(System.in);
		String userInput;
		print(message);
		userInput = scan.nextLine();
		return userInput;
	}

	// Ask for an integer with given message; returns integer given by user
	// If a valid integer is not found, will ask again
	public static int inputInt(String message){
		String userInput;
		int integer;
		userInput = input(message);
		while(userInput.matches(".*[^0-9].*") || userInput.matches("")){
			print("This is not a valid input. Enter an INTEGER, not STRING.");
			userInput = input(message);
		}
		integer = Integer.parseInt(userInput);
		return integer;
	}

	// Print a message to the screen
	public static void print(String message){
		System.out.println(message);
	}
}