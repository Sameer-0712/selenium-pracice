package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		WebElement element = driver.findElement(By.xpath("(//div[@class='product-thumb'])[6]//a"));
		
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();",element);

	}

}
