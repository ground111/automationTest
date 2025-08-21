package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//TOTAL NUMBER OF ROWS IN TABLE
		//Approach -1 : find total <tr>
		//List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		//System.out.println(rows.size());
		
		//int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//System.out.println(rows);
	
		
		//Approach -2 
		// this will count rows of all tables on that page, if only single table then this is fine
		//int rows =driver.findElements(By.tagName("tr")).size(); 
		//System.out.println(rows);
		
		
		
		//FIND NUMBER OF COLUMNS IN TABLE
		//int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
		//System.out.println(columns);
		
		
		
		//READ DATA FROM SPECIFIC ROW AND COLUMN(row 5, column 1)
		//String s = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		//System.out.println(s);
		
		
		//READ DATA FROM ALL ROWS AND COLUMNS
		
		/*System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
		for (int r=2;r<=rows;r++)
		{
			for (int c=1;c<=columns;c++)
			{
				String s = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(s+"\t"); // \t will add one tap space after value
			}
			System.out.println();
		}*/
		
		
		//PRINT BOOKNAME WHOSE AUTHOR IS MUKESH	
		/*int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		for (int r=2;r<=rows;r++)
		{	
				if(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText().equals("Mukesh"))
				{
						WebElement Bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]"));
						System.out.println(Bookname.getText());
				}
		}*/
		
		
		//FIND TOTAL PRICE OF ALL BOOKS
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int sum =0;
		for (int r=2;r<=rows;r++)
		{	

			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			//System.out.println(price);
			sum  = sum + Integer.parseInt(price);
			System.out.println(sum);
			
		}
		
		
	}

}
