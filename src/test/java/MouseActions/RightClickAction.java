package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {
	

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		WebElement rightClickButton = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		
		Actions act = new Actions(driver);
		//mouse hover action
		act.contextClick(rightClickButton).build().perform();//right click
		driver.findElement(By.xpath("//span[text()=\"Copy\"]"));
		//driver.switchTo().alert().accept();
	}
	

}
