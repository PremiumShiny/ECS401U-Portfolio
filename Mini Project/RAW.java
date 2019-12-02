/********************************
*	AUTHOR: RICHARD CHEUNG		*
*	GAME NAME PENDING V5A		*
*	26 November 2019			*
*	A battle simulator      	*
********************************/

import java.util.Scanner;

class game{
	public static void main (String[] p){		
		title();
		playerMode();
		battle();
		
		
	} // end main

	// Start of program, with choice of whether a new save is created or an existing one is loaded.
	public static void title(){
		print("*****************************\n*   NEW GAME     CONTINUE   *\n*****************************");
		String choice = input("");
		if (choice.matches("NEW GAME|CONTINUE")){
			if (choice.matches("NEW GAME")){
				playerMode();
			}
			else{ // Return to main
			}
		}
		else{
			error();
			title();
		}
	} // end title

	// Choice of whether to battle against an AI or a second local player.
	public static void playerMode(){
		print("*****************************\n*   VS CPU	 VS HUMAN   *\n*****************************");
		String choice = input("");
		if (choice.matches("VS CPU|VS HUMAN")){
			if (choice.matches("VS CPU")){
				unprogram();
			}
			else{ // Return to main
			}
		}
		else{
			error();
			playerMode();
		}
	} // end playerMode

    // Battle menu, including battling, team management, item management and a function to save.
	public static void battle(ally a1){

	   // print("CYNTHIA SENDS OUT " + getEnemyName(e1) + "\nWHAT WILL YOU DO?");

	   // Setting ally abstract data type
		ally a1 = createAlly("TORTERRA", 75, 239, 155, 159, 101);
		ally a2 = createAlly("INFERNAPE", 75, 211, 173, 123, 179);
		ally a3 = createAlly("EMPOLEON", 75, 223, 165, 159, 107);
		ally a4 = createAlly("CLEFABLE", 75, 239, 141, 139, 107);
		ally a5 = createAlly("ALAKAZAM", 75, 179, 156, 122, 101);
		ally a6 = createAlly("MAGMORTAR", 75, 209, 182, 138, 141);
		
		// Setting enemy abstract data type
		enemy e1 = createEnemy("SPIRITOMB", 74, 169, 153, 178, 68);
		enemy e2 = createEnemy("ROSERADE", 74, 184, 161, 143, 102);
		enemy e3 = createEnemy("TOGEKISS", 76, 228, 147, 177, 139);
		enemy e4 = createEnemy("LUCARIO", 76, 203, 187, 123, 153);
		enemy e5 = createEnemy("MILOTIC", 74, 236, 135, 168, 136);
		enemy e6 = createEnemy("GARCHOMP", 78, 268, 180, 157, 176);
		
		print("*****************************\n*   FIGHT\t  POKEMON   *\n*    BAG\t   SAVE     *\n*****************************");
		String choice = input("");
		if (choice.matches("FIGHT|POKEMON|BAG|SAVE")){
			if (choice.matches("FIGHT")){
				unprogram();
			}
			else if (choice.matches("POKEMON")){
				print(allyList(a1));
				print(allyList(a2));
				print(allyList(a3));
				print(allyList(a4));
				print(allyList(a5));
				print(allyList(a6));
			}
			else if (choice.matches("BAG")){
				String bag[] = {"MAX POTION", "REVIVE", "POTION", "SHINY STONE", "MAX REVIVE", "SUPER POTION"};
				//"Potion", "Super Potion", "Max Potion", "Max Potion", "Revive", "Shiny Stone"
				print("ITEMS IN BAG");
				for (int i=0; i<bag.length; i++){
					print(bag[i]);
				}
				print("\nWHAT DO YOU WANT TO DO?\nUSE\tSORT\tBACK");
				choice = input("");
				if (choice.matches("USE|SORT|BACK")){	
					if (choice.matches("SORT")){
						int n = bag.length;

						for (int i = 0; i<n; i++){
							for (int j = i+1; j<n; j++){
								if (bag[i].compareTo(bag[j])>0){
									String temp = bag[i];
									bag[i] = bag[j];
									bag[j] = temp;
								}
							}
						}
						print("\nITEMS IN BAG - Alphabetical");
						for (int i = 0; i < n-1; i++){
							print(bag[i]);
						}
						print(bag[n-1]);
					}
				}
			}
			else{
				unprogram();
			}
		}
		else{
			error();
			battle();
		}
	} // end battle
	
    // A generic error message to be printed if an input is not valid.
	public static void error(){
		print("This is not a valid request. Try again.");
	}
	// A generic error message to be printed if an option that has not yet been programmed is selected.
	public static void unprogram(){
		print("*****************************************************\nTHIS FEATURE HAS NOT BEEN IMPLEMENTED IN THIS VERSION\n\t       Please check back soon!\n*****************************************************");
	}
	
	// Ask for a string with message ">>> CHOOSE AN OPTION"; will overwrite any message printed in the input.
    // toUpperCase forces an input to be capitals, allowing lowercase input by the user.
	public static String input(String message){
		Scanner scan = new Scanner(System.in);
		print(">>> CHOOSE AN OPTION");
		String userInput = scan.nextLine();
		return userInput.toUpperCase();
	}

	// Print message to the screen
	public static void print(String message){
		System.out.println(message);
	}
	
	// Creating ally abstract data type
	public static ally createAlly (String allyName, int allyLV, int allyHP, int allyATK, int allyDEF, int allySPD){
		ally a = new ally();
		a.name = allyName;
		a.LV = allyLV;
		a.HP = allyHP;
		a.ATK = allyATK;
		a.DEF = allyDEF;
		a.SPD = allySPD;
		return a;
	}
	
	// Creating enemy abstract data type
	public static enemy createEnemy (String enemyName, int enemyLV, int enemyHP, int enemyATK, int enemyDEF, int enemySPD){
		enemy e = new enemy();
		e.name = enemyName;
		e.LV = enemyLV;
		e.HP = enemyHP;
		e.ATK = enemyATK;
		e.DEF = enemyDEF;
		e.SPD = enemySPD;
		return e;
	}
	
	// Accessor methods
	public static String getAllyName (ally a){
		return a.name;
	}
	public static int getAllyLV (ally a){
		return a.LV;
	}
	public static int getAllyHP (ally a){
		return a.HP;
	}
	public static int getAllyATK (ally a){
		return a.ATK;
	}
	public static int getAllyDEF (ally a){
		return a.DEF;
	}
		public static int getAllySPD (ally a){
		return a.SPD;
	}
	
	public static String getEnemyName (enemy e){
		return e.name;
	}
	public static int getEnemyLV (enemy e){
		return e.LV;
	}
	public static int getEnemyHP (enemy e){
		return e.HP;
	}
	public static int getEnemyATK (enemy e){
		return e.ATK;
	}
	public static int getEnemyDEF (enemy e){
		return e.DEF;
	}
		public static int getEnemySPD (enemy e){
		return e.SPD;
	}
	
	// Returns a readable string
	public static String allyList (ally a){
		return "Lv." + getAllyLV(a) + "\t" + getAllyName(a) + "\t" + getAllyHP(a) + "HP";
	}
}

// Abstract Data Type classes
class ally{
	String name;
	int LV;
	int HP;
	int ATK;
	int DEF;
	int SPD;
}
class enemy{
	String name;
	int LV;
	int HP;
	int ATK;
	int DEF;
	int SPD;
}
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

*****************************************************
THIS FEATURE HAS NOT BEEN IMPLEMENTED IN THIS VERSION
               Please check back soon!
*****************************************************
*/