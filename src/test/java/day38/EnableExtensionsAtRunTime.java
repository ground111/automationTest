package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		File file = new File ("C:\\workspaces\\crx files\\SelectorsHub.crx");
		options.addExtensions(file);

		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://text-compare.com/");

		
		
	}

}