package testNGSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	@Test()
	public void googleTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "Title does not match...");
	}
	
	@Test
	public void googleLanguagesTest() {
		int languageCount = driver.findElements(By.xpath("//div[text()='Google offered in:  ']/a")).size();
		Assert.assertEquals(languageCount, 9, "Count of languages is not correct");
	}
	
	@Test
	public void googleURLTest() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("google"));
	}
	

}
