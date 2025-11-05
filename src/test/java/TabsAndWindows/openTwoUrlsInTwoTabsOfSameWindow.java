package TabsAndWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openTwoUrlsInTwoTabsOfSameWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://wikipedia.com");
	}
	
}
