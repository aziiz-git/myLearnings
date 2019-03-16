package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import RetryAnalyzer.RetryAnalyzer;

public class RetryLogicTestNG {
	
	@Test //(retryAnalyzer = RetryAnalyzer.class)   // The class name. See import as well. This is used when we use only 'RetryAnalyzer.java class and not MyTransformer.java class.
	public void Test1() {
		
		Assert.assertEquals(false, true);
		
	}
	
	@Test
	public void Test2() {
		
		Assert.assertEquals(false, true);
		
	}	
	
}