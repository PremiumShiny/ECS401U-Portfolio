import java.util.Scanner;
import java.util.Arrays;

class NextAbs {
	public static void main (String[] param) {
        print("TEST_MAIN");
		method1();
		System.exit(0);
	}
	public static void method1() {
        print("TEST_M1");
		adt myADT[] = fruit();
		print(toString(myADT));
	}
	public static adt[] fruit() {
        print("TEST_FRUIT");
		adt[] resultPackage = new adt[3];
		adt a1 = createadt("player1", false);
		adt a2 = createadt("player2", true);
        adt a3 = createadt("player3", true);
		resultPackage[0] = a1;
		resultPackage[1] = a2;
        resultPackage[2] = a3;
		return resultPackage;
	}
	public static String toString(adt[] arr){
        print("TEST_TOSTRING");
		String str = "";
        String booltest;
		for (adt item : arr){
            if (getBool(item) == true) {
                booltest = "is alive";
            } else {
                booltest = "is dead";
            }
			str +=   getName(item) + "\t" + booltest + "\n";
		}
		return str;
	}
	public static String input(String message){
		Scanner scan = new Scanner(System.in);
		String userInput;
		print(message);
		return scan.nextLine();
	}
	public static void print(String message){
		System.out.println(message);
	}
	public static adt createadt (String adtName, boolean adtBool){
        print("TEST_CREATE");
		adt a = new adt();
		a.name = adtName;
		a.bool = adtBool;
		return a;
	}
	public static String getName (adt a){
	   return a.name;
	}
	public static boolean getBool(adt a){
		return a.bool;
	}
	public static String adtString (adt a){
		if (getBool(a)){
			return getName(a) + " is alive."; //banana is good.
		}
		else{
			return getName(a) + " is dead."; //apple is bad.
		}
	}
}
class adt{
	String name;
	boolean bool;
}
