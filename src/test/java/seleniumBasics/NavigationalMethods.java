package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationalMethods {
public static void main(String[] args) {
	
	WebDriver driver = new FirefoxDriver();
	
	driver.navigate().to("https://timesofindia.indiatimes.com/");
	
	driver.navigate().to("https://www.hindustantimes.com/");
	
	driver.navigate().back();
	System.out.println(driver.getCurrentUrl());
	
	driver.navigate().forward();
	System.out.println(driver.getCurrentUrl());
	
	driver.navigate().refresh();
	
}
}
