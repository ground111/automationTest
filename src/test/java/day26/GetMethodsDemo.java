package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		//String singleWindowId = driver.getWindowHandle();
		//System.out.println("Single window ID" + " " + singleWindowId);
		
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will open new browser 
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		
		
		
		
	}

}
