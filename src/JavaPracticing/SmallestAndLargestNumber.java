package JavaPracticing;

import java.util.Arrays;

public class SmallestAndLargestNumber {

	public static void main(String[] args) {

		int numbers[] = { -22, -11, -33, 0, 1, 180, 30, -88, 90, 100 };

		int largest = numbers[0];
		int smallest = numbers[0];

		for (int i = 1; i < numbers.length; i++)  // FOR LOOP ITERATION FROM 1 (NOT ZERO)
			if (numbers[i] > largest) {
				largest = numbers[i];
			} else if (numbers[i] < smallest) {
				smallest = numbers[i];
			}
		
		System.out.println("Given array is: "+ Arrays.toString(numbers));

		System.out.println("Largest Number: " + largest);
		System.out.println("Smallest Number: " + smallest);
	}
}
