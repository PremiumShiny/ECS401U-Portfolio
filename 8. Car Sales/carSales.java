/* *********************************************************************
    AUTHOR: RICHARD CHEUNG
    Car Sales v0a
    19 November 2019
    DESCRIPTION PENDING
********************************************************************* */

import java.util.Scanner;

class carSales {
    public static void main(String[] p) {
        car c1 = createCar("Triumph", false);
        car c2 = createCar("Mini E", true);
        car c3 = createCar("Focus", false);
        // Setting car records
        userInput(c1, c2, c3);

        System.exit(0);
    } // End method main

    public static void userInput(car c1, car c2, car c3) {
        String choice = input("What car do you want to know about?\n" + getName(c1) + "\n" + getName(c2) + "\n" + getName(c3));
        // Checks if the input matches one of the available car models first
        if (choice.matches("Triumph|Mini E|Focus")) {
            if (choice.matches("Triumph")) {
                print(carString(c1));
            } else if (choice.matches("Mini E")) {
                print(carString(c2));
            } else {
                print(carString(c3));
            }

        } else {
            print("I do not know that make; Try again.");
            userInput(c1, c2, c3);
        }
    } // End method userInput

    // Ask for a string with given message; return string given by user
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        print(message);
        return scan.nextLine();
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

    // Creates car records
    public static car createCar(String carName, boolean carElectric) {
        car c = new car();
        c.name = carName;
        c.electric = carElectric;
        return c;
    }

    // Converts record into string format
    public static String carString(car c) {
        if (getElectric(c)) {
            return "The " + getName(c) + " is electric.";
        } else {
            return "The " + getName(c) + " is NOT electric.";
        }
    }

    // Getter methods
    public static String getName(car c) {
        return c.name;
    }

    public static boolean getElectric(car c) {
        return c.electric;
    }
}

class car {
    String name;
    boolean electric;
}
