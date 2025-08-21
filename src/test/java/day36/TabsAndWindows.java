package day36;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		// without this first demo url will open and in same tab text-compare site will open
		//driver.switchTo().newWindow(WindowType.TAB); // new url in new tab of same window
		
		driver.switchTo().newWindow(WindowType.WINDOW); // new url in new browser window
		
		driver.get("https://text-compare.com/");

	}

}
