package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElements {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		Thread.sleep(10000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1000);
		
		List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @id='regions']/*"));
		
		System.out.println(states.size());
		
		for(WebElement state:states) {
			action.moveToElement(state).pause(1000).build().perform();
			System.out.println(state.getAttribute("id"));
		}

	}

}
