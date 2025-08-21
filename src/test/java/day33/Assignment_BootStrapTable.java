package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_BootStrapTable {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'viewAdminModule')]")).click();
		
		int total_rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div")).size();
		
		for (int r=1;r<=total_rows;r++)
		{
			String userName = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class=\"oxd-table-card\"]["+r+"]//div//div[2]//div")).getText();
			String userRole = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class=\"oxd-table-card\"]["+r+"]//div//div[3]//div")).getText();
			System.out.println(userName+"\t"+userRole);
		}
		

	}

}
