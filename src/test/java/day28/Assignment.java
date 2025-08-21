package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
		System.out.println("Number of links"+ " "+ links.size());
		
		for (WebElement s : links)
		{
			s.click();
			
		}
		
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds)
		{	
			String title = driver.switchTo().window(windowId).getTitle();
			System.out.println(title);
			
			if (title.equals("Selenium in biology - Wikipedia") || (title.equals("Selenium (software) - Wikipedia")))
			{
				driver.close();
			}
		}
	}

}
