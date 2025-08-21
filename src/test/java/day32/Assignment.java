package day32;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		

		WebElement fromPort  = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select fromPortElement = new Select (fromPort);
		fromPortElement.selectByValue("Boston");
		
		
		WebElement toPort  = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select toPortElement = new Select (toPort);
		toPortElement.selectByValue("Dublin");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("number of rows in table:"+rows);
		
		String priceArr[] = new String[rows];
		
		for (int r=1;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
			priceArr[r-1]=price; //adding price into array
		}
		

		Arrays.sort(priceArr);
		String lowestPrice = priceArr[0];
		Thread.sleep(5000);
		
		for (int r=1;r<=rows;r++)
			{
				//String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
				
				if(driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText().equals(lowestPrice))
				{
					driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
					break;
				}

			}	
		
		driver.findElement(By.id("inputName")).sendKeys("John");
		driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
		driver.findElement(By.id("city")).sendKeys("Columbus");
		driver.findElement(By.id("state")).sendKeys("OH");
		driver.findElement(By.id("zipCode")).sendKeys("43240");
		driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2023");
		driver.findElement(By.id("nameOnCard")).sendKeys("John Canedy");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
	
		if (driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed())
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}
