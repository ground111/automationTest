package day42;

import org.testng.annotations.Test;

/*
 1 - Open app
 2 - Login
 3 - Logout
 */



public class FirstTestNGTestCase 
	{
		@Test(priority=1)
		void openapp()
		{
			System.out.println("Open App");
		}
		
		@Test(priority=2)
		void login()
		{
			System.out.println("Login");
		}
	
		@Test(priority=3)
		void logout()
		{
			System.out.println("Logout");
		}
	}
