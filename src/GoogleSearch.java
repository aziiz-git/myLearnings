import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver();  // ChromeDriver is a class which is implementing WebDriver interface

		// Open Google
		driver.get("https://www.google.com");

		// Maximize browser

		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("Hello");

		// List <WebElement> myList =
		// driver.findElements(By.xpath("//ul[@role='listbox']//li//span")); // Not
		// working because no WAIT provided

		List<WebElement> myList = new WebDriverWait(driver, 20).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li//span")));

		System.out.println(myList.size());

		for (int i = 0; i < myList.size(); i++) {
			
			System.out.println(myList.get(i).getText());
			
			if (myList.get(i).getText().equals("hello google")) {
				
				myList.get(i).click();
				
				break;  // So that for loop broken after the element is found
				
			}

		}
		
		
		// Another format: 
		
/*		for(WebElement list:motolist)
        {
            String text=list.getText();
            System.out.println(text);
        }*/
		
		

	}
}