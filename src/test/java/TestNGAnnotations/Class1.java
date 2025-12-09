package TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1
{
	@Test
	void methodClass1() {
		System.out.println("class1");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("after class");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("after method");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("before test");
	}

}
