package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//single file upload
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\workspaces\\16-June\\JavaProgramming1\\src\\day6\\ReverseString.java");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("ReverseString.java"))
		{
			System.out.println("File upload sucess");
		}
		else
		{
			System.out.println("Upload failed");
		}
		*/
		
		//Multiple files upload
		String file1 = "C:\\workspaces\\16-June\\JavaProgramming1\\src\\day6\\ReverseString.java";
		String file2 = "C:\\workspaces\\16-June\\JavaProgramming1\\src\\day6\\ReverseStringUSingStringBuffer.java";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);
		
		int noOfFileUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		//validation 1 - number of files
		if(noOfFileUploaded==2)
		{
			System.out.println("all files are uploaded");
		}
		else 
		{
			System.out.println("All files not uploaded");
		}
		
		
		//validation 2 - file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("ReverseString.java")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("ReverseStringUSingStringBuffer.java") )
		{
			System.out.println("all files are uploaded - validated by names");
		}
		else 
		{
			System.out.println("All files not uploaded - validated by names");
		}
	}

}
