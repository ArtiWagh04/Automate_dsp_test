package GroupingDemo;

import org.testng.annotations.Test;

public class searchTests {
	
	@Test(priority=1, groups = {"sanity","regression", "functional"})
	void search() {
		System.out.println("search");
	}
	
	@Test(priority=2, groups = {"sanity","regression", "functional"})
	void advancedSearch() {
		System.out.println("advanced search");
	}
	
	@Test(priority=3, groups = {"sanity","regression", "functional"})
	void googleSearch() {
		System.out.println("google search");
	}

}
