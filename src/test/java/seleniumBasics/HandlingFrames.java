package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame3 =driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
		
		driver.switchTo().frame(frame3); // switched to frame
		
		driver.findElement(By.xpath("//*[@id=\"id3\"]/div/input")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent(); // going back to main content
		
		
		
		WebElement frame4  =driver.findElement(By.xpath("/html/frameset/frameset/frame[3]"));
		
		driver.switchTo().frame(frame4); // switched to frame
		
		driver.findElement(By.xpath("//*[@id=\"id4\"]/div/input")).sendKeys("frame4");
		
		driver.switchTo().defaultContent();
		
	
		driver.switchTo().frame(frame3); // switched to frame
		
		driver.switchTo().frame(0); //switching to inner frame
		
		driver.findElement(By.xpath("//*[@id=\"i9\"]/div[3]/div")).click();
		
		driver.switchTo().defaultContent();
		
		
	}
	
}
