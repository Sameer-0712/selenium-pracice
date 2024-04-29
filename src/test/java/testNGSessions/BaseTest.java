package testNGSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utility.BrowserUtils;
import utility.ElementUtil;

public class BaseTest {

WebDriver driver;
	
	@Parameters({"url","browser"})
	@BeforeTest
	public void setup(String url, String browserName) {
//		driver = new ChromeDriver();
		BrowserUtils brUtil = new BrowserUtils(driver);
		driver = brUtil.launchBrowser(browserName);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void teardDown() {
		driver.quit();
	}
}
