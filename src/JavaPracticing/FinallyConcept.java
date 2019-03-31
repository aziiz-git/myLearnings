package JavaPracticing;

public class FinallyConcept {

	public static void main(String[] args) {
		System.out.println("Calling test1() method");
		test1();
		System.out.println("\nCalling test2() method");
		test2();
		System.out.println("\nCalling division1() method -> Correct Exception in catch");
		division1();
		System.out.println("\nCalling division2() method -> Incorrect Exception in catch");
		division2();
	}

	public static void test1() {

		try {
			System.out.println("Inside test1() try block");
			throw new RuntimeException("Test");
		} catch (Exception e) {
			System.out.println("Inside test1() catch block");
		} finally { // reserve k/w used to associate with try-catch block. 'finally' block would be
					// executed after try-catch. Doesn't matter if exception is coming or not.
			System.out.println("Inside test1() finally block");
		}
	}

	public static void test2() {

		try {
			System.out.println("Inside test2() try block");
		} finally {		// Doesn't matter if exception is coming or not.
			System.out.println("Inside test2() finally block");
		}
	}
	
	public static void division1() {
		int i = 10;
		try {
			System.out.println("Inside division1() try block");
			int k = i / 0; // Arithmetic Exception 
		}
		catch(ArithmeticException e) {
			System.out.println("Inside division1() catch block");
			System.out.println("Divide by zero error");
		}
		finally {
			System.out.println("Execute this code even after any Exception");
		}
	}
	
	public static void division2() {
		int i = 10;
		try {
			System.out.println("Inside division2() try block");
			int k = i / 0; // Arithmetic Exception 
		}
		catch(NullPointerException e) {
			System.out.println("Inside division2() catch block");
			System.out.println("This will not be printed as Exception is wrong");
		}
		finally {
			System.out.println("Execute this code even if wrong Exception in catch block");
		}
	}
}