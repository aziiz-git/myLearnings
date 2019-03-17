package ScreenshotForFailed;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;

	public static void initialization() { // Normal stuffs
		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); // ChromeDriver is a class which is implementing WebDriver interface
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	public void takeScreenshot(String testMethodNameForScreenshoFile) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("C:\\Dev\\Eclipse\\Learning\\src\\ScreenshotForFailed\\Screenshots\\TestFailed_" + testMethodNameForScreenshoFile + "_" + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}