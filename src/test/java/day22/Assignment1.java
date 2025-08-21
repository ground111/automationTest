package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args)  {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		
		
		//total number of links and print them
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links"+ " "+ links.size());

		
		//total number of images
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of images"+ " "+ images.size());
		
		
		//click on any product link using linkText / partialLinkText
		driver.findElement(By.linkText("Contact")).click();
		//driver.findElement(By.partialLinkText("About")).click();
	}

}
