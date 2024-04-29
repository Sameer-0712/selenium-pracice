package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectDropdown {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[contains(text(), 'choice 1')])[1]")).click();
		
		By dropdown = By.xpath("//input[@id='justAnInputBox']");
		By options = By.xpath("//span[@class='comboTreeItemTitle']");
		
//		selectChoices(dropdown, options, "choice 5");
		
//		selectChoices(dropdown, options, "choice 1","choice 3","choice 5","choice 7","choice 2 1");
		
		selectChoices(dropdown, options, "all");
		
		driver.quit();

	}
	
	public static void selectChoice(By dropdownLocator, By optionsLocator, String choice) throws InterruptedException {
		driver.findElement(dropdownLocator).click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(optionsLocator);
		for (WebElement option : options) {
			if(option.getText().equals(choice)) {
				option.click();
				break;
			}
		}	
	}

	public static void selectChoices(By dropdownLocator, By optionsLocator, String... choices) throws InterruptedException {
			
		driver.findElement(dropdownLocator).click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(optionsLocator);	
		
		if(choices[0].equals("all")) {
			for(WebElement option:options) {
				try {
					option.click();
				}catch(ElementNotInteractableException ex) {
					break;
				}
				
			}
		}
		else {
			for(WebElement option:options) {
				for(String choice:choices) {
					if(option.getText().equals(choice)) {
						option.click();
					}
				}
			}
		}	
	}
}
