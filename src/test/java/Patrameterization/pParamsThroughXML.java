package Patrameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class pParamsThroughXML {
	
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"browser"})
	void setUp(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome": 		driver = new ChromeDriver();
		break;
		
		case "firefox": 		driver = new FirefoxDriver();
		break;
		case "edge": 		driver = new EdgeDriver();
		break;
		default: System.out.println("invalid browser");
		return;

		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		
	}
	
	@Test(priority = 1)
	void logoTest() {
		
		Boolean value = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(true, value);
		
	}
	
	@Test(priority = 2)
	void dashboardTest() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@Test(priority = 3)
	void testUrl() {
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterTest
	void tearDown() {
		driver.close();
	}

}
