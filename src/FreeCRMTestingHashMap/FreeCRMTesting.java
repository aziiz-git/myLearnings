package FreeCRMTestingHashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTesting {

	WebDriver driver;
	public String credentials; // Declared public
	public String credentialsInfo[];
	public String monthAndDaySelect;
	public String monthAndDaySelectInfo[];

	public static HashMap getUserLoginInfo() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("Azeez", "aziizpc@gmail.com_test123");
		userMap.put("Admin", "adminuser_test@123");
		return userMap; // Returning HashMap
	}

	public static HashMap monthMap() {
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(1, "January_22");
		monthMap.put(2, "February_4");
		monthMap.put(3, "March_3");
		monthMap.put(4, "April_21");
		monthMap.put(5, "May_28");
		monthMap.put(6, "June_14");
		monthMap.put(7, "July_8");
		monthMap.put(8, "August_12");
		monthMap.put(9, "September_21");
		monthMap.put(10, "October_22");
		monthMap.put(11, "November_11");
		monthMap.put(12, "December_10");
		return monthMap;
	}

	public static void clickable(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void visible(WebDriver driver, By by, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated((By) by));
	}

	public String getMonth() {
		String currentMonthAndYearArray[];
		String currentMonthAndYear = driver.findElement(By.xpath("//div[@class = 'rbc-calendar']/div/span[2]"))
				.getText();
		currentMonthAndYearArray = currentMonthAndYear.split(" ");
		System.out.println("Current month is " + currentMonthAndYearArray[0]);
		return currentMonthAndYearArray[0];
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com/");
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		clickable(driver, driver.findElement(By.xpath("//a[@href = 'https://ui.cogmento.com']")), 800);
		driver.findElement(By.xpath("//a[@href = 'https://ui.cogmento.com']")).click();
	}

	@Test(priority = 1)
	public void loginWithAzeezTest1() throws IOException, InterruptedException {
		credentials = (String) FreeCRMTesting.getUserLoginInfo().get("Azeez");
		credentialsInfo = credentials.split("_"); // Note that just credentialsInfo and not credentialsInfo[]

		visible(driver, By.xpath("//div[@class = 'field']/div/input[@name = 'email']"), 800);

		driver.findElement(By.xpath("//div[@class = 'field']/div/input[@name = 'email']")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.xpath("//div[@class = 'field']/div/input[@name = 'password']"))
				.sendKeys(credentialsInfo[1]);
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
		driver.findElement(By.xpath("//div[@id = 'main-nav']/a/span[text()='Calendar']")).click();

		System.out.println("Enter a Month: ");

		Scanner user_input = new Scanner(System.in);
		String myMonth;
		myMonth = user_input.next();
		user_input.close();

		if (myMonth != getMonth()) {
			for (int i = 0; i < 12; i++) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button/i[@class = 'chevron right icon']")).click();
				if (myMonth.equals(getMonth()))
					break;
			}
		}
		
		System.out.println("Testing :)");
		
		monthAndDaySelect = (String) FreeCRMTesting.monthMap().get(myMonth); // There is a problem with the setup. Ignore the Calendar part :)
		monthAndDaySelectInfo = monthAndDaySelect.split("_");

		driver.findElement(By.xpath("//div[@class = 'rbc-date-cell']/a[text() , "+monthAndDaySelectInfo[1]+"]")).click();
		
		System.out.println("Clicked on " + monthAndDaySelectInfo[1] + " " + monthAndDaySelectInfo[0]);
		
		Thread.sleep(10000);

	}

	@Test(priority = 2)
	public void loginWithAzeezTest2() { // Did this because I have just onee ID in freecrm
		credentials = (String) FreeCRMTesting.getUserLoginInfo().get("Azeez");
		credentialsInfo = credentials.split("_");
		driver.findElement(By.xpath("//div[@class = 'field']/div/input[@name = 'email']")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.xpath("//div[@class = 'field']/div/input[@name = 'password']"))
				.sendKeys(credentialsInfo[1]);
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
		driver.findElement(By.xpath("//div[@id = 'main-nav']/a/span[text()='Calendar']")).click();		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
