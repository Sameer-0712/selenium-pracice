package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		long startTime = System.currentTimeMillis();
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		driver.findElement(By.id("adder")).click();
		try {
			System.out.println(driver.findElement(By.id("box0")).getCssValue("background-color"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("***********");
		driver.findElement(By.id("reveal")).click();
		try {
			driver.findElement(By.id("revealed")).sendKeys("Test");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("***********");
		driver.findElement(By.id("adder")).click();
		try {
			System.out.println(driver.findElement(By.id("box1")).getCssValue("background-color"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);;
	}

}
