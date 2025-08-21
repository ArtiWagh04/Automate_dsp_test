package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAuthenticatedPopups {

	public static void main(String[] args) {
		//we can't use switchTo() method and explicit wait for handling these pop ups
		//we can handle such authenticated pop ups by passing username and password along with the url
		
		//syntax to pass un and pass in url is - main url - https://the-internet.herokuapp.com/basic_auth; 
		//url with un and pass - https://username:password@the-internet.herokuapp.com/basic_auth
		
		WebDriver driver = new FirefoxDriver();
				
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}
	
}
