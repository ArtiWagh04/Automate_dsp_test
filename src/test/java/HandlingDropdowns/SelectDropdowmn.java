package HandlingDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdowmn {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		
		Select country = new Select(dropdown); 	 
		//select option from the dropdown
		
		//country.selectByVisibleText("Japan");
//country.selectByIndex(6);
		country.selectByValue("japan");
//		
		
		//capture all options available from the dropdown
		
		List<WebElement> noOfOptions = country.getOptions();
		System.out.println(noOfOptions.size());
		
		for(WebElement obj:noOfOptions) {
			obj.getText();
		}
		
		
	}
}
