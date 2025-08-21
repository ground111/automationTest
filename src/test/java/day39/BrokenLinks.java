package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args)  {


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();


		//capture href attribute value of all links
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links" + " " + links.size());

		int brokenLinks = 0;

		for (WebElement linkElement : links)
		{
			String hrefattValue = linkElement.getAttribute("href");

			if (hrefattValue==null || hrefattValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty, so not possibe to check" + " " + hrefattValue);
				continue;
			}

			//send url to server
			try
			{	
				URL linkurl = new URL(hrefattValue); //href string converted to url format
				HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection(); //open connection to the server
				conn.connect(); //connect to server and send request to server

				if (conn.getResponseCode()>=400)
				{
					System.out.println(hrefattValue + "--------Broken link");
					brokenLinks++;
				}
				else
				{
					System.out.println(hrefattValue + "--------Not a broken link");
				}
			}
			catch(Exception e)
			{
				
			}
		}
		System.out.println("total broken links" + " " + brokenLinks);


	}

}
