import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrritatingChat {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();

		// Open FreeCRM
		driver.get("https://techtrunk.in/");

		// Maximize browser

		driver.manage().window().maximize();

		driver.switchTo().frame("tidio-chat-iframe");

		System.out.println("Passed");

		Actions myaction = new Actions(driver);
		myaction.moveToElement(driver.findElement(By.id("button-body"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("ic_close")).click();

	}

}
