package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/* Test Case
1. Launch chrome browser
2. Open URL https://demo.opencart.com/
3. Validate title should be "Your Store"
4. close browser
 */


public class HeadlessTesting {

	public static void main(String[] args) {
		
		//Before creating webdriver object
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); // setting for headless mode of execution

		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://now.gg/");

		String actual_title = driver.getTitle();
		if (actual_title.equals("Play Online Games for Free | now.gg Mobile Cloud"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}


		driver.quit();

	}

}
