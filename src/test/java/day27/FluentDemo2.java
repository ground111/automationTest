package day27;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentDemo2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        FluentWait<WebDriver> mywait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement txtUserName = mywait.until(driver1 -> {
            try {
                WebElement el = driver1.findElement(By.name("username"));
                return el.isDisplayed() ? el : null;
            } catch (Exception e) {
                return null;
            }
        });

        txtUserName.sendKeys("Admin");
    }
}
