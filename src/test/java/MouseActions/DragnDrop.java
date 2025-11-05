package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		driver.manage().window().maximize();
		
		WebElement box1 = driver.findElement(By.xpath("(//img[@draggable=\"true\"])[1]"));
		WebElement box2 = driver.findElement(By.xpath("//div[@id=\"div2\"]"));

		Actions act = new Actions(driver);
	
		act.dragAndDrop(box1, box2).perform();
//		Thread.sleep(4000);
//		driver.quit();
		
	}

}
