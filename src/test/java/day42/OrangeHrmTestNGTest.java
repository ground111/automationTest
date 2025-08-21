package day42;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/*
 * 1) Open App
 * 2) Test Logo Presence
 * 3) login
 * 4) close
 */


public class OrangeHrmTestNGTest {

	WebDriver driver;
	
	@Test(priority=1)
	void openApp() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	void testLogo() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean isLogoPresent = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		if(isLogoPresent)
		{
			System.out.println("Logo Present");
		}
		else
		{
			System.out.println("Logo NOT Present");
		}
	}
	
	@Test(priority=3)
	void login()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=4)
	void closeApp()
	{
		driver.close();
	}
	
}
