package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethodAnnotations {

/*
 1-Login
 2-Search
 3-Logout
 4-Login
 5-Advanced Search
 6-Logout	
 */
	
	
		@BeforeMethod
		void login() 
		{
			System.out.println("Login");
		}
		
		
		@Test(priority=1)
		void search() 
		{
			System.out.println("Search");
		}
		
		
		@Test(priority=2)
		void advancedSearch()
		{
			System.out.println("Advanced Search");
		}
		
		
		@AfterMethod
		void logout()
		{
			System.out.println("Logout");
		}

		
}
