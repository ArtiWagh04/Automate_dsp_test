package KeyboardActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class openInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

		List<String> windowIds = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(windowIds.get(1));
		
	}

}
