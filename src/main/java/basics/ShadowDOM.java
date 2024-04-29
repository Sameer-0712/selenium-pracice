package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();		
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String userNameScript = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";		
		WebElement userName = (WebElement)js.executeScript(userNameScript);		
		userName.sendKeys("TestAutomation");
		
		String frameScript = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		WebElement frameElement = (WebElement)js.executeScript(frameScript);		
		driver.switchTo().frame(frameElement);		
		driver.findElement(By.id("glaf")).sendKeys("DevOps");

	}

}
