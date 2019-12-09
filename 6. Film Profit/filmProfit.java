/**
 * FILE:    FilmProfit.java
 * AUTHOR:  Richard Cheung
 * DATE:    9 December 2019
 * USE:     Input five film titles and their profit, printing all five at the
 *          end with their price as well as the total profit for all five films
 * DESC:    Program will ask for a number and a nursery rhyme will be initialised based on the input
 *          and count down until 1, where the for loop will end.
 */

import java.util.Scanner;

class FilmProfit {
    public static void main(String[] param) {
        final int TOTAL_FILMS = 5; // Set amount of films to be processed
        int totalProfit = 0;       // Initialising totalProfit
        String printMessage = "The films and the total amount they made are:\n";
        Film[] films = new Film[TOTAL_FILMS];

        profitMade(TOTAL_FILMS, totalProfit, printMessage, films);
    } // End method main

    public static void profitMade(int TOTAL_FILMS, int totalProfit, String printMessage, Film[] films) {
        for (int i = 0; i < TOTAL_FILMS; i++) {
            String name = input("Enter a film name");
            int profit = inputInt("How much did " + name + " make in millions of pounds");
            totalProfit = totalProfit + profit;

            Film f = filmInfo(name, profit);
            printMessage = printMessage + filmString(f) + "\n";
            films[i] = f;
        }
        finalPrint(printMessage, TOTAL_FILMS, totalProfit);
    } // End method profitMade

    public static void finalPrint(String printMessage,int TOTAL_FILMS, int totalProfit) {
        // The final print line after the loop ends
        printMessage = printMessage + "\nTotal profit of all " + TOTAL_FILMS + " films: £" + totalProfit + "m.";
        print(printMessage);
        System.exit(0);
    } // End method finalPrint

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
        userInput = input(message);
        while (userInput.matches(".*[^0-9].*") || userInput.matches("")) {
            print("This is not a valid input. Enter an INTEGER, not STRING.");
            userInput = input(message);
        }
        return Integer.parseInt(userInput);
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * ADT METHODS
     */

    // Converts record into string format
    public static String filmString(Film f) {
        String message = getName(f) + ", " + getProfit(f);
        return message;
    }

    // Getter methods return variables from record
    public static String getName(Film f) {
        return f.name;
    }

    // Returns profit to print in millions
    public static int getProfit(Film f) {
        return f.profit * 1000000;
    }

    // Creating record with name and profit variables
    public static Film filmInfo(String filmName, int filmProfit) {
        Film f = new Film();
        f.name = filmName;
        f.profit = filmProfit;
        return f;
    }
} // End class FilmProfit

class Film {
    String name;
    int profit;
}
