package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//select[contains(@class,'form-control')]")).click(); // opens dropdown options
		
		//1) Select single option
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//2) capture all the options and find out size
//		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
//		System.out.println("Number of options:"+options.size()); //14
		
		//3) printing options from dropdown
		/*for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		*/
		
		//4) select multiple options
		List<WebElement> options=driver.findElements(By.xpath("//select[@id=\"colors\"]//option"));
		for(WebElement op:options)
		{
			String option=op.getText();
			
			if(option.equals("Red") || option.equals("Green"))
			{
				op.click();
			}
		}
		

	}

}
