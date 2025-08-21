package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
	
		String filePath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		 
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for (int i=1; i<=rows;i++)
		{
			// 1 - read data from excel
			String princ = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String roi = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expected_maturity = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			// 2 - pass data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			Select period_drop_down = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			period_drop_down.selectByVisibleText(period2);
			
			Select freq_drop_down = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			freq_drop_down.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			
			// 3 - validation and fill results column
			String actual_maturity = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if (Double.parseDouble(expected_maturity)==Double.parseDouble(actual_maturity))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "PASS");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "FAIL");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			Thread.sleep(3000);
			// 4 - click clear button to clear last data from application
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
		
		//ending of for loop
		driver.close();
	}

}
