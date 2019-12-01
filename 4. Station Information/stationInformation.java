/* *********************************************************************
	AUTHOR: RICHARD CHEUNG
	Toilet Checker v1.0a
	29 October 2019
	a program that will ask the user to input a station and then check
	if there are toilets available and if so, how much they cost.
********************************************************************* */

import java.util.Scanner;

class stationInformation{
	public static void main (String[] p){
		list();
		System.exit(0);
	}
	
	public static void list(){ // Lists all stations available
	// Sets station name, toilet access and price to each record
	station s1 = new station();
	s1 = setName(s1, "Mile End");
	s1 = setToilet(s1, "No");

	station s2 = new station();
	s2 = setName(s2, "Stratford");
	s2 = setToilet(s2, "Yes");
	int price2 = 50;
	s2 = setCost(s2, price2);
	
	station s3 = new station();
	s3 = setName(s3, "North Greenwich");
	s3 = setToilet(s3, "Yes");
	int price3 = 20;
	s3 = setCost(s3, price3);
	
	station s4 = new station();
	s4 = setName(s4, "West Ham");
	s4 = setToilet(s4, "Yes");
	int price4 = 10;
	s4 = setCost(s4, price4);
	
	userInput(s1, s2, s3, s4);	
	return;
	}
	
	// Returns functions from the station record
	public static String getName (station s){
		return s.name;
	}
	public static String getToilet (station s){
		return s.toilet;
	}
	public static int getCost (station s){
		return s.cost;
	}
	
	// Sets functions for station record
	public static station setName (station s, String stationName){
		s.name = stationName;
		return s;
	}
	public static station setToilet (station s, String stationToilet){
		s.toilet = stationToilet;
		return s;
	}
	public static station setCost (station s, int price){
		s.cost = price;
		return s;
	}
	
	public static void userInput(station s1, station s2, station s3, station s4){
		String choice = input("Which station would you like to get the information of?\nMile End\nStratford\nNorth Greenwich\nWest Ham\n");
		
		if (choice.equals("Mile End")){
			boolean boolToilet = s1.toilet.equals("No");    // If a station has no toilet
			if (boolToilet == true){					    // boolToilet will be flagged as true
				print(choice + " does not have a toilet."); // and will return that there is no toilet
			}
			else{											// Otherwise it will print its price
				print(choice + " has a toilet.");
				print("It costs " + s1.cost + "p.");
			}
		}	// Repeated fragments for each station that has a record
		else if (choice.equals("Stratford")){
			boolean boolToilet = s2.toilet.equals("No");
			if (boolToilet == true){
				print(choice + " does not have a toilet.");
			}
			else{
				print(choice + " has a toilet.");
				print("It costs " + s2.cost + "p.");
			}
		}
		else if (choice.equals("North Greenwich")){
			boolean boolToilet = s3.toilet.equals("No");
			if (boolToilet == true){
				print(choice + " does not have a toilet.");
			}
			else{
				print(choice + " has a toilet.");
				print("It costs " + s3.cost + "p.");
			}
		}
		else if (choice.equals("West Ham")){
			boolean boolToilet = s4.toilet.equals("No");
			if (boolToilet == true){
				print(choice + " does not have a toilet.");
			}
			else{
				print(choice + " has a toilet.");
				print("It costs " + s4.cost + "p.");
			}
		}
		else{ // If input is not valid, it will repeat
			print("This is not a valid station. Try again.");
			userInput(s1, s2, s3, s4);
		}
	}
	/* *****************************************************************
	Ask for a string with given message; return string given by user
	*****************************************************************  */
	public static String input(String msg){
		Scanner scan = new Scanner(System.in);
		String val;
		print(msg);
		val = scan.nextLine();
		return val;
	} //input("<MESSAGE>"); will set the user input as a string
	
	/* *****************************************************************
		Print a message to the screen
	***************************************************************** */
	public static void
	print(String msg){
		System.out.println(msg);
		return;
	} //System.out.println("<MESSAGE>") simply becomes print("MESSAGE")
	
} // End class toiletChecker

class station{
	String name;
	String toilet;
	int cost;
} // End class station