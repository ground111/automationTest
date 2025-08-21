package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args)  {
			
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//open another browser window
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will open new browser 
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		 
		//Approach 1 - get window IDs separately (if 2 or3 windows only)
		/*List<String> windowList = new ArrayList(windowHandles);
		String parentID = windowList.get(0);
		String childID = windowList.get(1);
		
		System.out.println("Before switch"+ " " +driver.getTitle()); // will return parent window title, driver still focused on parent
		
		
		//switch to child window
		driver.switchTo().window(childID);
		System.out.println("After switch" + " " +driver.getTitle());
		
		
		//switch to parent window
		driver.switchTo().window(parentID);
		System.out.println("After switch again to parent" + " " +driver.getTitle());
		*/
		
		
		//Approach 2 - get window IDs separately (if too many window IDs)
		
		for (String s : windowHandles)
		{
			//driver.switchTo().window(s); // which window ID it will switch to? - not known
			String title = driver.switchTo().window(s).getTitle();//now we will know which window it got switched to
			
			if(title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
				//some validation on parent window or do some action here on expected page (title)
			}
		}
	}

}
