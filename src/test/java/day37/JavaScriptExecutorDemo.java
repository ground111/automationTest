package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//if sendKeys working fine, go with it, if not then ElementIntercepted Exception
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Surbhi");
		
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		
		//alternate of sendKeys method
		JavascriptExecutor js = (JavascriptExecutor) driver; //type casting required when driver is of WebDriver
		js.executeScript("arguments[0].setAttribute('value', 'Surbhi')", inputbox); // inputbox stored in arguments[0]
		
		//ChromeDriver driver = new ChromeDriver();
		//JavascriptExecutor js = driver; //no type casting required, chromedriver is indirect child of JSExecutor
		
		 //alternate of click radio button
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn);
		
		
		

	}

}
