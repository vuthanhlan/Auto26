package feature.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImplicitWaitExampleTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://saucelabs.com/request-demo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Chờ cho phần tử Email xuất hiện
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        firstNameField.sendKeys("test@gmail.com");

        //Cờ cho nút submit có thể nhấp
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@type,'sub')]")));
        submitButton.click();

//        driver.quit();
    }
}
