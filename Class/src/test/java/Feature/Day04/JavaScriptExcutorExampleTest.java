package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptExcutorExampleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement interestDropdown = driver.findElement(By.xpath("//select[contains(@id,'Solution')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Visual Testing';", interestDropdown);

        String selectedValue = interestDropdown.getAttribute("value");
        System.out.println("selected Value: "+selectedValue);

        driver.quit();
    }
}
