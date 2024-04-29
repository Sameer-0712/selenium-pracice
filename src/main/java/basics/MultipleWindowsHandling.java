package basics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowsHandling {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@title,'Accept Cookies')]")).click();
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//a[contains(@href,'facebook')]"))).perform();
		Thread.sleep(2000);
		String parentWindowId = driver.getWindowHandle();
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("(//div[@class='footer-main'])[1]//a[not(normalize-space()='Careers')]"));
		
		for(WebElement footerLink:footerLinks) {
			footerLink.click();
		}		
		Set<String> windowIds = driver.getWindowHandles();
		
		switchToWindow("Executive", windowIds);		
		switchToWindow(parentWindowId);
		switchToWindow("Innovating", windowIds);
		switchToWindow(parentWindowId);
		switchToWindow("Press", windowIds);
		switchToWindow(parentWindowId);
		switchToWindow("Newsroom", windowIds);
		driver.close();
			
	}
	
	public static void switchToWindow(String windowTitle, Set<String> windowIds) {
		Iterator<String> it = windowIds.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(windowTitle)) {	
				System.out.println(driver.getTitle());
				break;
			}
		}
	}
	
	public static void switchToWindow(String windowId) {
		driver.switchTo().window(windowId);
		System.out.println(driver.getTitle());
	}
	
}
