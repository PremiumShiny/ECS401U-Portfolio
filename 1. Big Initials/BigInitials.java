/**
 * FILE:    BigInitials.java
 * AUTHOR:  Richard Cheung
 * DATE:    23 November 2019
 * DESC:    Program asks for initials and prints large letters.
 *          Handles catching of inputs that are not capital letters or newline characters,
 *          printing an error and asking for a new string to be entered.
 */

import java.util.Scanner;

class BigInitials {
    public static void main(String[] param) {
        arrays();
        System.exit(0);
    } // End method main

    // Method asks for a string and splits it into substrings. The letter matched in [] alphabet is cross-referenced
    // against the respective index of [] bigAlphabet and is printed with a preceding newline character
    public static void convertToBig(String[] alphabet, String[] bigAlphabet) {
        String initial = input("Please enter your initials;");

        String[] initialSplit = initial.split("");
        for (String split : initialSplit) {
            for (int c = 0; c < alphabet.length; c++) {
                if (split.contains(alphabet[c])) {
                    print("\n" + bigAlphabet[c]);
                }
            }
        }
    } // End method convertToBig

    // Ask for a string with message and return string from user. Check if input is an alphabet
    // character; if not, an error is displayed and user is asked to enter another string
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(message);
        String userInput = scan.nextLine();
        while (userInput.matches(".*[^A-Z].*") | userInput.matches("")) { // .* means to find any character sequence; ^ means negation i.e. NOT A to Z
            print("Some characters are not available:\n\t*Please use capital letters.\n\t*Do not use a space between characters.\nPlease enter your initials;");
            userInput = scan.nextLine();
        }
        return userInput;
    }

    // Print message to screen
    public static void print(String message) {
        System.out.println(message);
    }

    // Arrays in own method to reduce visual clutter in IDE
    public static void arrays() {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String[] bigAlphabet = {"  A  \nA   A\nAAAAA\nA   A\nA   A", "BBBB \nB   B\nBBBBB\nB   B\nBBBBB", "CCCCC\nC    \nC    \nC    \nCCCCC", "DDDD \nD   D\nD   D\nD   D\nDDDD ", "EEEEE\nE    \nEEEE \nE    \nEEEEE",
                  "FFFFF\nF    \nFFFF \nF    \nF    ", "GGGGG\nG    \nG  GG\nG   G\nGGGGG", "H   H\nH   H\nHHHHH\nH   H\nH   H", "IIIII\n  I  \n  I  \n  I  \nIIIII", "  JJJ\n    J\n    J\n    J\nJJJJ ",
                  "K   K\nK  K \nKKK  \nK  K \nK   K", "L    \nL    \nL    \nL    \nLLLLL", "M   M\nMM MM\nM M M\nM   M\nM   M", "N   N\nNN  N\nN N N\nN  NN\nN   N", "OOOOO\nO   O\nO   O\nO   O\nOOOOO",
                  "PPPPP\nP   P\nPPPPP\nP    \nP    ", "QQQQQ\nQ   Q\nQ Q Q\nQQQQQ\n    Q", "RRRR \nR   R\nRRRR \nR  R \nR   R", "SSSSS\nS    \nSSSSS\n    S\nSSSSS", "TTTTT\n  T  \n  T  \n  T  \n  T  ",
                  "U   U\nU   U\nU   U\nU   U\nUUUUU", "V   V\nV   V\nVV VV\n V V \n  V  ", "W   W\nW   W\nW W W\nWW WW\nW   W", "X   X\n X X \n  X  \n X X \nX   X", "Y   Y\nY   Y\n Y Y \n  Y  \n  Y  ", "ZZZZZ\n   Z \n  Z  \n Z   \nZZZZZ"};

        convertToBig(alphabet, bigAlphabet); // alphabet and bigAlphabet arrays passed to letterToBig method
    } // End method arrays
} // End class BigInitials

/** **************************** VISUAL REPRESENTATION OF BIG ALPHABET ********************************** *
 *   A      BBBB    CCCCC   DDDD    EEEEE   FFFFF   GGGGG   H   H   IIIII     JJJ   K   K   L       M   M *
 * A   A    B   B   C       D   D   E       F       G       H   H     I         J   K  K    L       MM MM *
 * AAAAA    BBBBB   C       D   D   EEEE    FFFF    G  GG   HHHHH     I         J   KKK     L       M M M *
 * A   A    B   B   C       D   D   E       F       G   G   H   H     I         J   K  K    L       M   M *
 * A   A    BBBBB   CCCCC   DDDD    EEEEE   F       GGGGG   H   H   IIIII   JJJJ    K   K   LLLLL   M   M *
 *                                                                                                        *
 * N   N    OOOOO   PPPPP   QQQQQ   RRRR    SSSSS   TTTTT   U   U   V   V   W   W   X   X   Y   Y   ZZZZZ *
 * NN  N    O   O   P   P   Q   Q   R   R   S         T     U   U   V   V   W   W    X X    Y   Y      Z  *
 * N N N    O   O   PPPPP   Q Q Q   RRRR    SSSSS     T     U   U   VV VV   W W W     X      Y Y      Z   *
 * N  NN    O   O   P       QQQQQ   R  R        S     T     U   U    V V    WW WW    X X      Y      Z    *
 * N   N    OOOOO   P           Q   R   R   SSSSS     T     UUUUU     V     W   W   X   X     Y     ZZZZZ *
 * ****************************************************************************************************** */
