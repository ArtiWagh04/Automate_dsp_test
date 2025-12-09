package TestNGAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Class2 
	{
		@Test
		void methodClass1() {
			System.out.println("class2");
		}
		
		@AfterTest
		void bt() {
			System.out.println("after test");
		}

}
