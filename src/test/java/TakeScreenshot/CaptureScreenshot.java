package TakeScreenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			
			FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Method 1 - capture full page screenshot
		
		TakesScreenshot ts = driver;
		
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		File tagretFile = new File(System.getProperty("user.dir")+"\\CapturedScreenshots\\fullPage.png"); //our location to copy to the file
//		sourceFile.renameTo(tagretFile); //copied the captured ss in our location
//		
		//method 2 - capture screenshot of particular section
		//section[@class="product-grid home-page-product-grid"] -- this is the xpath of the area of which we a=want to capture the screenshot		
//		WebElement sectionOfPage = driver.findElement(By.xpath("//section[@class=\"product-grid home-page-product-grid\"]"));
//		File sourceFile2 = sectionOfPage.getScreenshotAs(OutputType.FILE);
//		File tagretFile2 = new File(System.getProperty("user.dir")+"\\CapturedScreenshots\\sectionOfThePage.png"); //our location to copy to the file
//		sourceFile2.renameTo(tagretFile2); //copied the captured ss in our location
//		// the one more difference in method 2 is we are calling from WebLement interface interface,means TakeScreenshotAs mehtod is implemented in WebElement interface as well
//		
		//method 3 - capture screenshot of specific element
		WebElement logo = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		File sourceFile3 = logo.getScreenshotAs(OutputType.FILE);
		File tagretFile3 = new File(System.getProperty("user.dir")+"\\CapturedScreenshots\\WebElement.png"); //our location to copy to the file
		FileHandler.copy(sourceFile3, tagretFile3); //copied the captured ss in our location
		
		driver.quit();
	}
	
	

}
