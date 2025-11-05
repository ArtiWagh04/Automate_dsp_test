package JabvaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jsInsteadOfClickNSendkeys {
public static void main(String[] args) {
	//WebDriver driver = new FirefoxDriver();
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	
	//driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("rt"); normally sendkeys will work
	
	
	//using JS executor
	
	WebElement element = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	
	//used js executor instead of sendkeys 
	//JavascriptExecutor js = (JavascriptExecutor) driver; if directly use firefox driver object then parent(jsexecutor) can hold child object(firefoxdriver)
	JavascriptExecutor js = driver;
	
	js.executeScript("arguments[0].setAttribute('value','john')", element);
	
	//handling click action using js executor
	// xapth - //*[@id="male"]
	
	WebElement button = driver.findElement(By.xpath("//*[@id=\"male\"]"));
	js.executeScript("arguments[0].click()", button);
	
	
}

}
