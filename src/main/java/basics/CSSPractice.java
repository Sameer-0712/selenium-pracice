package basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSPractice {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.cssSelector(".icon.icon-datev2")).click();
		Thread.sleep(2000);
		
		System.out.println(getCurrentDate());
		System.out.println(fetchWeekends());
		System.out.println(getFutureWeekends());
		System.out.println(fetchHolidays("Oct 2024"));
		System.out.println(fetchWeekends("Oct 2024"));
		
	}
	/*
	 * Method to navigate to a particular month
	 */
	public static void navigateToMonthYear(String monthYear) throws InterruptedException {
		while(!driver.findElement(By.cssSelector("div[class^='DayNavigator'] > div:not(.holiday_count):nth-of-type(2)")).getText().contains(monthYear)) {
			Thread.sleep(500);
			driver.findElement(By.cssSelector("div[class^='DayNavigator']:nth-of-type(3)")).click();
		}
	}
	
	/*
	 * Method to navigate to a fetch the holidays in a month
	 */
	public static String fetchHolidays(String monthYear) throws InterruptedException {
		navigateToMonthYear(monthYear);
		return driver.findElement(By.cssSelector("div[class^='DayNavigator'] > div > div")).getText();
	}
	
	/*
	 * Method to fetch all the weekends of a given month
	 */
	public static List<String> fetchWeekends(String monthYear) throws InterruptedException {
		navigateToMonthYear(monthYear);
		List<WebElement> weekendLocators = driver.findElements(By.cssSelector("span[class^='DayTilesWrapper']>div:nth-of-type(n+6)"));
		List<String> weekendDates = new ArrayList<String>();
		
		for(WebElement weekendLocator: weekendLocators) {
			if(!weekendLocator.getText().equals("")) {
				weekendDates.add(weekendLocator.getText());
			}
		}
		
		for(int i=1;i<weekendDates.size();i++) {
			if( Integer.parseInt(weekendDates.get(i)) < Integer.parseInt(weekendDates.get(i-1))){
				weekendDates.remove(i);
			}
		}
		if(Integer.parseInt(weekendDates.get(weekendDates.size()-1)) < Integer.parseInt(weekendDates.get(weekendDates.size()-2))) {
			weekendDates.remove(weekendDates.size()-1);
		}
		
		return weekendDates;
	}
	
	/*
	 * This is overloaded Method to fetch all the weekends of the current month
	 */
	public static List<String> fetchWeekends() throws InterruptedException {
		List<WebElement> weekendLocators = driver.findElements(By.cssSelector("span[class^='DayTilesWrapper']>div:nth-of-type(n+6)"));
		List<String> weekendDates = new ArrayList<String>();
		
		for(WebElement weekendLocator: weekendLocators) {
			if(!weekendLocator.getText().equals("")) {
				weekendDates.add(weekendLocator.getText());
			}
		}
		
		for(int i=1;i<weekendDates.size();i++) {
			if( Integer.parseInt(weekendDates.get(i)) < Integer.parseInt(weekendDates.get(i-1))){
				weekendDates.remove(i);
			}
		}
		if(Integer.parseInt(weekendDates.get(weekendDates.size()-1)) < Integer.parseInt(weekendDates.get(weekendDates.size()-2))) {
			weekendDates.remove(weekendDates.size()-1);
		}
		
		return weekendDates;
	}
	
	/*
	 * Method to get the current date
	 */	
	public static String getCurrentDate() {
		List<WebElement> dates = driver.findElements(By.cssSelector("span[class^='DayTilesWrapper'] span"));
		String currentDate = "";
		
		for(WebElement date:dates) {
			if(date.getCssValue("color").contains("255") || date.getCssValue("color").contains("216")) {
				currentDate = date.getText();
				break;
			}
			}
		return currentDate;
		}
	
	/*
	 * Method to get the future weekends
	 */	
	public static List<Integer> getFutureWeekends() throws InterruptedException {
		List<String> weekends = fetchWeekends();
		List<Integer> weekendsInt = new ArrayList<Integer>();
		for(String weekend:weekends) {
			weekendsInt.add(Integer.parseInt(weekend));
		}
		
		int currentDate = Integer.parseInt(getCurrentDate());
		
		List<Integer> futureWeekends = new ArrayList<Integer>();
		
		for(int weekendInt:weekendsInt) {
			if(weekendInt>=currentDate) {
				futureWeekends.add(weekendInt);
			}
		}
		return futureWeekends;
	}
}
