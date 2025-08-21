package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsOrPopUpsDemo {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		
		
		//Normal alert with OK button
		/*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		Alert myalert = driver.switchTo().alert();
		
		//gives text from alert window
		System.out.println(myalert.getText());
		
		myalert.accept();
		*/
		
		
		//Confirmation alert with OK and cancel button
		/*
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss(); */
	
		
		//Prompt alert with input box and OK and cancel button
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(5000);
		
		Alert myPromptalert = driver.switchTo().alert();
		myPromptalert.sendKeys("Welcome");
		//myPromptalert.accept();
		myPromptalert.dismiss();
		
		
	}

}
