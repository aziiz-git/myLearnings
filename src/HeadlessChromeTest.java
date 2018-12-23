import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		ChromeOptions myChromeOptions = new ChromeOptions();

		myChromeOptions.addArguments("window-size-1400,800"); // Setting window size. MANDATORY!!

		myChromeOptions.addArguments("headless");

		// Initialize browser
		WebDriver driver = new ChromeDriver(myChromeOptions);

		// Open Google
		driver.get("https://www.google.com");

		// Maximize browser

		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("Hello");

		System.out.println("Page Title: " + driver.getTitle());
	}

}
