package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		//to be written only once in whole program
		//does not wait for complete 5 secs, this is max, element loaded in 2, it will move to next step in 2 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait method
		
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//synchronization problem here, why implicit wait mentioned at top??
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.close();
	}

}
