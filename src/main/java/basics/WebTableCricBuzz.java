package basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableCricBuzz {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
//		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/78649/ind-vs-eng-4th-test-england-tour-of-india-2024");
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/70431/ausw-vs-rsaw-1st-t20i-south-africa-women-tour-of-australia-2024");
		
		System.out.println(getBatterStats("Tahlia",2));
		System.out.println(getBowlerStats("Klerk", 2).toString());
	}
	
	public static List<String> getBatterStats(String batsman, int inning) {
		
		String xpath = "(//div[@id='innings_"+inning+"']//a[contains(text(), '"+batsman+"')])[1]/parent::div/following-sibling::div[contains(@class,'text-right')]";
		List<WebElement> scoreElements = driver.findElements(By.xpath(xpath));
		List<String> scores = new ArrayList<String>();
		for(WebElement scoreElement : scoreElements) {
			if(!(scoreElement.getText().equals(null) || scoreElement.getText().equals(""))){
				scores.add(scoreElement.getText());
			}		
		}
		return scores;
	}
	
	public static HashMap<String, String> getBowlerStats(String bowler, int innings) {
		String xpath = "//div[@id='innings_"+innings+"']/div[4]//a[contains(text(),'"+bowler+"')]/parent::div/following-sibling::div";
		List<WebElement> bowlingStats = driver.findElements(By.xpath(xpath));
		HashMap<String,String> hm = new HashMap<String,String>();
		List<String> stats = new ArrayList<String>();
		for(WebElement bowlingStat: bowlingStats) {
			if(!(bowlingStat.getText().equals(null) || bowlingStat.getText().equals(""))){
				stats.add(bowlingStat.getText());
			}
		}
		hm.put("Overs", stats.get(0));
		hm.put("Maiden", stats.get(1));
		hm.put("Runs", stats.get(2));
		hm.put("Wicktes", stats.get(3));
		hm.put("No Balls", stats.get(4));
		hm.put("Wides", stats.get(5));
		hm.put("Economy", stats.get(6));
		
		return hm;
	}

}
