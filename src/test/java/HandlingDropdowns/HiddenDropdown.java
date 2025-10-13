package HandlingDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@tabindex=0])[3]")).click(); //open the dropdown
		
		//get total options in the dropdown
		List<WebElement> options = driver.findElements(By.xpath("//div[@role=\"listbox\"]//span"));
		System.out.println(options.size());
		
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		
	}

}
