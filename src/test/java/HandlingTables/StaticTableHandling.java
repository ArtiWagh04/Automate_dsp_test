package HandlingTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaticTableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//find total numbert of rows in table
		int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("Number of rows in table:" + rows);
		
		//find total numbert of columns in table
				int columns = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
				System.out.println("Number of rows in table:" + columns);
		
		//reading data from specific row and column
				//EX - 5th row and 1st column
				
			String str = driver.findElement(By.xpath("(//table[@name=\"BookTable\"]//td)[5]")).getText();
				System.out.println("Text from 5th row and 1st column:" + str);
				
				//
				String str2 = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[4]")).getText();
				System.out.println("Text from 5th row and 4st column:" + str2);
				
			//Read data from all rows and columns
			for(int r=2; r<=rows; r++) {
				for(int c=1; c<= columns; c++) {
					String str3 = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[" + c + "]")).getText();
					System.out.print(str3);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//print book name whose author is Amit
			
			
			for(int r=2; r<=rows; r++) {
				String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[2]")).getText();
				if(authorName.equals("Amit")) {
					String bookName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[1]")).getText();
					System.out.println(bookName);
				}
				
				
			}
			
//print book p
			
			int totalPrice = 0;
			for(int r=2; r<=rows; r++) {
				String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
				System.out.println(price);
			
				totalPrice += Integer.parseInt(price);
			}
			System.out.println(totalPrice);
			
			
			//assignment - purchase flight tkt - https://blazedemo.com/
			
	}

}
