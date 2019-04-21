package javaPracticing;

public class ReverseString {

	public static void main(String[] args) {

		/* Method1: The Normal/Simple way */

		String myString = "Selenium";

		int length = myString.length(); // Length will be seven. That is zero to eight.
		String reverse = ""; // Blank

		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + myString.charAt(i);
		}

		System.out.println(reverse);

		/* Another Method: Using String Buffer */

		StringBuffer stringBuffer = new StringBuffer(myString);

		System.out.println(stringBuffer.reverse());

	}

}
