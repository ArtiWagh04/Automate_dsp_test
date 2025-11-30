package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//open application
//test logo presence
//login
//close

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@Test(priority = -1)
	void openApp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	void logoPresence() {
		boolean status = driver.findElement(By.xpath("//div[text()=\"Swag Labs\"]")).isDisplayed();
		System.out.println(status);
	}
	
	@Test(priority = 1)
	void loginApp() {
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@class=\"submit-button btn_action\"]")).click();
		}
	
	//default priority of this method is = 0
	@Test(priority = 2)
	void closeApp() {
		driver.quit();
	}
}
