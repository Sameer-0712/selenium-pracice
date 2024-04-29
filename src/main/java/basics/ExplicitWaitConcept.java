package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
		long startTime = System.currentTimeMillis();
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		driver.findElement(By.id("adder")).click();
		try {
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0"))).getCssValue("background-color"));
//			System.out.println(driver.findElement(By.id("box0")).getCssValue("background-color"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("***********");
		driver.findElement(By.id("reveal")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed"))).sendKeys("Test");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("***********");
		driver.findElement(By.id("adder")).click();
		try {
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box1"))).getCssValue("background-color"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);;
	}

}
