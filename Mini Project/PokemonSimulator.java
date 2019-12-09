/**
 *
 *
 */
import java.util.Scanner;

class PokemonSimulator {

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
            if (choice.matches("VS HUMAN")) {
                unprogram();
                playerMode();
            } // else choice.matches("VS CPU") ; Return to main
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

        print("\nYOU send out " + a1.name + "!\nCYNTHIA sends out " + e1.name + "!\n");

        print("*****************************\n*   FIGHT\t  POKEMON   *\n*    BAG\t   SAVE     *\n*****************************");
        String choice = input("");
        if (choice.matches("FIGHT|POKEMON|BAG|SAVE")) {
            if (choice.matches("FIGHT")) {
                fight(a1, e1, a2, e2, a3, e3, a4, e4, a5, e5, a6, e6);
            } else if (choice.matches("POKEMON")) {
                team(a1, a2, a3, a4, a5, a6);
            } else if (choice.matches("BAG")) {
                items();
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

    public static void fight(ally a1, enemy e1, ally a2, enemy e2, ally a3, enemy e3, ally a4, enemy e4, ally a5, enemy e5, ally a6, enemy e6) {
        while (a1.HP > 0 && e1.HP > 0) {
            System.out.println(a1.name + " has " + a1.HP + "HP remaining.\n");
            a1.HP = a1.HP - damage(a1, e1);
            System.out.println(a1.name + " deals " + damage(a1, e1) + "damage.");
            if (e1.HP <= 0) {
                System.out.println(e1.name + " has fainted.");
            }

            System.out.println(e1.name + " has " + e1.HP + "HP remaining.\n");
            e1.HP = e1.HP - damage(a1, e1);
            System.out.println(e1.name + " deals " + damage(a1, e1) + "damage.");
            if (a1.HP <= 0) {
                System.out.println(a1.name + " has fainted.");
            }
        }
    }

    // lists ally team information with level, name and health
    public static void team(ally a1, ally a2, ally a3, ally a4, ally a5, ally a6) {
        print("------- YOUR POKEMON --------");
        print(teamDetail(a1) + "\n" + teamDetail(a2) + "\n" + teamDetail(a3) + "\n" + teamDetail(a4) + "\n" + teamDetail(a5) + "\n" + teamDetail(a6));
        battle();
    }

    // lists items in the bag
    public static void items() {
        String bag[] = {"MAX POTION", "REVIVE", "POTION", "SHINY STONE", "MAX REVIVE", "SUPER POTION"};
        String choice = "";

        print("------------ BAG ------------");
        for (int i = 0; i < bag.length; i++) {
            print("\t" + bag[i]);
        }
        print("*****************************\n*    USE    SORT    BACK    *\n*****************************");
        choice = input("");
        if (choice.matches("USE|SORT|BACK")) {
            if (choice.matches("USE")) {
                unprogram();
                items();
            } else if (choice.matches("SORT")) {
                sortItems(bag);
            } else { // choice.matches("BACK");
                battle();
            }
        }
    } // End method items

    // Method that sorts the bag in alphabetical order
    public static void sortItems(String[] bag) {
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
        items();
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

    public static int damage(ally a1, enemy e1) {
        int LEVEL  = a1.LV;   //PLACEHOLDER
        int ATK    = a1.ATK;  //PLACEHOLDER
        int DEF    = e1.DEF;  //PLACEHOLDER
        int DAMAGE = (2*LEVEL/5+2)*40*ATK/DEF/50+2;
        return DAMAGE;
    }

    /* Methods to set the current Pokemon in rotation
    public static String nextAlly (ally a) {
        String nextAlly = getAlly(a1);
             if (getAllyHP(a1) == 0) { nextAlly = getAlly(a2); }
        else if (getAllyHP(a2) == 0) { nextAlly = getAlly(a3); }
        else if (getAllyHP(a3) == 0) { nextAlly = getAlly(a4); }
        else if (getAllyHP(a4) == 0) { nextAlly = getAlly(a5); }
        else if (getAllyHP(a5) == 0) { nextAlly = getAlly(a6); }
    }

    public static String nextAlly (enemy e) {
        String nextEnemy = getEnemy(e1);
             if (getEnemyHP(e1) == 0) { nextEnemy = getEnemy(e2); }
        else if (getEnemyHP(e2) == 0) { nextEnemy = getEnemy(e3); }
        else if (getEnemyHP(e3) == 0) { nextEnemy = getEnemy(e4); }
        else if (getEnemyHP(e4) == 0) { nextEnemy = getEnemy(e5); }
        else if (getEnemyHP(e5) == 0) { nextEnemy = getEnemy(e6); }
    } */
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
