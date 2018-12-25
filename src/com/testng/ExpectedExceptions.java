package com.testng;

import org.testng.annotations.Test;

public class ExpectedExceptions {

	@Test (expectedExceptions = ArithmeticException.class) // I'm expecting this Exception. Please don't mark my test
															// case as Failed.
	public void expectedExceptionsTestOne() {
		int num1 = 30, num2 = 0;
		int output = num1 / num2;
		System.out.println("Result: " + output);
	}

	@Test (expectedExceptions = NumberFormatException.class)  // Both the @Test would pass :)
	public void expectedExceptionsTestTwo() {
		String x = "Azeez";
		Integer.parseInt(x);  // Cannot convert Azeez to Integer
	}
}
