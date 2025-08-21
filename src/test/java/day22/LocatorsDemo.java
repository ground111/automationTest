package day22;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		//driver.get("https://now.gg/");
		driver.get("https://www.opencart.com/");
		//driver.get("https://opencartmart.com/");
		driver.manage().window().maximize();
		
		//id
//		driver.findElement(By.id("search-box")).sendKeys("Roblox");
//		
//		Boolean logoDisplayStatus = driver.findElement(By.id("ng-logo")).isDisplayed();
//		System.out.println(logoDisplayStatus);
		
		//linkText and partialLinkText
		//driver.findElement(By.linkText("Store")).click();
		//driver.findElement(By.partialLinkText("Sto")).click();
		
		
		//capture how many links in header part (class)
//		List<WebElement> headerLinks = driver.findElements(By.className("list-inline"));
//		System.out.println(headerLinks.size());
		
		//capture group of elements - number of all links (tagName) (anchor tag)
//		List<WebElement> links = driver.findElements(By.tagName("a")); // a anchor tag : <a href
//		System.out.println(links.size());
		
		//Total number of images on web page
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		
		
		
		

	}

}
