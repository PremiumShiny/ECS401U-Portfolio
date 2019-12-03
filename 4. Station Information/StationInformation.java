/**
 * FILE:    StationInformation.java
 * AUTHOR:  Richard Cheung
 * DATE:    3 December 2019
 * USE:     Lists stations and prints station information
 * DESC:    Program asks the user to input a station and then check
 *          whether the station has a toilet and if so, how much they cost.
 */
import java.util.Scanner;

class StationInformation {
    public static void main(String[] param) {
        stations();
    } // End method main

    // Creates station name, toilet access, and price to each record
    public static void stations() {
        Station s1 = new Station();
        s1 = setName(s1, "Mile End");
        s1 = setToilet(s1, false);

        Station s2 = new Station();
        s2 = setName(s2, "Stratford");
        s2 = setToilet(s2, true);
        s2 = setCost(s2, 50);

        Station s3 = new Station();
        s3 = setName(s3, "North Greenwich");
        s3 = setToilet(s3, true);
        s3 = setCost(s3, 20);

        Station s4 = new Station();
        s4 = setName(s4, "West Ham");
        s4 = setToilet(s4, false);

        userInput(s1, s2, s3, s4);
    } // End method stations

    // Asks for user input. If a valid input is found, searches and returns information, otherwise, the user is asked for another input
    public static void userInput(Station s1, Station s2, Station s3, Station s4) {
        String choice = input("Which station would you like to get the information of?\nMile End\nStratford\nNorth Greenwich\nWest Ham\n");

        if (choice.matches("Mile End|Stratford|North Greenwich|West Ham")) {
            if ("Mile End".equals(choice)) {
                print(hasToilet(s1));
            } else if ("Stratford".equals(choice)) {
                print(hasToilet(s2));
            } else if ("North Greenwich".equals(choice)) {
                print(hasToilet(s3));
            } else { // "West Ham".equals(choice)
                print(hasToilet(s4));
            }
            System.exit(0);
        } else {
            print("That is not a valid station. Try again.");
            userInput(s1, s2, s3, s4);
        }
    } // End method userInput

    // Checks if a station has a toilet and returns a string
    public static String hasToilet(Station s) {
        if (getToilet(s)) {
            return getName(s) + " has a toilet. It costs " + getCost(s) + "p.";
        } else {
            return getName(s) + " does not have a toilet.";
        }
    } // End method hasToilet

    // Returns functions from the Station record
    public static String getName(Station s) {
        return s.name;
    }

    public static boolean getToilet(Station s) {
        return s.toilet;
    }

    public static int getCost(Station s) {
        return s.cost;
    }

    // Sets functions for the Station record
    public static Station setName(Station s, String stationName) {
        s.name = stationName;
        return s;
    }

    public static Station setToilet(Station s, boolean stationToilet) {
        s.toilet = stationToilet;
        return s;
    }

    public static Station setCost(Station s, int stationCost) {
        s.cost = stationCost;
        return s;
    }

    // Ask for a String with message; Return String from user
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        return scan.nextLine();
    }

    // Print message to screen
    public static void print(String message) {
        System.out.println(message);
    }
} // End class StationInformation

class Station {
    String name;
    boolean toilet;
    int cost;
} // End class Station
