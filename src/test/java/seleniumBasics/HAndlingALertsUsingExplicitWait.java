package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HAndlingALertsUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		//normal alert with only ok button
		
		driver.findElement(By.xpath("(//button)[1]")).click();
		
		Thread.sleep(1000);
		
		//driver.switchTo().alert().accept();
		
		Alert myAlert1 = wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(myAlert1.getText());
		myAlert1.accept();
		
	}

}
