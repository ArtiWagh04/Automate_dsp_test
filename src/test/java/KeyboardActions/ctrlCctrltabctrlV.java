package KeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ctrlCctrltabctrlV {

		// TODO Auto-generated method stub
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			WebDriver driver = new FirefoxDriver();
			driver.get("https://text-compare.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//textarea[@id='inputText1']")) .sendKeys("Welcome!!!");
			
			
			Actions act = new Actions(driver);
			//Ctrl A
			
			act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			//Ctrl C
			
			act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

			
			//Tab
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			
			//Ctrl V
			
			act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
			 
			System.out.println("pass");
			driver.quit();
			

	}

}
