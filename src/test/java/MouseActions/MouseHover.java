package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();
	WebElement desktops = driver.findElement(By.xpath("//a[text()=\"Desktops\"]"));
	WebElement mac = driver.findElement(By.xpath("((//li[@class=\"nav-item dropdown\"])[1]//ul//li)[2]"));
	
	Actions action = new Actions(driver);
	//mouse hover action
	action.moveToElement(desktops).moveToElement(mac).click().build().perform();
}
}
