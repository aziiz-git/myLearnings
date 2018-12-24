package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	@BeforeSuite // 1
	public void setUp() {
		System.out.println("SUITE Starts: Setup System Property for Chrome");
	}

	@BeforeTest // 2
	public void launchBrowser() {
		System.out.println("Before Test: Launch the Browser");
	}

	@BeforeClass // 3
	public void login() {
		System.out.println("Before Class: Login to App");
	}

	@BeforeMethod // 4
	public void enterURL() {
		System.out.println("Before Method: Enter URL");
	}

	@Test // 5a
	public void searchTest() {
		System.out.println("Test 1: Google Search");
	}

	@Test // 5b
	public void googleTitleTest() {
		System.out.println("Test 2: Google Title Test");
	}

	@AfterMethod // 6
	public void logOut() {
		System.out.println("After Method: After Method: Logout from App");
	}

	@AfterClass // 7
	public void deleteAllCookies() {
		System.out.println("After Class: After Class:Delete all Cookies");
	}

	@AfterTest // 8
	public void closeBrowser() {
		System.out.println("After Test: Close Browser");
	}

	@AfterSuite // 9
	public void generateTestReport() {
		System.out.println("SUITE Ends: Generate Test Report");
	}

	/*
	 * Output: SUITE Starts: Setup System Property for Chrome Before Test: Launch
	 * the Browser Before Class: Login to App Before Method: Enter URL Test 2:
	 * Google Title Test After Method: After Method: Logout from App Before Method:
	 * Enter URL Test 1: Google Search After Method: After Method: Logout from App
	 * After Class: After Class:Delete all Cookies After Test: Close Browser PASSED:
	 * googleTitleTest PASSED: searchTest SUITE Ends: Generate Test Report
	 */

}