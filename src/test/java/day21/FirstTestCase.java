package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Test Case
1. Launch chrome browser
2. Open URL https://demo.opencart.com/
3. Validate title should be "Your Store"
4. close browser
 */


public class FirstTestCase {

	public static void main(String[] args) {

		//1. Launch chrome browser
		//ChromeDriver driver = new ChromeDriver(); //Approach -1 (can store only chromedriver)
		WebDriver driver = new ChromeDriver();	//Approach -2 - upcasting - can store any browser object (chrome, FF, edge etc)
		//WebDriver driver = new EdgeDriver();// need to have these browsers on local system
		//WebDriver driver = new FirefoxDriver();
		
		//2. Open URL https://demo.opencart.com/
		driver.get("https://now.gg/");


		//3. Validate title should be "Your Store"
		String actual_title = driver.getTitle();
		if (actual_title.equals("Play Online Games for Free | now.gg Mobile Cloud"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}


		//4. close browser
		//driver.close();
		driver.quit();

	}

}
