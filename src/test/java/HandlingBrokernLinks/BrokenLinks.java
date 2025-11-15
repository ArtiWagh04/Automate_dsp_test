package HandlingBrokernLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println("Total links: " + links);
		
		for(WebElement link: links) {
			String href = link.getAttribute("href");
			
			if(href==null || href.isEmpty()) {
				System.out.println("href is null, so not possible to check");
				continue;
			}
			
			URL linkURL = new URL(href);
			HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
			
			conn.connect();
			
			if(conn.getResponseCode()>=400) {
				System.out.println("link is broken");
			}
			else {
				System.out.println("Not broken link");
			}
			
		}
		
	}

}
