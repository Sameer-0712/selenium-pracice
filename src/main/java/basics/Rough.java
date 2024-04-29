package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().window().maximize();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Currency']")).click();
		List<WebElement> currencies = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		
		for(WebElement currency: currencies) {
			System.out.println(currency.getText());
		}	
	}
	
}
