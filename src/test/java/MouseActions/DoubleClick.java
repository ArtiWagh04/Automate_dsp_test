package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {		

		public static void main(String[] args) {
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
			driver.manage().window().maximize();
			
			driver.switchTo().frame("iframeResult");
			
			WebElement box1 = driver.findElement(By.xpath("//input[@id=\"field1\"]"));
			WebElement box2 = driver.findElement(By.xpath("//input[@id=\"field1\"]"));
			WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text'] "));

			Actions act = new Actions(driver);
			//Double click action
			act.doubleClick(button).perform();
			//driver.findElement(By.xpath("//span[text()=\"Copy\"]"));
			//driver.switchTo().alert().accept();
			
//			String box2Text = box2.getText();  THIS WILL CAPTURE EMPTY VALUE BEVCAUSE GETTEXT CAN ONLY CAPTURE INNER TEXT
//			System.out.println(box2Text);
			
			String box2Text = box2.getAttribute("value");

			
			if(box2Text.equals("Hello World!")) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}

			
		}
		


		//input[@id='field2']
		//input[@id='field1']
		//button[normalize-space()='Copy Text']
}
