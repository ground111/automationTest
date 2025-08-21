package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		driver.switchTo().frame("iframeResult");

		WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
		box1.clear();
		box1.sendKeys("Welcome");

		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		String text= box2.getText();
		if(box1.getText().equals(text))
		{
			System.out.println("Match");
		}
		else
		{
			System.out.println("Not matched");
		}




	}

}
