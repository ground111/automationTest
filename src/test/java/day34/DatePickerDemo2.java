package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		
		// input DOB
		String requiredyear ="2021";
		String requiredmonth = "Jun";
		String requireddate = "15";
		
		//select year from drop down
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select year = new Select (yearDropDown);
		year.selectByVisibleText(requiredyear);
		
		
		WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month = new Select (monthDropDown);
		month.selectByVisibleText(requiredmonth);

		
		//select date

		List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
		for(WebElement dt : all_dates)
		{
			if(dt.getText().equals(requireddate))
			{
				dt.click();
				break;
			}
		}
		
	}

}
