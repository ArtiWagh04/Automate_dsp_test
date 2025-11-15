package HandlingShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowElements {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// TODO Auto-generated method stub
		//This Element is inside 3 nested shadow DOM.
		String cssSelectorForHost1 = "#shadow-root";
		String cssSelectorForHost2 = "#inner-shadow-dom";
		String cssSelectorForHost3 = "#nested-shadow-dom";
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String text = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		
		System.out.println(text);
		
	}

}
