package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		//register.click(); // will open in same tab and we will lose homepage
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();
		
		//Switching to registration page
		List<String> ids = new ArrayList (driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1)); //switch to register page
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Surbhi"); //perform action on register page
		
		Thread.sleep(3000);
		
		driver.switchTo().window(ids.get(0)); //switch back to home page	
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Tablets"); //action on home page after switching
	}

}
