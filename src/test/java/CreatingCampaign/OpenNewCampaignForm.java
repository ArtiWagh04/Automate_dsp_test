package CreatingCampaign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	

	Set<String> windowIds = driver.getWindowHandles();
	
	List<String> windowList = new ArrayList(windowIds);
	
	String firstWindow = windowList.get(0);
	String secondWindow = windowList.get(1);

	//System.out.println(firstWindow + " - " + secondWindow);
	
	//System.out.println(driver.getTitle());
		
	driver.switchTo().window(secondWindow);
	//System.out.println(driver.getTitle());
	
	
	//(//span[@class="sc-kAzzGY dGOGxZ"])[6] = skip tutorial
	
	WebElement element2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//span[contains(text(),'Skip Tutorial')]")
		));
	element2.click();
	
	driver.findElement(By.xpath("//button[@class=\"sc-kGXeez dSzcGq sc-chPdSV biuqWp btn btn-default\"]")).click();
	
	
	//if we have multiple browser windows then second approach to perform some operation on browser window
	
	for(String winID: windowIds) {
		String title = driver.switchTo().window(winID).getTitle();
		if(title.equals("XPO")){
			System.out.println(driver.getCurrentUrl());
			driver.close();
		}
	}
	
	
	driver.findElement(By.xpath("//a[@href=\"/knx63126/campaigns\"]")).click();	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.findElement(By.xpath("(//a[@class=\"btn btn-default green-meadow customize-button-color btn-outline btn-circle uppercase sbold dropdown-toggle hover-initialized\"])[2]")).click();
	//deselecting TT
	driver.findElement(By.xpath("(//button[@class=\"sc-iysEgW jaisAi\"])[4]")).click();
	//campaign name
	driver.findElement(By.xpath("//input[@placeholder=\"Campaign name\"]")).sendKeys("Cross channel campaign from selenium");
	//target cpa
	driver.findElement(By.xpath("(//input[@placeholder=\"Not Set\"])[1]")).sendKeys("1");
	//total budget
	driver.findElement(By.xpath("(//input[@class=\"form-control\" and @placeholder=\"Not Set\"])[3]")).sendKeys("10000");
	//enter geo location
	WebElement location = driver.findElement(By.xpath("(//div[@class=\\\"Select-placeholder\\\"])[2]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", location);
	
	driver.findElement(By.xpath("(//div[@class=\"Select-placeholder\"])[2]")).sendKeys("US");
	//click save
	driver.findElement(By.xpath("//button[@class=\"sc-kGXeez dSzcGq sc-chPdSV biuqWp btn btn-default\"]"));
	
	
	
	//get methods
//	
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getCurrentUrl());
//	System.out.println(driver.getPageSource());
//	System.err.println(driver.getWindowHandle());
//	System.out.println(driver.getWindowHandles());
//	
//	driver.quit();
	}
}
