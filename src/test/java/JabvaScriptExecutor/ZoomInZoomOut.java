package JabvaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		Thread.sleep(5000);
		driver.manage().window().minimize();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = driver;
		js.executeScript("document.body.style.zoom='50%'");
		
	}

}
