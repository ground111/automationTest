package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> lastFiveCheckboxes = driver.findElements(By.xpath("(//input[@type='checkbox'])[position() > 7]"));
		//or, //input[@type='checkbox' and not(@id) and not(@class)]

		for (WebElement checkbox : lastFiveCheckboxes) {
		    checkbox.click(); // or any other action
		}
		
		Thread.sleep(5000);
		
		for (int i=0;i<lastFiveCheckboxes.size();i++)
		{
			if(lastFiveCheckboxes.get(i).isSelected())
			{
				lastFiveCheckboxes.get(i).click();
			}
		}

		
	}

}
