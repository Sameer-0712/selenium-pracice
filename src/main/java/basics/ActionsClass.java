package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	
	static WebDriver driver;
	static Actions action;
//	static Actions action;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.bigbasket.com/?nc=logo");
//		Actions action = new Actions(driver);
		
		By shopByCategoryLocator = By.xpath("(//span[contains(text(),'Shop by')])[2]");
		By beveragesLocator = By.xpath("//a[normalize-space()='Beverages' and @role='none']");
		By coffeeLocator = By.xpath("//a[normalize-space()='Coffee']");
		By instantCoffeeLocator = By.xpath("//a[normalize-space()='Instant Coffee']");
		
//		driver.findElement(shopByCategoryLocator).click();
//		Thread.sleep(2000);
//		action.moveToElement(driver.findElement(beveragesLocator)).perform();
//		Thread.sleep(2000);
//		action.moveToElement(driver.findElement(coffeeLocator)).perform();
//		Thread.sleep(2000);
//		action.click(driver.findElement(instantCoffeeLocator)).perform();
////		action.moveToElement(driver.findElement(instantCoffeeLocator)).perform();
//		Thread.sleep(8000);
//		driver.quit();
		handleMenuSubMenuLevel4(shopByCategoryLocator, beveragesLocator, coffeeLocator, instantCoffeeLocator);

	}
	
	public static void handleMenuSubMenuLevel4(By level1Menu, By level2Menu, By level3Menu, By level4Menu) throws InterruptedException {
		clickElement(level1Menu);
		Thread.sleep(2000);
		hoverElement(level2Menu);
		Thread.sleep(2000);
		hoverElement(level3Menu);
		Thread.sleep(2000);
		clickElement(level4Menu);
	}
	
	public static void clickElement(By locator) {
		getElement(locator).click();
	}
	
	public static void hoverElement(By locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();;
	}
	
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}

}
