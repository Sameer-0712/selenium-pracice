package basics;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
//		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		
		((HasAuthentication)driver).register(() -> new UsernameAndPassword("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		

	}

}
