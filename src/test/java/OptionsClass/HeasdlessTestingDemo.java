package OptionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class HeasdlessTestingDemo {
	public static void main(String[] args) throws InterruptedException {
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless=new");
		
		//we have to do headless mode of execution before creating the driver object
		
		FirefoxDriver driver = new FirefoxDriver(options);
		//opening url
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement fromPort = driver.findElement(By.name("fromPort"));
		//selected city 1
		Select select = new Select(fromPort);
		select.selectByVisibleText("Mexico City");
		//selected city 2
		WebElement toPort = driver.findElement(By.name("toPort"));
		Select select2 = new Select(toPort);
		select2.selectByVisibleText("New York");
		System.out.println("test passed");
		//quit browesr
		driver.quit();
	}

}
