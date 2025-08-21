package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMsgOnScreen {

	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://now.gg/");

		String actual_title = driver.getTitle();
		if (actual_title.equals("Play Online Games for Free | now.gg Mobile Cloud"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}

		
	}

}
