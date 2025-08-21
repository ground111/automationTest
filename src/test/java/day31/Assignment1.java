package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {




		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();

		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drpCountry = new Select (drpCountryEle);

		//count total number of options in drop down
		List<WebElement> options = drpCountry.getOptions();
		System.out.println("Number of options in drop down"+ " "+ options.size());


		//printing the options
		for (WebElement opt : options) 
				{
				System.out.println(opt.getText());
				}
		
		//select one option
		drpCountry.selectByVisibleText("France");

	}

}
