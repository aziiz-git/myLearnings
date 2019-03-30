package JavaPracticing;

public class ReverseInteger {

	public static void main(String[] args) {

		int number1 = 123489;

		// First Solution

		int reverse = 0;

		while (number1 != 0) {
			reverse = reverse * 10 + number1 % 10;
			number1 = number1 / 10;
		}

		System.out.println("Reversed Integer: " + reverse);

		// Using StringBuffer method
		
		int number2 = 123489;

		StringBuffer stringBuffer = new StringBuffer(String.valueOf(number2));

		System.out.println(stringBuffer.reverse());
	}
}

// Hello World :)