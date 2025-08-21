package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select drpCountry = new Select (drpCountryEle);
		
		
		//select option from drop down
		
		//drpCountry.selectByVisibleText("France");
		
		//drpCountry.selectByValue("japan"); //value of value attribite is different from visible Text
		//value="japan"
		//visibleText ="Japan"
		
		//drpCountry.selectByIndex(2); //count manually
		
		
		//count total number of options in drop down
		List<WebElement> options = drpCountry.getOptions();
		System.out.println("Number of options in drop down"+ " "+ options.size());
		
		
		//printing the options
		/*for (WebElement opt : options) 
		{
		System.out.println(opt.getText());
		}*/
		
		System.out.println("-------------------------");
		
		
		for (int i=0; i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		
		
		
	}

}
