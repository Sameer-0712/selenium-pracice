package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
//		driver.switchTo().frame("frame-middle");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
			
	}

}
