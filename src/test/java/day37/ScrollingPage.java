package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// 1 - scroll down by pixel number
		//js.executeScript("window.scrollBy(0,1500)","");
		//System.out.println(js.executeScript("return window.pageYOffset;")); // will return exact position of scrollbar
		
		// 2 - scroll page till element is visible
		/*WebElement ele = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset;")); //2410.39990234375
		*/
		
		// 3 - Scroll down till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); //2451.199951171875
		
		
		// 4 - scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); //0	
	}

}
