/**
 * FILE:    CarSales.java
 * AUTHOR:  Richard Cheung
 * DATE:    9 December 2019
 * USE:     Lists cars and asks what car would like to be known about. Prints whether the car is electric or not.
 * DESC:    Program uses accessor methods to store information about car data. If a match for a car name is found,
 *			prints information about the car, and if the car is not found, print an error.
 */

import java.util.Scanner;

class CarSales {
    public static void main(String[] param) {
        Car c1 = createCar("Triumph", false);
        Car c2 = createCar("Mini E", true);
        Car c3 = createCar("Focus", false);
        // Setting car records
        userInput(c1, c2, c3);

        System.exit(0);
    } // End method main

    public static void userInput(Car c1, Car c2, Car c3) {
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

    /**
     * METHODS USED TO SIMPLIFY CODE BY USING KEYWORDS
     */

    // Ask for a string with given message; return string given by user
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        return scan.nextLine();
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

    // Creates car records
    public static Car createCar(String carName, boolean carElectric) {
        Car c = new Car();
        c.name = carName;
        c.electric = carElectric;
        return c;
    }

    // Converts record into string format
    public static String carString(Car c) {
        if (getElectric(c)) {
            return "The " + getName(c) + " is electric.";
        } else {
            return "The " + getName(c) + " is NOT electric.";
        }
    }

    // Getter methods
    public static String getName(Car c) {
        return c.name;
    }

    public static boolean getElectric(Car c) {
        return c.electric;
    }
} // End class CarSales

class Car {
    String name;
    boolean electric;
}
