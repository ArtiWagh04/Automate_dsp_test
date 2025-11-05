package UploadingFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFiles {
public static void main(String[] args) {
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
	
	
	//uploading single file
	String file1 = "C:\\Users\\Wagh\\Downloads\\hii.txt";
	String file2 = "C:\\Users\\Wagh\\Downloads\\hello.txt";
	
	WebElement fileUpload = driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]"));
	
	fileUpload.sendKeys(file1);
	
	// ashu n mine photos - C:\selenium_joy_ru\selenium_joy_ru
	WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/main/div/ul/li"));
	String uploadedFileName = element.getText();
	if(uploadedFileName.equals("hii.txt")){
		System.out.println("pass");
		
	}
	else {
		System.out.println("fail");
	}
	
	
	//uploading multiple files - if we call sendkeys method twice to upload file at same place then first file will be replaced by second one
	
	fileUpload.clear();
	fileUpload.sendKeys(file1 + "\n" + file2);
	
}
	
}
