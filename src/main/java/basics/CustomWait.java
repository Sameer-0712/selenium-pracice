package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ElementExceptions;

public class CustomWait {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.xpath("//button[@data-loading-text]")).click();
		
		By cartMsg = By.xpath("//p[text()='Your shopping cart is empty']");
//		System.out.println(waitForElement(cartMsg, 10).getText());
		System.out.println(waitForElementWithMaxTimeOut(cartMsg, 50000).getText());

	}

	public static WebElement waitForElement(By locator, int maxAttempts) {
		
		WebElement element = null;
		int attempt = 1;
		while(attempt <= maxAttempts) {
			try {
				element = driver.findElement(locator);
				System.out.println("Element found in attempt: "+attempt);
				break;
			}catch(Exception e) {
				System.out.println("Element not found: Attempt: "+attempt);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempt++;
		}
		
		if(element == null) {
			throw new ElementExceptions("Element does not exist");
		}
		return element;
	}
	
	
	public static WebElement waitForElement(By locator, int maxAttempts, int timeOut) {
		
		WebElement element = null;
		int attempt = 1;
		while(attempt <= maxAttempts) {
			try {
				element = driver.findElement(locator);
				System.out.println("Element found in attempt: "+attempt);
				break;
			}catch(Exception e) {
				System.out.println("Element not found: Attempt: "+attempt);
				try {
					Thread.sleep(timeOut);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempt++;
		}
		
		if(element == null) {
			throw new ElementExceptions("Element does not exist");
		}
		return element;
	}
	
	public static WebElement waitForElementWithMaxTimeOut(By locator, int maxTimeOut) {
		
		WebElement element = null;
		int timeOut = 500;
		int counter = 1;
		while(maxTimeOut!=0) {
			try {
				element = driver.findElement(locator);
				System.out.println("Element found in "+timeOut*counter+" ms");
			}catch(NoSuchElementException e) {
				System.out.println("Element not found in "+timeOut*counter+" ms");
				try {
					Thread.sleep(timeOut);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			counter++;
			maxTimeOut = maxTimeOut - timeOut;
		}
		if(element == null) {
			throw new ElementExceptions("Element does not exist");
		}
		return element;
	}
}
