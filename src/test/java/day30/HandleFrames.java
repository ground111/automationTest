package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		
		//this is inside frame1
		//driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome"); // no such element exception- This element is inside same origin iframe. Switch inside iframe to access it through automation
	
		
		
		//Approach -1 : switch to iframe - frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1); //passed frame as WebElement
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame1");
		
		
		//frame2
		//first come out from frame 1, go back to page then switch to frame2
		driver.switchTo().defaultContent();
		
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
	
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame2");
		
		driver.switchTo().defaultContent(); // come back to main page
	
	
		//Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3");
		
		//interacting with inner iframe - which is part of frame-3
		driver.switchTo().frame(0); //switching to frame using index - since frame3 has only one frame, so we can use index
		
		//open actual link of iframe inside frame3 tag - google doc form, then from there identify radio button and get xpath
		//https://docs.google.com/forms/d/e/1FAIpQLScP-K8zi-9ar0MCq93D3VIFhegSNPveBfdLqiMfTYR9Q1iSKQ/viewform?embedded=true
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		
		driver.switchTo().defaultContent(); 
		
	}

}
