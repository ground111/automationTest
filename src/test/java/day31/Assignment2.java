package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
			driver.manage().window().maximize();
			
			//Login steps
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

			//clicking on PIM 
			driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click(); //PIM
			
			Thread.sleep(5000);
			//clicked on dropdown
			driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']")).click();

			
			
			//select single option
			driver.findElement(By.xpath("//span[normalize-space()='Freelance']")).click();
			
			

		}

	}
