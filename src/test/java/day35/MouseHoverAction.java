package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement desktop = driver.findElement(By.xpath("(//a[contains(text(),'About Me & Feedback')])[2]"));
		WebElement mac = driver.findElement(By.xpath("(//a[normalize-space()='Placed Students Feedback'])[2]"));
		
		Actions act = new Actions(driver);
		
		//mouse hover + click
		//act.moveToElement(desktop).moveToElement(mac).click().build().perform();
		
		//without build()
		act.moveToElement(desktop).moveToElement(mac).click().perform();

		
	}

}
