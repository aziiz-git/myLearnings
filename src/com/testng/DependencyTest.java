package com.testng;

import org.testng.annotations.Test;

public class DependencyTest {
	
	@Test
	public void loginTest() {
		System.out.println("Function 1: This is the First Function !!");
		// int i = 9 / 0;  Keep this step to see @Test (dependsOnMethods = "loginTest") failing
	}
	
	@Test (dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("Function 2: Depndent on Function 1. This method would be executed only if the method " + '"' + "loginTest()" + '"' + " is passed !!");		
	}

}
