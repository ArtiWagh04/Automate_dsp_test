package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();	
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
//	  wait1.until(
//	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your email']"))
//	    ).sendKeys("arti.wagh@knorex.com");
//		
//		//driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]")).
//		
//		
//		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys("Knorex@123");
//			
	
		boolean searchBar = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).isEnabled();

		
//		boolean ggllogo = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
//		
//		System.out.println("is logo displayed:" + ggllogo);
				
		System.out.println(searchBar);
		driver.quit();
	}
	

}
