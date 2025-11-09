package OptionsClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Title of page:" + driver.getTitle());
		
	}

}
