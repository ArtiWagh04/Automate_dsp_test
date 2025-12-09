package GroupingDemo;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(priority=1, groups = {"sanity"})
	void loginwithemail() {
		System.out.println("login with email");
	}
	
	@Test(priority=2, groups = {"sanity"})
	void loginwithFB() {
		System.out.println("login with FB");
	}
	
	@Test(priority=3, groups = {"sanity"})
	void loginwithtwitter() {
		System.out.println("login with twitter");
	}

}
