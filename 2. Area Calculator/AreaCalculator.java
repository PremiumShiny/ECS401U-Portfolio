/**
 * FILE:    AreaCalculator.java
 * AUTHOR:  Richard Cheung
 * DATE:    24 November 2019
 * USE:		Calculate the necessary flooring material to order.
 * DESC:	Program asks for length and width of room, printing room area. It will then account for 10% extra
 *			space and print out the final area. The program handles small dimensions where AREA > FINAL_AREA,
 *			and large dimensions where AREA > double size by printing an error. There is a check to see whether
 *			the user wants to continue using the program by utilising a loop. Handles catching of inputs
 *			containing only ".", and strings including non-digit characters by printing an error.
 */

import java.math.BigDecimal;	// Allows the use of rounding to specific decimal places
import java.math.RoundingMode;	// Allows a value to be rounded in a specific way
import java.util.Scanner;

class AreaCalculator {
    public static void main(String[] param) {
		double length = getLength();
		double width = getWidth();
		calculation(length, width);

		// Check to see if user wants to continue
        double again = inputDbl("Type '1' to add more values. Type '0' to terminate;");
        while (again != 0 && again != 1) {
            again = inputDbl("This is not a valid input.\nType '1' to add more values. Type '0' to terminate;");
        }
        if (again == 0) {
            System.exit(0);
        } else { // again == 1
            main(param);
        }
    } // End method main

	public static double getLength() {
		final double LENGTH = inputDbl("What is the length of the room in centimetres?");
		return LENGTH;
	}

	public static double getWidth() {
		final double WIDTH = inputDbl("What is the width of the room in centimetres?");
		return WIDTH;
	}

	// Converts square centimetres to square metres, works out 10% extra space and prints the values
	// If AREA is too small or large, prints an error, otherwise passing AREA and EXTRA to method result
    public static void calculation(double LENGTH, double WIDTH) {
        final double AREA = (LENGTH * WIDTH) / 10000;

        if (AREA >= 9.99e+305) { // Double upper limit
            print("\nThe result is too large to be printed.");
        } else if (AREA <= 0.45) { // FINAL_AREA < AREA
            print("\nThe result is too small to be printed.");
        } else {
            print("\nThe area of your room is " + AREA + "m².");

			final double EXTRA = AREA / 10;
			print("The extra flooring you would need to account for wastage is " + EXTRA + "m².");
			result(AREA, EXTRA);
		}
    } // End method calculation

	// Calculates the total area needed, accounting for 10% extra area
	// Prints the final area of flooring that needs to be ordered
    public static void result(double AREA, double EXTRA) {
        final double EXTRA_AREA = (AREA + EXTRA);
        BigDecimal dec = new BigDecimal(EXTRA_AREA); // Creates a new variable to use with BigDecimal
        final BigDecimal FINAL_AREA = dec.setScale(1, RoundingMode.DOWN); // setScale '1' will truncate to 1 decimal place
        print("The total flooring material to order is " + FINAL_AREA + "m²."); // RoundingMode.DOWN will round down
    } // End method result

    // Combination of string input and double parsing; if the input isn't a double, it will loop
    // Handles catching of ".", and strings that include non-digit characters
    public static double inputDbl(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        String userInput = scan.nextLine();
        while (userInput.matches("[.]") || userInput.matches(".*[^0-9.].*") || userInput.matches("")) {
            print("This is not a valid input. Enter a POSITIVE NUMBER.");
            print(message);
            userInput = scan.nextLine();
        }
        return Double.parseDouble(userInput);
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }
} // End class AreaCalculator
