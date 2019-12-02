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
        String userIn = input("Please enter an expression\n");

        int answer = evalEXP(userIn);
            answer = evalDIGIT(userIn);
        int result;

        print("The answer is " + answer);

        System.exit(0);
    }

    // Recursively evaluates expressions
    public static int evalEXP (String input){
        print("TEST EVALEXP");
        int result;
        int answer;

        int length = input.length();

        if ( length == 1) {
            answer = evalDIGIT(input);
        } else {
            result = 0;
        }
        return answer;
    }

    public static int evalDIGIT (String input) {
        print("TEST EVALDIGIT");
        int result;
        int answer;

        if (input.contains(".*[^0-9A-F].*")) {
            print("That is not a valid input");
        }
        else {
            result = Integer.parseInt(input);
        }

        return answer;
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
