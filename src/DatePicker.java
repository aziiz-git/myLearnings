import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();

		// Open Google
		driver.get("http://www.nsftools.com/tips/DatePickerTest.htm");

		// Maximize browser

		driver.manage().window().maximize();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.print("Enter Day: ");
		
		int myDay = input.nextInt();

		driver.findElement(By.xpath("//form[1]//input[2]")).click();

		driver.findElement(By.xpath("//table[@class='dpTable']//td[contains(text(), "+myDay+")]")).click();

	}  // See the double quotes in the XPATH
}
