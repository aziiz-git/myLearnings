package javaPracticing;

public class SwapIntegersWithoutUsingThirdVariable {

	public static void main(String[] args) {

		int x = 2;
		int y = 9;

		System.out.println(":::::: METHOD 1::::::");

		System.out.println("Before ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		x = x + y; // x = 2 + 9 = 11
		y = x - y; // y = 11 - 9 = 2
		x = x - y; // x = 11 - 2 = 9

		System.out.println("\nAfter ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		System.out.println("\n\n::::::METHOD 2::::::");

		System.out.println("Before ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		x = x * y; // x = 9 * 2 = 18
		y = x / y; // y = 18 / 2 = 9
		x = x / y; // x = 18 / 9 = 2

		System.out.println("\nAfter ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		System.out.println("\n\n::::::METHOD 3::::::");

		System.out.println("Before ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		x = x ^ y; // x = 2 = 10 ; y = 9 = 1001
		y = x ^ y;
		x = x ^ y;
		
		System.out.println("\nAfter ::: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

	}
}