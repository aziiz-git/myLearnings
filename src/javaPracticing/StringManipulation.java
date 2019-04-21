package javaPracticing;

public class StringManipulation {

	public static void main(String[] args) {

		String str = "The rains have started here !!!";
		String strNew = "THE rains have started here !!!";

		System.out.println("Length of the String: " + str.length()); // .size() is for ArrayList/ list objects

		System.out.println("Character at 10th index: " + str.charAt(10)); // Starts from 1. Whitespace NOT counted

		System.out.println("What is the index of s: " + str.indexOf('s')); // Single quotes. The first occurence
																			// considered.

		System.out.println("What is the index of second occurence of s: " + str.indexOf('s', str.indexOf('s') + 1)); // Third
																														// can
																														// also
																														// be
																														// found
																														// out
																														// occurence
																														// similarly.

		System.out.println("What is the index of have: " + str.indexOf("have")); // Double Quotes

		System.out.println("What is the index of missing: " + str.indexOf("missing")); // Returns -1

		// String Comparison:
		System.out.println("Are the Strings same (Case-sensitive): " + str.equals(strNew));
		System.out.println("Are the Strings same (Not case-sensitive): " + str.equalsIgnoreCase(strNew));

		// Get a Substring:
		System.out.println("Get a Substring: " + str.substring(0, 8)); // beginIndex and endIndex. 0 to 9 but 9th
																		// excluded.

		// Trim:
		String myString = "     Hello   World     ";
		System.out.println("'trim()' removes Before space and After space: " + myString.trim());
		System.out.println("Replacing: " + myString.replace(" ", ""));

		// Split:
		String myStringNew = "Hello_World_Test_Selenium";
		String splittedMyStringNew[] = myStringNew.split("_");
		for (int i = 0; i < splittedMyStringNew.length; i++) {
			System.out.println("Splitted " + i + " :" + splittedMyStringNew[i]);
		}
		
		// Concat:
		System.out.println("Concatenation: " + str.concat(" Hello World !!!"));
		
		// + Operator:
		String x = "Hello";
		String y = "World";
		int a = 100;
		int b = 200;
		System.out.println("+ Operator (String + String + int + int): "+ (x+y+a+b));
		System.out.println("+ Operator (String + String + (int + int)): "+ (x+y+(a+b)));
	}
}