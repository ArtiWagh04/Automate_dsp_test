package Patrameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	

	@BeforeTest
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Test(dataProvider = "dp")
	void testMethod(String uname, String pass) throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uname);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(pass);
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		Boolean value = driver.findElement(By.xpath("(//h6[normalize-space()='Dashboard'])[1]")).isDisplayed();
		if(value == true) {
			driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon'])[1]")).click();
			driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	
	@AfterTest
	void tearDown() {
		driver.close();
		
	}
	
	@DataProvider(name = "dp", indices= {0,3})
	Object[][] loginData() {
		
		Object data[][] = {
				{"Admin", "admin123"},
				{"Admin", "Admin123"},
				{"US", "Admin123"},
				{"UK", "Admin123"},

		};
		
		return data;
		
	}

}
