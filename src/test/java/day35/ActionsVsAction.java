package day35;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsVsAction {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act = new Actions(driver);
		
		//Both are same
		//act.contextClick(button).build().perform();
		//act.contextClick(button).perform();
		
		
		//only build, do not perform
		//creating action and storing into a variable 
		org.openqa.selenium.interactions.Action myaction = act.contextClick(button).build(); // to be stored in order to perform later
		//Action myaction = act.contextClick(button).build();
		myaction.perform(); //performing or completing action
	}

}
