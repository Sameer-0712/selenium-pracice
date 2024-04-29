package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://geographyfieldwork.com/WorldCapitalCities.htm");
		//Country : //td[text()='Afghanistan']
		//Capital City: //td[text()='Afghanistan']/following-sibling::td
		
		
		System.out.println(getCapital("Australia"));
		getRowColNum("Germany");

	}
	
	public static String getCapital(String country) {
		
		String countryXpath = "//td[normalize-space()='"+country+"']";
		String capitalXpath = countryXpath+"/following-sibling::td";
		try {
			return driver.findElement(By.xpath(capitalXpath)).getText();
		}catch(NoSuchElementException e) {
			return "Enter Correct Country Name";
		}
			
	}
	
	public static void getRowColNum(String place) {
		
		int colCount = driver.findElements(By.xpath("//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@class='sortable']//tr")).size()-1;
		
		for(int i = 2;i<rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				String xpath = "//table[@class='sortable']//tr["+i+"]/td["+j+"]";
				if(driver.findElement(By.xpath(xpath)).getText().equals(place)) {
					System.out.println("Row: "+i);
					System.out.println("Column: "+j);
					break;
				}
			}
		}
		
		
	}

}
