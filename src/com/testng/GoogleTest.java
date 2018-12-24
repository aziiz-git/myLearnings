package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

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

	@Test
	public void googleTitleTest() {
		String pageTitle = driver.getTitle();
		System.out.println("Page title is " + '"' + pageTitle + '"');
	}

	@Test
	public void googleLogoTest() {
		boolean googleLogoAvailable = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		if (googleLogoAvailable = true) {
			System.out.println("The Image is available");
		} else {
			System.out.println("The Image is not available");
		}
	}

	@Test
	public void gmailLinktest() {
		boolean gmailLinkAvailable = driver
				.findElement(By.xpath("//a[@class='gb_P' and @href='https://mail.google.com/mail/?tab=wm']"))
				.isDisplayed();
		if (gmailLinkAvailable = true) {
			System.out.println("The Link is available");
		} else {
			System.out.println("The Link is not available");
		}
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
