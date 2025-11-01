package HandlingDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestDropdown {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://www.google.com");
	
	driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).sendKeys("Selenium");
	Thread.sleep(3000);
	List<WebElement> options = driver.findElements(By.xpath("//div//ul[@role=\"listbox\"]//li"));
	
	System.out.println(options.size());
	
	for(int i =0; i<options.size(); i++) {
		System.out.println(options.get(i).getText());
		if(options.get(i).getText().equals("selenium")) {
			options.get(i).click();
			System.out.println("inside for");
			break;
		}
	
	}
	
	System.out.println("Done");
	
}
	
	
	
	
	
}


