package JabvaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollingThePage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		JavascriptExecutor js = driver;
		
//		//method 1 - scroll page by number os pixels
//		js.executeScript("window.scrollBy(0,3000)", "");
//		System.out.println(js.executeScript("return window.pageYOffset"));
		
//		//method 2 - scroll page until the view of particular web element
//		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table[1]/tbody/tr[23]/td[2]"));
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		System.out.println(js.executeScript("return window.pageYOffset"));

		//method 3 - scroll till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

		//if have horozontal scroll bar then need to use scrollWidth
		
		driver.quit();
	}

}
