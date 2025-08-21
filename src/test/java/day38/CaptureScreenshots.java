package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
		
		// 1 - full page screenshot
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE); //captured screenshot and stored in sourcefile
		//File targetfile = new File("C:\\workspaces\\seleniumwebdriver\\seleniumwebdriver\\screenshots\\fullpage.png");
		
		//get such long path dynamically, first half is the location of project only
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\fullpage1.png"); // to know location of SS, we created target file
		sourcefile.renameTo(targetfile); //copy source file to target file
		*/
		
		// 2 - Capture specific area of the page
		/*WebElement featuredProductSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sourcefile = featuredProductSection.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\featureProducts.png");
		sourcefile.renameTo(targetfile);
		*/
		
		// 3 - Capture screenshot of particular element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourcefile = logo.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\logo.png");
		sourcefile.renameTo(targetfile);
		
	}

}
