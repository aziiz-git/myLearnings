package javaPracticing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeOrNot {

	public static void main(String[] args) {

		try {
			BufferedReader object = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Input number: ");
			int inputValue = Integer.parseInt(object.readLine());
			int n = inputValue;
			int rev = 0;
			System.out.println("Input value is : ");
			System.out.println(" " + inputValue);

			for (int i = 0; i <= inputValue; i++) { // Example 121			12				1
				int r = inputValue % 10;			// r = 121 % 10 = 1		12 % 10 = 2		1 % 10 = 1	
				inputValue = inputValue / 10;		// iV = 121/10 = 12		12/10 = 1 		1 / 10 = 0
				rev = rev * 10 + r;					// rev = 0 + 1 = 1		10 + 2 = 12		120 + 1 = 121
				i = 0;								// i = 0				0				0
			}

			System.out.println("Post reversal : " + " ");
			System.out.println(" " + rev);

			if (n == rev) {
				System.out.print("Input value is a palindrome.");
			} else {
				System.out.println("Input value is not a palindrome.");
			}

		} catch (Exception e) {
			System.out.println("Out of Range.");
		}
	}
}