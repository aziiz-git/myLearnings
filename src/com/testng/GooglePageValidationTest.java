package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglePageValidationTest {

	WebDriver driver;

	@BeforeMethod()
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test(priority = 3, groups = "Title Test")
	public void googleTitleTest() {
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is " + '"' + pageTitle + '"');
		Assert.assertEquals(pageTitle, "Expected value should be here", "Page Title is not matching :(");
	}
	
	@Test (priority = 1, groups ="Logo Test")
	public void googleLogoTest() {
		boolean googleLogoAvailable = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(googleLogoAvailable);  //  Means, my expectation is to have 'googleLogoAvailable' TRUE
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
