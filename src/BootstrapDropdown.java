import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();

		// Open Google
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");

		// Maximize browser

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle' and @id='menu1']")).click();

		List<WebElement> myBootstrapDropdown = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//div[@class = 'dropdown open']//ul[@role='menu']//li//a")));

		// div[@class = 'dropdown
		// open']//ul[@role='menu']//li[@role='presentation']/a[contains(text(),'HTML')]

		System.out.println(myBootstrapDropdown.size());

		for (int i = 0; i < myBootstrapDropdown.size(); i++) {

			System.out.println(myBootstrapDropdown.get(i).getText());

			if (myBootstrapDropdown.get(i).getText().equals("CSS")) {

				myBootstrapDropdown.get(i).click();

				break; // So that for loop broken after the element is found

			}
		}
	}
}
