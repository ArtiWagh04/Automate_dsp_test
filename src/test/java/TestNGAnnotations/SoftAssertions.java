package TestNGAnnotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	@Test
	void method1() {
		
		String title = "US";
		
		System.out.println("hi");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title, "UK");
		
		System.out.println("Bye");
		
		sa.assertAll();
		
		
	}
	
	
}
