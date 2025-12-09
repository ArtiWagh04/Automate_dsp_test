package TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	void testMethod() {
		String title = "US";
 //		
//		if(title.contentEquals("US")) {
//			System.out.println("Passed");
//		}
//		
//		else {
//			System.out.println("test FAiled");
//		}
		
		Assert.assertEquals(title, "US");
		
	}

}
