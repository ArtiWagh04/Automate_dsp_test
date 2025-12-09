package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
	@Test(priority=1)
	void openApp() {
Assert.assertTrue(true);	
}
	
	@Test(priority=2,dependsOnMethods= {"openApp"})
	void Login(){
		Assert.assertTrue(true);	
	}
	
	@Test(priority=3, dependsOnMethods= {"Login"})
	void search(){
		Assert.assertTrue(false);	
	}
	@Test(priority=4,dependsOnMethods= {"Login", "search"})
	void advancedSearch(){
		Assert.assertTrue(true);	
	}
	
	@Test(priority=5, dependsOnMethods= {"Login"})
	void Logout() {
		Assert.assertTrue(true);	
	}
}
