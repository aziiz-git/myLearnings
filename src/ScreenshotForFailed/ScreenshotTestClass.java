package ScreenshotForFailed;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (CustomListener.class)
public class ScreenshotTestClass extends Base {

	@BeforeMethod
	public void setUp() {
		initialization(); // initialization() is Static function :)
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit(); // This CLASS is extending 'Base'
	}

	@Test
	public void alwaysFailingFunction1() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void alwaysFailingFunction2() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void alwaysFailingFunction3() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void alwaysFailingFunction4() {
		Assert.assertEquals(false, true);
	}
}