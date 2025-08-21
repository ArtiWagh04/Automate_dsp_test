package GettingBrowserTitlesAndClosing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingBrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@class=\"wikipedia-search-button\"]")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 List<WebElement> allLinks = driver.findElements(By.tagName("a")); 
		 
		 int totalLinks = allLinks.size();
		 
		 System.out.println(totalLinks);
		 
//		 for(WebElement link: allLinks) {
//			 link.click();
//		 }
		 
//		 
//		 driver.findElement(By.linkText("Selenium")).click();
//		
//		 driver.findElement(By.linkText("Selenium in biology")).click();
//		 
//		 driver.findElement(By.linkText("Selenium (software)")).click();
//		 
//		 driver.findElement(By.linkText("Selenium disulfide")).click();
//		
//		 driver.findElement(By.linkText("Selenium dioxide")).click();

		 
		 
	}

}
