package KeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		
		
		WebElement xAxis1 = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		System.out.println("left slider location: " + xAxis1.getLocation());
		//58(x), 249(y)
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(xAxis1, 30, 249).perform();
		
		//right slider 
		WebElement xAxis2 = driver.findElement(By.xpath("//span[2]"));
		act.dragAndDropBy(xAxis2, -100, 249).perform();
		System.out.println("right slider location: " + xAxis2.getLocation());

}
	
}
