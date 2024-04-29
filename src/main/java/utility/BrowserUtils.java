package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserUtils {
	
	private WebDriver driver;
	
	public BrowserUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new BrowserExceptions("Incorrect browser name");
		}
		return driver;
	}
	
	public void launchApplication(String url) {
		
		if(url.startsWith("https://")) {
			driver.get(url);
		}
		else {
			throw new BrowserExceptions("Invalid URL");
		}		
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
