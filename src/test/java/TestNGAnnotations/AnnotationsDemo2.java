package TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
	
		
		@BeforeClass
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
		
		@AfterClass
		void logout() {
			System.out.println("logout ");

		}

}
