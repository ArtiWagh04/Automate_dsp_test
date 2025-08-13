package CreatingCampaign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewCampaignForm {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://id-test.knorex.com/#/login");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait1.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your email']"))
	    ).sendKeys("arti.wagh@knorex.com");
		
		//driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]")).
		
		
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys("Knorex@123");
		
		
		
		driver.findElement(By.xpath("//button[@class=\"btn btn-main uppercase\"]")).click();
		
		 wait1.until(
			        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"productdashboard-product-content\"])[1]"))
			    ).click();
		 
		 wait1.until(
			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"_9z13RVGNnSZ4A0pwKZkBj btn btn-default\"]"))
			    );
	WebElement element = driver.findElement(By.xpath("//button[@class=\"_9z13RVGNnSZ4A0pwKZkBj btn btn-default\"]")); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//div[@class=\"productdashboard-product-content\"])[1]	

	//input[@placeholder="Search..."]
	
	//(//div[@class="F4UoG8dC8WXooAPDCdrGI"])[2] = search account name
			
			
	driver.findElement(By.xpath("(//div[@class=\"F4UoG8dC8WXooAPDCdrGI\"])[2]")).click();
	
	//(//input[@class="form-control"])[2] = search box
			
	WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"form-control\"])[2]"))).sendKeys("Account_1_15_july_24");
	//driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).click();
	
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Account_1_15_july_24")));

	driver.findElement(By.linkText("Account_1_15_july_24")).click();
	
	
	//(//span[@class="sc-kAzzGY dGOGxZ"])[6] = skip tutorial
	
	
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"u66jzCm6I4JC5FosZD1cG _26NtvIxuLN2zWcyN1vB005\"]")));
	driver.findElement(By.xpath(("//span[@class=\"sc-kAzzGY dGOGxZ\"])[6]"))).click();
	
	}
}
