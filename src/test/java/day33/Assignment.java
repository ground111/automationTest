package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		int total_pages = driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
		
		
		//repeating pages
				for(int p=1;p<=total_pages;p++)
				{
					
					if(p>1)
					{
						WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
						active_page.click();
						Thread.sleep(3000);
					}
					
					//reading data from the page
							
					int noOfRows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
					
					for(int r=1;r<=noOfRows;r++)
					{
						String id=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]/td[1]")).getText();
						String name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]/td[2]")).getText();
						String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]/td[3]")).getText();
						
						System.out.println(id+" "+ name + " " + price);
						driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']")).click();	
					}
					
				}
				
				
				
				
				
				
				
			}

		}
