package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementsPractice {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/#google_vignette");
		Thread.sleep(5000);
		
		Actions action = new Actions(driver);
		action
		.scrollToElement(driver.findElement(By.xpath("//div[@id='emibarchart']//*[local-name()='svg']/*[name()='g' and @class='highcharts-series-group']/*[name()='g']/*[name()='rect']")))
		.perform();
		
		action.scrollByAmount(0, 500);
		
		List<WebElement> graphBars = driver.findElements(By.xpath("//div[@id='emibarchart']//*[local-name()='svg']/*[name()='g' and @class='highcharts-series-group']/*[name()='g']/*[name()='rect']"));
		
		for(WebElement graphBar:graphBars) {
			action.moveToElement(graphBar).pause(1000).build().perform();
		}
		
		driver.quit();
	}

}
