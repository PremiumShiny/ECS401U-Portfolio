/**
 * FILE:    VendingMachine.java
 * AUTHOR:  Richard Cheung
 * DATE:    3 December 2019
 * USE:     Prints vending machine menu
 * DESC:    Asks for input and if the input is valid, asks for confirmation.
 *          on confirmation, prints dynamic purchase message. If an Invalid
 *          input is entered, the user will be asked for another input
 */

import java.util.Scanner;

class VendingMachine {
    public static void main(String[] param) {
        printMenu();
    } // End method main

    // Prints a list of available items by cross-referencing indices in itemCode to itemName
    public static void printMenu() { // A = index 0, B = index 1, etc.
        String[] itemCode  = {"A", "B", "C"};
        String[] itemName  = {"Packet of Crisps", "Health Bar", "Bar of Chocolate"};
        String[] itemPrice = {"£1.50", "£1.20", "£2.00"};

        print("Available Items");
        for (int i = 0; i < itemCode.length; i++) {  // Uses index number to print
            print(itemCode[i] + ": " + itemName[i]); // Prints "A: Packet of Crisps"
        } // Will continue until it reaches itemCode.length, the highest index of the array

        whichItem(itemCode, itemName, itemPrice);
    } // End method printMenu

    // Method asks the user for an input and returns their choice
    public static String whichItem(String[] itemCode, String[] itemName, String[] itemPrice) { // A = index 0, B = index 1, etc.
        String choice = input("What would you like? Please enter a letter;");
        // If choice is not A, B, or C, it will repeat the method until they are chosen
        if (choice.matches(".*[^ABC].*") || choice.matches("")) {
            print("That is not a valid input. Try again.\n");
            printMenu();
            whichItem(itemCode, itemName, itemPrice);
        } else {
            confirmation(itemCode, itemName, itemPrice, choice);
        }
        return choice;
    } // End method whichItem

    // Prints confirmation message. If the item is not confirmed, the program will loop back to main
    public static void confirmation(String[] itemCode, String[] itemName, String[] itemPrice, String choice) {
        for (int i = 0; i < itemCode.length; i++) { // Sets length equal to array length
            if (choice.matches(itemCode[i])) {      // i standardised across all arrays.
                print(itemName[i] + " will cost " + itemPrice[i] + ".");
                // If choice = A, index 0 will be chosen and so itemName and itemPrice will pull data from index 0
                String confirm = input("Would you like to purchase this item? ('Y' to confirm);");
                if (confirm.matches("Y")) {
                    String itemNameLower = itemName[i];
                    print("Enjoy your " + itemNameLower.toLowerCase() + "!");
                    System.exit(0);
                } else { // If choice was not confirmed, will loop back
                    print("Redirecting to main menu.\n");
                    printMenu();
                }
            }
        }
    } // End method confirmation

    // Ask for a String with message; Return String from user
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        return scan.nextLine();
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }
} // End class VendingMachine
