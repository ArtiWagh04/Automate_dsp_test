package TestNG;

import org.testng.annotations.Test;

public class FirstTestCase
{
	@Test(priority = 2)
	void openApp() {
		System.out.println("open app");
	}
	
	@Test(priority = 2)
	void loginApp() {
		System.out.println("login to app");
	}
	
	@Test(priority = -1)
	void logoutApp() {
		System.out.println("Logout from app");
	}
	
	//default priority of this method is = 0
	@Test
	void closeApp() {
		System.out.println("close app");
	}

}
