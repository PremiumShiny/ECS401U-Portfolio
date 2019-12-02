/*
 * <EXP>   = +<DIGIT><EXP> | S<EXP> | <DIGIT>
 * <DIGIT> = 0|1|2|3|4|5|6|7|8|9|A|B|C|D|E|F
 * EXP Stands for expressions where S<EXP> means to take the num of an expression
 * +<DIGIT><EXP> means addition of two digits, and can be stacked with more expressions
 * Simply typing a digit will return its value
 */

import java.util.Scanner;

class short9 {

    public static void main (String[] param) {
        print("TEST_MAIN");
        String userIn = input("Please enter an expression;");
        int answer = evalEXP(userIn);

        print("The answer is " + answer);

        System.exit(0);
    }

    // Recursively evaluates expressions
    public static int evalEXP (String userIn) {
        print("TEST EVALEXP");
        int result = -1;

        // Uses length to determine whether the input is a single digit or expression
        int length = userIn.length();
        if (length == 1) {
            result = evalDIGIT(userIn);
        } else {
            //evaluate expression
        }
        return result;
    }

    public static int evalDIGIT (String userIn) {
        print("TEST EVALDIGIT");
        int result = -1;

        if (userIn.equals("[0-9]")) {
            result = Integer.parseInt(userIn);
        }
        else if (userIn.equals("[A-F]")) {
            evalHEX(userIn);
        } else {
            print("this will never get printed");
        }
        return result;
    }

    public static int evalHEX (String userIn) {
        print("TEST EVALHEX");
        String[] hexPastNine = {"A", "B", "C", "D", "E", "F"};
        int[] hexCompare = {10, 11, 12, 13, 14, 15};
        int result = -1;
        for (int hex : hexCompare) {
            if (userIn.equals(hex)) {
                hex = hex + 10;
                System.out.print(hex);
            }
        }
        return result;
    }

    // Combination of string input with string check
    // If the input is not 0-9 or A-F, or is a newline character, it will loop
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        String userInput = scan.nextLine();
        while (userInput.matches(".*[^0-9A-F]") | userInput.matches("")) {
            print("This is not a valid input.\n\t> The program accepts hexadecimal numbers.\n\t> A single digit will return its value in decimal form.\n\t> S<n> will return the sum of <n> numbers.\n\t> +<a><b> will return the sum of <a> and <b>\n\t> Expressions can be concatenated to form more complex expressions.");
            print("Please enter an expression;");
            userInput = scan.nextLine();
        }
        return userInput;
    }

    // Print a message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

} // End class
