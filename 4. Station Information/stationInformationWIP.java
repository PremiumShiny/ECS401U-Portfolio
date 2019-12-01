/* *********************************************************
	AUTHOR: RICHARD CHEUNG
	Toilet Checker v1.0a
	29 October 2019
	-Ask for an input, then print whether there is a toilet
		and price if available
********************************************************* */

import java.util.Scanner;

class stationInformationWIP{
	public static void main (String[] p){
		userInput(s);
		System.exit(0);
	}

	// Lists all stations available
	// Sets station name, toilet access and price to each record
	//public static void list(){
	//	station s1 = createStation("Mile End", false, 0);
	//	station s2 = createStation("Stratford", true, 50);
	//	station s3 = createStation("North Grenwich", true, 20);
	//	station s4 = createStation("West Ham", false, 0);
//
//		userInput(s);
//	}

	public static void userInput(station s){
		station s1 = createStation("Mile End", false, 0);
		station s2 = createStation("Stratford", true, 50);
		station s3 = createStation("North Grenwich", true, 20);
		station s4 = createStation("West Ham", false, 0);
		String choice = input("Which station would you like to get the information of?\nMile End\nStratford\nNorth Greenwich\nWest Ham\n");

		if (choice.equals(getName(s))){
			if (getToilet(s)){
				print(getName(s) + " has a toilet.\nIt costs " + getCost(s) + "p.");
			}
			else{
				print(getName(s)  + " does not have a toilet.");
			}
		}
		else { // If input is not valid, it will repeat
			print("This is not a valid station. Try again.");
			userInput(s);
		}
	}

	// Setter method
	public static station createStation (String stationName, boolean stationToilet, int stationCost){
		station s = new station();
		s.name = stationName;
		s.toilet = stationToilet;
		s.cost = stationCost;
		return s;
	}

	// Getter methods
	public static String getName (station s){
		return s.name;
	}
	public static boolean getToilet (station s){
		return s.toilet;
	}
	public static int getCost (station s){
		return s.cost;
	}

	// BASIC Ask for a String with message; Return String from user
	public static String input(String message){
		Scanner scan = new Scanner(System.in);
		print(message);
		return scan.nextLine();
	}
	// Print message to screen
	public static void print(String message){
		System.out.println(message);
	}
}

class station{
	String name;
	boolean toilet;
	int cost;
}