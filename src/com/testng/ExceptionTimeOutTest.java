package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	@Test (timeOut = 2000)   // This test case should get executed in 2 seconds. That is the max time I'm giving.
	public void infiniteLoopTest() {
		int i = 1;
		while (i==1) {
			System.out.println(i);
		}
	}

}
