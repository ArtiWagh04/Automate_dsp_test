package TestNGAnnotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Class3 {

	@Test
	void method() {
		System.out.println("class3");
	}
	
	@BeforeSuite
	void beforeSuite(){
		System.out.println("before suite");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("after suite");
	}
	
}
