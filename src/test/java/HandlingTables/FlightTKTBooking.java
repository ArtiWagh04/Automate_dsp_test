package HandlingTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightTKTBooking {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement fromPort = driver.findElement(By.name("fromPort"));
		Select select = new Select(fromPort);
		select.selectByVisibleText("Mexico City");

		WebElement toPort = driver.findElement(By.name("toPort"));
		Select select2 = new Select(toPort);
		select2.selectByVisibleText("New York");

		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		
//		Set<String> windowIds = driver.getWindowHandles();
//		
//		List<String> windowList = new ArrayList(windowIds);
//		
//		String firstWindow = windowList.get(0);
//		String secondWindow = windowList.get(1);
//
//		
//		driver.switchTo().window(firstWindow);
		
		//get no of rows in table
		int rows = driver.findElements(By.xpath("//table[@class=\"table\"]//tr")).size();
		System.out.println(rows);
		//loop though the price column to get lowest price
        double min = Integer.MAX_VALUE;

		for(int i=1; i<rows; i++) {

			String priceInText = driver.findElement(By.xpath("//table[@class=\"table\"]//tr["+i+"]//td[6]")).getText();	
		    double price = Double.parseDouble(priceInText.replace("$", "").trim());

	            if(price == -999) break;  // stopping condition
	            
	            if(price < min){
	                min = price;
	            }
			
			
		}
        System.out.println("Lowest number is: " + min);

		driver.findElement(By.xpath("//table[@class='table']//td[contains(text(),'$" + min + "')]/parent::*//td//input[@type=\"submit\"]")).click();
		//table[@class='table']//td[contains(text(),'200.98')]/parent::*//td//input[@type="submit"] ----- xpath to get parent row and click on choose this flight
		
		driver.findElement(By.xpath("//input[@placeholder=\"First Last\"]")).sendKeys("rt");
		driver.findElement(By.xpath("//input[@placeholder=\"123 Main St.\"]")).sendKeys("tiger");
		driver.findElement(By.xpath("//input[@placeholder=\"Anytown\"]")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@placeholder=\"State\"]")).sendKeys("MH");
		driver.findElement(By.xpath("//input[@placeholder=\"12345\"]")).sendKeys("411001");
		driver.findElement(By.xpath("//input[@placeholder=\"Credit Card Number\"]")).sendKeys("424242424242");

		driver.findElement(By.xpath("//input[@placeholder=\"John Smith\"]")).sendKeys("rt tiger");

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		String str = driver.findElement(By.xpath("//h1")).getText();
		
		if(str.equals("Thank you for your purchase today!")) {
			System.out.println("Test Case Passed");
		}
		
		driver.quit();		
	}
}
