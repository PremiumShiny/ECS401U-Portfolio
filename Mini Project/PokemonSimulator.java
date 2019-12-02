import java.util.Scanner;

class PokemonSimulator {
	
	public static void main (String[] p) {
		title();
		playerMode();
		battle();
	} // end main
	
	// Start of program, with choice of whether a new save is created or an existing one is loaded.	
	public static void title() {
		print("*****************************\n*   NEW GAME     CONTINUE   *\n*****************************");
		String choice = input("");
		if (choice.matches("NEW GAME|CONTINUE")) {
			if (choice.matches("NEW GAME")) { } // Return to main
			else { // choice.matches("CONTINUE")
				unprogram();
			}
		}
		else {
			error();
			title();
		}
	} // end title
	
	// Choice of whether to battle against an AI or a second local player.
	public static void playerMode() {
		print("*****************************\n*   VS CPU	 VS HUMAN   *\n*****************************");
		String choice = input("");
		if (choice.matches("VS CPU|VS HUMAN")) {
			if (choice.matches("VS CPU")) {
				unprogram();
			}
			else { } // choice.matches("VS CPU)" ; Return to main
		}
		else {
			error();
			playerMode();
		}
	} // end playerMode
	
	// Displays the battle menu
	public static void battle() {
		print("*****************************\n*   FIGHT\t  POKEMON   *\n*    BAG\t   SAVE     *\n*****************************");
		String choice = input("");
			if (choice.matches("FIGHT|POKEMON|BAG|SAVE")) {
				if (choice.matches("FIGHT")) {
					//fight();
					unprogram();
				}
				else if (choice.matches("POKEMON")) {
					//team();
					unprogram();
				}
				else if (choice.matches("BAG")) {
					items();
				}
				else { //choice.matches("SAVE")
					//save();
					unprogram();					
				}
			}
			else {
				error();
				battle();
			}
	} // end battle
	
	public static void items() {
		String bag[] = { "MAX POTION", "REVIVE", "POTION", "SHINY STONE", "MAX REVIVE", "SUPER POTION" };
		
		print("ITEM BAG\n");
		for (int i = 0; i < bag.length; i++) {
			print(bag[i]);
		}
		print("*****************************\n*    USE    SORT    BACK    *\n*****************************");
	}
	
	
	/*	METHODS USED TO SIMPLIFY CODE BY USING KEYWORDS	*/
	
	// A generic error message to be printed if an input is not valid.
	public static void error() {
		print("THIS IS NOT A VALID INPUT");
	}
	
	// A generic message to be printed if an option that has not yet been programmed is selected.
	// The program will be forced to terminate.
	public static void unprogram() {
		print("*****************************************************\nTHIS FEATURE HAS NOT BEEN IMPLEMENTED IN THIS VERSION\n\t       PLEASE CHECK BACK SOON!\n\t   THE PROGRAM WILL NOW TERMINATE!\n*****************************************************");
		System.exit(0);
	}
	
	// Ask for a string with message ">>> CHOOSE AN OPTION"; will overwrite any message printed in the input.
    // toUpperCase forces an input to be capitals, allowing lowercase input by the user.
	public static String input(String message) {
		Scanner scan = new Scanner(System.in);
		print(">>> CHOOSE AN OPTION");
		String userInput = scan.nextLine();
		return userInput.toUpperCase();
	}

	// Print message to the screen
	public static void print(String message) {
		System.out.println(message);
	}
} // end class PokemonSimulator 

/* GUI
*****************************
*   NEW GAME     CONTINUE   *
*****************************

*****************************
*   VS CPU		 VS HUMAN   *
*****************************

*****************************
*   FIGHT         POKEMON   *
*    BAG           SAVE     *
*****************************

*****************************
*    USE    SORT    BACK    *
*****************************
*****************************\n*    USE    SORT    BACK    *\n*****************************
*****************************************************
THIS FEATURE HAS NOT BEEN IMPLEMENTED IN THIS VERSION
               PLEASE CHECK BACK SOON!
           THE PROGRAM WILL NOW TERMINATE!
*****************************************************
*/