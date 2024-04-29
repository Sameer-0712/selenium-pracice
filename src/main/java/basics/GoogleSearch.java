package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtil;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		By searchField = By.name("p");
		By optiosList = By.xpath("//ul[@role='listbox']//span[@class='_yb_vpy4ue']");
		ElementUtil el = new ElementUtil(driver);
		el.doSearch(searchField, optiosList, "Selenium", "questions");
		
//		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
//		try {
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
//			driver.findElement(By.xpath("//button[@aria-label='Stay signed out']")).click();
//			driver.switchTo().defaultContent();
//		}catch(Exception e) {
//			System.out.println("Frame did not come...");
////			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Automation");
//		wait  = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'wM6W7d') and @role='presentation']")));
//		
//		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d') and @role='presentation']"));
//		
//		for(WebElement option:options) {
//			System.out.println(option.getText());
//		}
		
		
	}
	

}
