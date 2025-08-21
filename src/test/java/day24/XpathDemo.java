package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//xpath with single attribute
		//driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Hello");

		
		//xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("Hello");

		
		//xpath with 'AND' 'OR' operator
		//driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']")).sendKeys("Hello");
		//driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='Search store']")).sendKeys("Hello");
		
		
		//xpath with inner text - text()
		//driver.findElement(By.xpath("//a[text()='Register']")).click();
//		boolean b = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
//		System.out.println(b);
//		System.out.println(driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText());
		//driver.findElement(By.xpath("//a[text()='Orders']")).click();
		
		
		//xpath with contains()
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("hello");
		
		
		//xpath with starts-with()
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sear')]")).sendKeys("hello");	
		
		
		//chained xpath
		boolean b = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div/strong")).isDisplayed();
		System.out.println(b);
		System.out.println(driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div/strong")).getText());
	}

}
