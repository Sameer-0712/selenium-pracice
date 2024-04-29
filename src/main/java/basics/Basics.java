package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {
	
	/**
	 * 
	 * @implNote: This is caller class
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		By search = By.xpath("//input[@name='search1']");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(search).sendKeys("Test");

		

	}

}
