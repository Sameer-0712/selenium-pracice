package testNGSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpencartLoginTest extends BaseTest {
	
	@Test()
	public void opencartTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login", "Title does not match...");
	}
	
	@Test
	public void opencartImageTest() {
		boolean logo = driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void opencartURLTest() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("account/login"));
	}

}
