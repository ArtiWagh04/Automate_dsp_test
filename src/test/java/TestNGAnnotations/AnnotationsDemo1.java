package TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo1 {
	
	@BeforeMethod
	void login() {
		System.out.println("login ");
	}
	
	@Test
	void search() {
		System.out.println("search ");

	}
	
	@Test(priority = 1)
	void advanceSearch() {
		System.out.println("advSearch ");

	}
	
	@AfterMethod
	void logout() {
		System.out.println("logout ");

	}

}
