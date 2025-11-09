package OptionsClass;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnablingExensions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Users\\Wagh\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
		options.addExtensions(file);
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
	}

}
