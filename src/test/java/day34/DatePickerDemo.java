package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	//select future date
	static void selectFututeDate(WebDriver driver, String month, String year,String date)
	{
		//select month and year
				while(true)
					{
						if (driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month) &&
							driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().equals(year))
						{
							break;
						} 
						//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Previous button
						 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Next Button
					}
	
		
		//select date

				List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
				for(WebElement dt : all_dates)
				{
					if(dt.getText().equals(date))
					{
						dt.click();
						break;
					}
				}
	}
	
	
	//select past date
		static void selectPastDate(WebDriver driver, String month, String year,String date)
		{
			//select month and year
					while(true)
						{
							if (driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month) &&
								driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().equals(year))
							{
								break;
							} 
							driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Previous button
							//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Next Button
						}
		
			
			//select date

					List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
					for(WebElement dt : all_dates)
					{
						if(dt.getText().equals(date))
						{
							dt.click();
							break;
						}
					}
		}

	
	
	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		//Method-1: using sendKeys() - if application allows entering date
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2025");
		
		
		//Method-2 : using date picker
		String year ="2024";
		String month = "July";
		String date = "16";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //opens date picker
		
		
		//selectMonthAndYear(driver, month, year);
		//selectDate(driver, date);
		
		selectPastDate(driver, year, month, date);
		
		//selectFututeDate(driver, "July", "2026", "16");
		//selectPastDate(driver, "July", "2024", "16");
		
		
	}

}
