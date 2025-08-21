package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlertsUsingswitchTo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//alert are noit a web elements - we need to use switchTo method
		
		
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		//normal alert with only ok button
		
		driver.findElement(By.xpath("(//button)[1]")).click();
		
		Thread.sleep(1000);
		
		//driver.switchTo().alert().accept();
		
		Alert myAlert1 = driver.switchTo().alert();
		System.out.println(myAlert1.getText());
		myAlert1.accept();
		
		//confirmation alert
		driver.findElement(By.xpath("(//button)[2]")).click();
		
		Thread.sleep(1000);
		
		Alert myAlert2 = driver.switchTo().alert();
		System.out.println(myAlert2.getText());
		myAlert2.dismiss(); // cancle button
		//myAlert2.accept(); // ok button
		
		//prompt alert
				driver.findElement(By.xpath("(//button)[3]")).click();
				
				Thread.sleep(1000);
				
				Alert myAlert3 = driver.switchTo().alert();
				System.out.println(myAlert3.getText());
				myAlert3.sendKeys("Hi"); // cancle button
				myAlert2.accept(); // ok button

		
	}

}
