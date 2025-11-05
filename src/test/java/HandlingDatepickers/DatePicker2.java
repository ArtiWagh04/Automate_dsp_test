package HandlingDatepickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id=\"txtDate\"]")).click();
		String expectedYear = "2026";
		String expectedMonth = "Aug";
		String expectedDate = "4";
		WebElement year = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		Select expYear = new Select(year); 
		expYear.selectByValue(expectedYear);
		
/* When you change the year, jQuery UI refreshes the entire calendar DOM, which includes re-rendering the month <select> element.
		So your old reference to the <select> for month becomes stale (invalid).  AND THROWS StaleElementReferenceException */ 
		
		WebElement month = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		Select expMonth = new Select(month);
		expMonth.selectByVisibleText(expectedMonth);
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr/td//a"));
		for(WebElement dt: dates) {
			if(dt.getText().equals(expectedDate)) {
				dt.click();
				System.out.println("in for ");
				break;
			}
		}
		
		
	
		
	}
}
