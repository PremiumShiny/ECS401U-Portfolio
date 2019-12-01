/*
 * <EXP>   = +<DIGIT><EXP> | S<EXP> | <DIGIT>
 * <DIGIT> = 0|1|2|3|4|5|6|7|8|9|A|B|C|D|E|F
 * EXP Stands for expressions where S<EXP> means to take the num of an expression
 * +<DIGIT><EXP> means addition of two digits, and can be stacked with more expressions
 * Simply typing a digit will return its value
 */


import java.util.*;

class short9{

    public static void main (String[] param){

        print("test");
        String input = input("Please enter an expression\n");

        int answer = evalEXP(input);

        print("The answer is " + answer);

        System.exit(0);
    }

    // Recursively evaluates expressions
    public static int evalEXP (String input){

        int result;

        int length = input.length();

        if ( length == 1)
            result = evalDIGIT(input);

        return result;
    }

    public static int evalDIGIT (String input) {
        int result = -1;

        if (input.contains(".*[^0-9A-F].*")) {
            print("That is not a valid input");
        }
        else {
            System.exit(0);
        }

        return result;
    }

    public static boolean containsOnce(final String s, final CharSequence substring) {
        final String substring0 = substring.toString();
        final int i = s.indexOf(substring0);
        return i != -1 && i == s.lastIndexOf(substring0);
    }

    /* Get a String from the keyboard
     */
    public static String input(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return (scanner.nextLine());
    }

    /* General print
     */
    public static void print(String message)
    {
        System.out.println(message);
    }

} // end class