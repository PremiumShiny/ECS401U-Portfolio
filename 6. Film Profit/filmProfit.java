/* *********************************************************************
    AUTHOR: RICHARD CHEUNG
    Film Profit v0a
    19 November 2019
    DESCRIPTION PENDING
********************************************************************* */

import java.util.Scanner;

class filmProfit {
    public static void main(String[] p) {
        final int totalFilms = 5; // Set amount of films to be processed
        int totalProfit = 0; // Initialising totalProfit
        String printMessage = "";
        film[] films = new film[totalFilms];

        for (int i = 0; i < totalFilms; i++) {
            String name = input("Enter a film name");
            int profit = inputInt("How much did " + name + " make in millions of pounds");
            totalProfit = totalProfit + profit;

            film f = filmInfo(name, profit);
            printMessage = printMessage + filmString(f) + "\n";
            films[i] = f;
        }
        printMessage = printMessage + "\nTotal profit of all " + totalFilms + " films: £" + totalProfit + "m.";
        print(printMessage);
        System.exit(0);
    }

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
        return Integer.parseInt(userInput);
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

    // Converts record into string format
    public static String filmString(film f) {
        String message = getName(f) + ", " + getProfit(f);
        return message;
    }

    // Getter methods return variables from record
    public static String getName(film f) {
        return f.name;
    }

    public static int getProfit(film f) {
        return f.profit * 1000000;
    }

    // Creating record with name and profit variables
    public static film filmInfo(String filmName, int filmProfit) {
        film f = new film();
        f.name = filmName;
        f.profit = filmProfit;
        return f;
    }
}

class film {
    String name;
    int profit;
}
