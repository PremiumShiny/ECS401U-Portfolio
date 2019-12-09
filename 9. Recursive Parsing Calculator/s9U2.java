/*
 * <EXP>   = +<DIGIT><EXP> | S<EXP> | <DIGIT>
 * <DIGIT> = 0|1|2|3|4|5|6|7|8|9|A|B|C|D|E|F
 * EXP Stands for expressions where S<EXP> means to take the num of an expression
 * +<DIGIT><EXP> means addition of two digits, and can be stacked with more expressions
 * Simply typing a digit will return its value
 */

import java.util.Scanner;

class s9U2 {

    public static void main (String[] param) {
        print("TEST_MAIN");
        String userIn = input("Please enter an expression in Polish (Prefix) Notation (Entering a wrong input will display more help);");
        int answer = evalEXP(userIn);

        print("The answer is " + answer);

        System.exit(0);
    } // End method main

    // Recursively evaluates expressions
    public static int evalEXP (String userIn) {
        print("TEST_EVALEXP");
        int result = -1;

        // Uses length to determine whether the input is a single digit or expression
        int length = userIn.length();
        if (length == 1) {
            result = evalDIGIT(userIn);
        }
        else {
            int arg1;
            int arg2;

            // Split first two tokens as they are fixed
            String first = nextToken(userIn);
            String rest = restToken(userIn);
            String second = nextToken(rest);
            String last = restToken(rest);

            // Follows structure of PN + DIGIT EXP
            checkOPERATOR(first);       // +
            arg1 = evalDIGIT(second);   // DIGIT
            arg2 = evalEXP(last);       // EXP

            // Final calculation after recursive calculation
            result = arg1 + arg2;
        }
        return result;
    } // End method evalEXP

    public static void checkOPERATOR (String userIn) {
        if (!(userIn.equals("+")) | !(userIn.equals("S")))
            print("TEST_CHECKOPERATOR");
    }

    // If only one character is input, the value will pass to this method
    public static int evalDIGIT (String userIn) {
        print("TEST_EVALDIGIT");
        int result = -1;

        if (userIn.matches("[0-9]")) {
            result = Integer.parseInt(userIn);
        } else {
            result = convertHEX(userIn);
        }
        return result;
    } // End method evalDIGIT

    // Converts A-F to decimal values
    public static int convertHEX (String userIn) {
        print("TEST_CONVERTHEX");
        String[] hexPastNine = {"A", "B", "C", "D", "E", "F"};
        int[] hexCompare = {10, 11, 12, 13, 14, 15};
        int result = -1;

        for (int i = 0; i < hexPastNine.length; i++) {
            if (userIn.equals(hexPastNine[i])) {
                result = i;
            }
        }
        return hexCompare[result];
    } // End method convertHEX

    // Combination of string input with string check
    // If the input is not 0-9 or A-F, or is a newline character, it will loop
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        String userInput = scan.nextLine();
        while (userInput.matches(".*[^0-9A-FS+]") | userInput.matches("")) {
            print("This is not a valid input.\n\t> The program accepts hexadecimal numbers. (Use capital letters)\n\t> A single digit will return its value in decimal form.\n\t> S<n> will return the sum of <n> numbers.\n\t> +<a><b> will return the sum of <a> and <b>\n\t> Expressions can be concatenated to form more complex expressions.");
            print("Please enter an expression;");
            userInput = scan.nextLine();
        }
        return userInput;
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

    public static String nextToken(String userIn) {
        return userIn.substring(0,1);
    }

    public static String restToken(String userIn) {
        return userIn.substring(1);
    }
} // End class
