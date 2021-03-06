/**
 *
 *
 */
import java.util.Scanner;

class PokemonSimulatorU2 {

    public static void main(String[] p) {
        title();
        playerMode();
        battle();
    } // End method main

    // Start of program, with choice of whether a new save is created or an existing one is loaded.
    public static void title() {
        print("*****************************\n*   NEW GAME     CONTINUE   *\n*****************************");
        String choice = input("");
        if (choice.matches("NEW GAME|CONTINUE")) {
            if (choice.matches("NEW GAME")) { // Return to main
            } else { // choice.matches("CONTINUE")
                unprogram();
                title();
            }
        } else {
            error();
            title();
        }
    } // End method title

    // Choice of whether to battle against an AI or a second local player.
    public static void playerMode() {
        print("*****************************\n*   VS CPU       VS HUMAN   *\n*****************************");
        String choice = input("");
        if (choice.matches("VS CPU|VS HUMAN")) {
            if (choice.matches("VS CPU")) {
                unprogram();
                playerMode();
            } // else choice.matches("VS HUMAN") ; Return to main
        } else {
            error();
            playerMode();
        }
    } // End method playerMode

    // Displays the battle menu
    public static void battle() {
        // Setting abstract data type
        ally a1  = createAlly ("TORTERRA" , 75, 239, 155, 159, 101);
        ally a2  = createAlly ("INFERNAPE", 75, 211, 173, 123, 179);
        ally a3  = createAlly ("EMPOLEON" , 75, 223, 165, 159, 107);
        ally a4  = createAlly ("CLEFABLE" , 75, 239, 141, 139, 107);
        ally a5  = createAlly ("ALAKAZAM" , 75, 179, 156, 122, 101);
        ally a6  = createAlly ("MAGMORTAR", 75, 209, 182, 138, 141);
        enemy e1 = createEnemy("SPIRITOMB", 74, 169, 153, 178, 68 );
        enemy e2 = createEnemy("ROSERADE" , 74, 184, 161, 143, 102);
        enemy e3 = createEnemy("TOGEKISS" , 76, 228, 147, 177, 139);
        enemy e4 = createEnemy("LUCARIO"  , 76, 203, 187, 123, 153);
        enemy e5 = createEnemy("MILOTIC"  , 74, 236, 135, 168, 136);
        enemy e6 = createEnemy("GARCHOMP" , 78, 268, 180, 157, 176);

        String bag[] = {"MAX POTION", "REVIVE", "POTION", "SHINY STONE", "MAX REVIVE", "SUPER POTION"};

        print("*****************************\n*   FIGHT\t  POKEMON   *\n*    BAG\t   SAVE     *\n*****************************");
        String choice = input("");
        if (choice.matches("FIGHT|POKEMON|BAG|SAVE")) {
            if (choice.matches("FIGHT")) {
                fight();
            } else if (choice.matches("POKEMON")) {
                team(a1, a2, a3, a4, a5, a6);
            } else if (choice.matches("BAG")) {
                  print("------------ BAG ------------");
                  for (int j = 0; j < bag.length; j++) {
                  print("\t" + bag[j]);
              } // BAG NOT FUNCTIONING PROPERLY!!!
                  bag = items(bag);
            } else { //choice.matches("SAVE")
                //save();
                unprogram();
                battle();
            }
        } else {
            error();
            battle();
        }
    } // End method battle

    public static void fight() {
        unprogram();
        // Damage formula
        //int DAMAGE = (2*LEVEL/5+2)*40*ATK/DEF/50+2;
        battle();
    }

    // lists ally team information with level, name and health
    public static void team(ally a1, ally a2, ally a3, ally a4, ally a5, ally a6) {
        print("------- YOUR POKEMON --------");
        print(teamDetail(a1) + "\n" + teamDetail(a2) + "\n" + teamDetail(a3) + "\n" + teamDetail(a4) + "\n" + teamDetail(a5) + "\n" + teamDetail(a6));
        battle();
    }

    // lists items in the bag
    public static String items(String[] bag) {
        String choice = "";
        int j;
        print("*****************************\n*    USE    SORT    BACK    *\n*****************************");
        choice = input("");
        if (choice.matches("USE|SORT|BACK")) {
            if (choice.matches("USE")) {
                unprogram();
                items(bag);
            } else if (choice.matches("SORT")) {
                sortItems(bag);
            } else { // choice.matches("BACK");
                battle();
            }
        }
        return bag[j];
    } // End method items

    // Method that sorts the bag in alphabetical order
    public static String sortItems(String[] bag) {
        print("----- BAG ALPHABETICAL ------");
        String temp;
        int j;
        for (j = 0; j < bag.length; j++) {
            for (int i = j + 1; i < bag.length; i++) {
                // Compares adjacent strings
                if (bag[i].compareTo(bag[j]) < 0) {
                    temp = bag[j];
                    bag[j] = bag[i];
                    bag[i] = temp;
                }
            }
           System.out.println("\t" + bag[j]);
        }
        items(bag);
        return bag[j];
    } // End method sortItems

    /**
     * METHODS USED TO SIMPLIFY CODE BY USING KEYWORDS
     */

    // A generic error message to be printed if an input is not valid.
    public static void error() {
        print("THIS IS NOT A VALID INPUT");
    }

    // A generic message to be printed if an option that has not yet been programmed is selected.
    // The program will be forced to terminate.
    public static void unprogram() {
        print("*****************************\n* THIS FEATURE HAS NOT BEEN *\n*IMPLEMENTED IN THIS VERSION*\n*****************************");
    }

    // Ask for a string with message ">>> CHOOSE AN OPTION"; will overwrite any message printed in the input.
    // toUpperCase forces an input to be capitals, allowing lowercase input by the user.
    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        print(">>> CHOOSE AN OPTION");
        String userInput = scan.nextLine();
        return userInput.toUpperCase();
    }

    // Print message to the screen
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * ADT METHODS
     */

    // Creating ally abstract data type
    public static ally createAlly(String allyName, int allyLV, int allyHP, int allyATK, int allyDEF, int allySPD) {
        ally a = new ally();
        a.name = allyName;
        a.LV = allyLV;
        a.HP = allyHP;
        a.ATK = allyATK;
        a.DEF = allyDEF;
        a.SPD = allySPD;
        return a;
    }

    // Creating enemy abstract data type
    public static enemy createEnemy(String enemyName, int enemyLV, int enemyHP, int enemyATK, int enemyDEF, int enemySPD) {
        enemy e = new enemy();
        e.name = enemyName;
        e.LV = enemyLV;
        e.HP = enemyHP;
        e.ATK = enemyATK;
        e.DEF = enemyDEF;
        e.SPD = enemySPD;
        return e;
    }

    // Accessor methods for ally and enemy ADT
    public static String getAllyName  (ally a)  { return a.name; }
    public static int    getAllyLV    (ally a)  { return a.LV;   }
    public static int    getAllyHP    (ally a)  { return a.HP;   }
    public static int    getAllyATK   (ally a)  { return a.ATK;  }
    public static int    getAllyDEF   (ally a)  { return a.DEF;  }
    public static int    getAllySPD   (ally a)  { return a.SPD;  }

    public static String getEnemyName (enemy e) {return e.name;  }
    public static int    getEnemyLV   (enemy e) {return e.LV;    }
    public static int    getEnemyHP   (enemy e) {return e.HP;    }
    public static int    getEnemyATK  (enemy e) {return e.ATK;   }
    public static int    getEnemyDEF  (enemy e) {return e.DEF;   }
    public static int    getEnemySPD  (enemy e) {return e.SPD;   }

    // Returns a readable string
    public static String teamDetail(ally a) {
        return "Lv." + getAllyLV(a) + "\t" + getAllyName(a) + "\t" + getAllyHP(a) + "HP";
    }
} // End class PokemonSimulator

// Abstract Data Type classes
class ally {
    String name;
    int LV;
    int HP;
    int ATK;
    int DEF;
    int SPD;
}

class enemy {
    String name;
    int LV;
    int HP;
    int ATK;
    int DEF;
    int SPD;
}

/**
 * GUI
 * ****************************
 * NEW GAME     CONTINUE   *
 * ****************************
 * ****************************
 * VS CPU       VS HUMAN   *
 * ****************************
 * ****************************
 * FIGHT         POKEMON   *
 * BAG           SAVE     *
 * ****************************
 * ------- YOUR POKEMON --------
 * ------------ BAG ------------
 * ----- BAG ALPHABETICAL ------
 * ****************************
 * USE    SORT    BACK    *
 * ****************************
 * ****************************
 * THIS FEATURE HAS NOT BEEN *
 * IMPLEMENTED IN THIS VERSION*
 * ****************************
 */
