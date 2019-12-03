import java.util.Scanner;
import java.util.Arrays;

class fruitsbroken{

	public static void main (String[] p){
		method1();
		print("TEST");
		System.exit(0);
	}

	public static void method1(){
		adt myADT[] = fruit();
		print(toString(myADT));
	}

	public static adt createadt (String adtName, boolean adtBool){
		adt a = new adt();
		a.name = adtName;
		a.bool = adtBool;
		return a;
	}

	public static String toString(adt[] arr){
		String str = "";
		for (adt item : arr){
			str +=   "[" + getName(item) + "," + getBool(item) + "]";
		}
		return str;
	}

	public static String getName (adt a){
	   return a.name;
	}
	public static boolean getBool(adt a){
		return a.bool;
	}

	public static String adtString (adt a){
		if (getBool(a)){
			return getName(a) + " is good."; //banana is good.
		}
		else{
			return getName(a) + " is bad."; //apple is bad.
		}
	}

	public static adt[] fruit(){
		adt[] resultPackage = new adt[2];
		adt a1 = createadt("apple", false);
		adt a2 = createadt("banana", true);
		resultPackage[0] = a1;
		resultPackage[1] = a2;
		return resultPackage;
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
}

class adt{
	String name;
	boolean bool;
}

/*
	public static void method1(){
		adt myADT[] = fruit();
		System.out.print(myADT);
	}
	RESULT:
	[Ladt;@54bedef2

	public static void method1(){
		adt myADT[] = fruit();
		print(Arrays.toString(myADT));
	}
	RESULT:
	[adt@54bedef2, adt@5caf905d]
*/
