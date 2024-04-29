package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//div/p[2]")).getText());	
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//div/p[2]")).getText());
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		System.out.println(alert.getText());
		alert.sendKeys("Testing");
		Thread.sleep(3000);
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//div/p[2]")).getText());
		Thread.sleep(3000);
		driver.quit();
	}

}
