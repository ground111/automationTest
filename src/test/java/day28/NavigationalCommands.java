package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();
		//accept url only in string format
		//driver.get("https://demo.automationtesting.in/Register.html");
	
		
		//passed url as url object
		//URL myurl = new URL("https://demo.automationtesting.in/Register.html"); 
		//driver.navigate().to(myurl);
	
		
		//passed url directly as string
		driver.navigate().to("https://demo.automationtesting.in/Register.html");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.navigate().back();
		System.out.println("After going back:"+ " " +driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("After going forward:"+ " " +driver.getCurrentUrl());
	
		
		driver.navigate().refresh();
		

	}

}
