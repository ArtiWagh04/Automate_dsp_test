package GroupingDemo;

import org.testng.annotations.Test;

public class signUpTests {

	@Test(priority=1, groups = {"regression"})
	void signwithEmail() {
		System.out.println("sign up with email");
	}
	
	@Test(priority=2, groups = {"regression"})
	void signwithFB() {
		System.out.println("sign up with FB");
	}
	
	@Test(priority=3, groups = {"regression"})
	void signwithtwitter() {
		System.out.println("sign up with twitter");
	}
	
	
}
