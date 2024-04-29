package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementsPractice2 {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/coronavirus/country/india/");
		
		Actions action = new Actions(driver);
		
		action.scrollToElement(driver.findElement(By.xpath("//h3[text()='Daily New Cases in India']"))).perform();
		action.scrollByAmount(0, 500);
		List<WebElement> graph = driver.findElements(By.xpath("//div[@id='coronavirus-cases-linear']//*[local-name()='svg']//*[name()='path']"));
		
		By dateXpath = By.xpath("(//*[local-name()='g']//*[name()='text' and @y='20']/*[name()='tspan'])[1]");
		By casesXpath = By.xpath("(//*[local-name()='g']//*[name()='text' and @y='20']/*[name()='tspan'])[4]");
		
		for(WebElement point:graph) {
			action.moveToElement(point).pause(500).perform();
//			Thread.sleep(2000);
//			String date = driver.findElement(dateXpath).getText();
//			String cases = driver.findElement(casesXpath).getText();
//			System.out.println("Cases on "+date+":"+cases);
		}
		
		driver.quit();
	}

}
