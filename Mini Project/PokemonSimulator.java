/**
 * FILE:    PokemonSimulator.java
 * AUTHOR:  Richard Cheung
 * DATE:    9 December 2019
 * USE:     Recreates battle simulator from Pokemon
 * DESC:    Uses multiple different techniques combined into one program
 */

import java.util.Scanner;

class PokemonSimulator {

    public static void main(String[] param) {
        title();
        playerMode();
        initialBattle();
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
            if (choice.matches("VS HUMAN")) {
                unprogram();
                playerMode();
            } // else choice.matches("VS CPU") ; Return to main
        } else {
            error();
            playerMode();
        }
    } // End method playerMode

    public static void initialBattle() {
        // Setting abstract data type
        ally a1  = createAlly ("TORTERRA" , 75, 239, 155, 159, 101);
        enemy e1 = createEnemy("SPIRITOMB", 74, 169, 153, 178, 68 );

        print("\nYOU send out " + getAllyName(a1) + "!\nCYNTHIA sends out " + getEnemyName(e1) + "!\n");
        battle(a1, e1);
    } // End method initialBattle

    // Displays the battle menu
    public static void battle(ally a1, enemy e1) {
        print("*****************************\n*   FIGHT\t  POKEMON   *\n*    BAG\t   SAVE     *\n*****************************");
        String choice = input("");
        if (choice.matches("FIGHT|POKEMON|BAG|SAVE")) {
            if (choice.matches("FIGHT")) {
                fight(a1, e1);
            } else if (choice.matches("POKEMON")) {
                team(a1, e1);
            } else if (choice.matches("BAG")) {
                items(a1, e1);
            } else { //choice.matches("SAVE")
                //save();
                unprogram();
                battle(a1, e1);
            }
        } else {
            error();
            battle(a1, e1);
        }
    } // End method battle

    public static void fight(ally a1, enemy e1) {
        int allyHP = getAllyHP(a1);
        int enemyHP = getEnemyHP(e1);
        while (allyHP > 0 & enemyHP > 0) {
            System.out.println(getEnemyName(e1) + " deals " + enemyDamage(a1, e1) + " damage.");
            enemyHP = enemyHP - allyDamage(a1, e1);
            if (allyHP <= 0) {
                System.out.println(getAllyName(a1) + " has fainted.");
                break;
            }
            System.out.println(getAllyName(a1) + " has " + allyHP + "HP remaining.\n");

            System.out.println(getAllyName(a1) + " deals " + allyDamage(a1, e1) + " damage.");
            allyHP = allyHP - enemyDamage(a1, e1);
            if (enemyHP <= 0) {
                System.out.println(getEnemyName(e1) + " has fainted.");
                break;
            }
            System.out.println(getEnemyName(e1) + " has " + enemyHP + "HP remaining.\n");
        }
    } // End method fight

    // lists ally team information with level, name and health
    public static void team(ally a1, enemy e1) {
        print("------- YOUR POKEMON --------");
        print(teamDetail(a1));
        battle(a1, e1);
    } // End method team

    // lists items in the bag
    public static void items(ally a1, enemy e1) {
        String bag[] = {"MAX POTION", "REVIVE", "POTION", "SHINY STONE", "MAX REVIVE", "SUPER POTION"};
        String choice = "";

        print("------------ BAG ------------");
        for (int j = 0; j < bag.length; j++) {
            print("\t" + bag[j]);
        }
        print("*****************************\n*    USE    SORT    BACK    *\n*****************************");
        choice = input("");
        if (choice.matches("USE|SORT|BACK")) {
            if (choice.matches("USE")) {
                unprogram();
                items(a1, e1);
            } else if (choice.matches("SORT")) {
                sortItems(bag, a1, e1);
            } else { // choice.matches("BACK");
                battle(a1, e1);
            }
        }
    } // End method items

    // Method that sorts the bag in alphabetical order
    public static void sortItems(String[] bag, ally a1, enemy e1) {
        print("----- BAG ALPHABETICAL ------");
        String temp;
        for (int j = 0; j < bag.length; j++) {
       	    for (int i = j + 1; i < bag.length; i++) {
    		    // Compares adjacent strings
        		if (bag[i].compareTo(bag[j]) < 0) {
        			temp   = bag[j];
        			bag[j] = bag[i];
        			bag[i] = temp;
        		}
    	    }
    	   System.out.println("\t" + bag[j]);
    	}
        items(a1, e1);
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
        a.LV   = allyLV;
        a.HP   = allyHP;
        a.ATK  = allyATK;
        a.DEF  = allyDEF;
        a.SPD  = allySPD;
        return a;
    }

    // Creating enemy abstract data type
    public static enemy createEnemy(String enemyName, int enemyLV, int enemyHP, int enemyATK, int enemyDEF, int enemySPD) {
        enemy e = new enemy();
        e.name  = enemyName;
        e.LV    = enemyLV;
        e.HP    = enemyHP;
        e.ATK   = enemyATK;
        e.DEF   = enemyDEF;
        e.SPD   = enemySPD;
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

    // Returns a readable string detailing team HP
    public static String teamDetail(ally a) {
        return "Lv." + a.LV + "\t" + a.name + "\t" + a.HP + "HP";
    }

    public static int allyDamage(ally a1, enemy e1) {
        int LEVEL  = getAllyLV(a1);   //PLACEHOLDER
        int ATK    = getAllyATK(a1);  //PLACEHOLDER
        int DEF    = getEnemyDEF(e1);  //PLACEHOLDER
        int DAMAGE = (2*LEVEL/5+2)*40*ATK/DEF/50+2;
        return DAMAGE;
    }

    public static int enemyDamage(ally a1, enemy e1) {
        int LEVEL  = getEnemyLV(e1);   //PLACEHOLDER
        int ATK    = getEnemyATK(e1);  //PLACEHOLDER
        int DEF    = getAllyDEF(a1);  //PLACEHOLDER
        int DAMAGE = (2*LEVEL/5+2)*40*ATK/DEF/50+2;
        return DAMAGE;
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
 *    NEW GAME     CONTINUE   *
 * ****************************
 * ****************************
 *    VS CPU       VS HUMAN   *
 * ****************************
 * ****************************
 *    FIGHT         POKEMON   *
 *     BAG           SAVE     *
 * ****************************
 * ------- YOUR POKEMON --------
 * ------------ BAG ------------
 * ----- BAG ALPHABETICAL ------
 * ****************************
 *     USE    SORT    BACK    *
 * ****************************
 * ****************************
 *  THIS FEATURE HAS NOT BEEN *
 * IMPLEMENTED IN THIS VERSION*
 * ****************************
 */
