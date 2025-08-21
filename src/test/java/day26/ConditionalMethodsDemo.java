package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethodsDemo {

	public static void main(String[] args) throws InterruptedException {

	WebDriver driver = new ChromeDriver();
		
		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
	
		//isDisplayed method
		//System.out.println("isDisplayed"+ " " + driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed());
		//driver.close();
		

		
		
		//isEnabled method
		//System.out.println("Is first name field enabled for input"+ " " +driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).isEnabled());
		
		
		
		//isSelected method
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//System.out.println("is Selected or not Male:"+ " "+ driver.findElement(By.xpath("//input[@value='Male']")).isSelected());
		//System.out.println("is Selected or not Female:"+ " "+ driver.findElement(By.xpath("//input[@value='FeMale']")).isSelected());
	
		//select radio buttons - only one will be true at a time since it is radio button
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		System.out.println("is Selected or not - Male:"+ " "+ driver.findElement(By.xpath("//input[@value='Male']")).isSelected());
		System.out.println("is Selected or not Female:"+ " "+ driver.findElement(By.xpath("//input[@value='FeMale']")).isSelected());
	
	}

}
