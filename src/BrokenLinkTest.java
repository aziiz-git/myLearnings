import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, IOException, MalformedURLException, UnknownHostException {
		System.setProperty("webdriver.chrome.driver", "D:\\Azeez\\Dev\\Drivers\\chromedriver.exe");

		// Initialize browser
		WebDriver driver = new ChromeDriver(); // ChromeDriver is a class which is implementing WebDriver interface

		// Open FreeCRM
		driver.get("https://www.freecrm.com/index.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("aziizpc");
		driver.findElement(By.name("password")).sendKeys("test123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type = 'submit']")).click();

		driver.switchTo().frame("mainpanel");

		List <WebElement> linksOnThePage = driver.findElements(By.tagName("a")); // Step 1
		linksOnThePage.addAll(driver.findElements(By.tagName("img"))); // Step 2

		System.out.println("Size of all the Links and Images: " + linksOnThePage.size());

		List <WebElement> activeLinks = new ArrayList <WebElement>(); // Step 3

		for (int i = 0; i < linksOnThePage.size(); i++) { // Step 4
			// System.out.println(linksOnThePage.get(i).getAttribute("href")); // To view
			// all the links (href)
			if (linksOnThePage.get(i).getAttribute("src") != null) {
				System.out.println(linksOnThePage.get(i).getAttribute("src"));
			}

			/*
			 * System.out.println("Searching for Images with link ... " +
			 * ((linksOnThePage.get(i).getAttribute("src") != null) ?
			 * linksOnThePage.get(i).getAttribute("src") : "No Image with link"));
			 */

			if (linksOnThePage.get(i).getAttribute("href") != null
					&& (!linksOnThePage.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksOnThePage.get(i));
			} else if (linksOnThePage.get(i).getAttribute("src") != null) {
				activeLinks.add(linksOnThePage.get(i));
			}
		}

		System.out.println("Size of Active Links and Images: " + activeLinks.size());

		// Response Codes: 200 -> OK | 404 -> Not Found | 500 -> Internal Error | 400 ->
		// Bad Request

		for (int j = 0; j < activeLinks.size(); j++) { // Step 5
			HttpURLConnection myConnectionForHref = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			myConnectionForHref.connect();
			String myResponseForHref = myConnectionForHref.getResponseMessage(); // OK :)
			myConnectionForHref.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "\t\t\t" + myResponseForHref);

		}

		for (int j = 0; j < activeLinks.size(); j++) { // Step 5
			HttpURLConnection myConnectionForSrc = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("src"))
					.openConnection();
			myConnectionForSrc.connect();
			String myResponseForSrc = myConnectionForSrc.getResponseMessage(); // OK :)
			myConnectionForSrc.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("src") + "\t\t\t" + myResponseForSrc);
		}
	}
}