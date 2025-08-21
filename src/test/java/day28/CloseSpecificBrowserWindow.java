package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowserWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//open another browser window
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will open new browser 
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for (String windowId : windowIds)
		{
			//driver.switchTo().window(s); // which window ID it will switch to? - not known
			String title = driver.switchTo().window(windowId).getTitle();//now we will know which window it got switched to
			System.out.println(title);
			
			if(title.equals("Human Resources Management Software | OrangeHRM HR Software"))
			{
				driver.close();
			}
		}

	}

}
