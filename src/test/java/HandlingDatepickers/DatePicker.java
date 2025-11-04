package HandlingDatepickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {

	static void selectMonthAndYear(WebDriver driver, String month, String year) {
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();

			if(currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year)) {
				break;
			}
			//if want to select future date
			driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
			//if want to select past date
			//driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();

			}
	}
	
	static void selectDate(WebDriver driver, String date) {
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr/td//a"));
		for(WebElement dt: dates) {
			if(dt.getText().equals(date)) {
				dt.click();
				System.out.println("in for ");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		
		String month ="December";
		String date ="5";
		String year ="2026";

		
		//method1 - Using sendKeys method
		//driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("12/05/2025");
		
		//method2 - handling date picker using date picker element
	
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click(); //opens the date picker
		
		selectMonthAndYear(driver, month, year);
		
		selectDate(driver,date); 	
		
		driver.quit();
	
	}

}
