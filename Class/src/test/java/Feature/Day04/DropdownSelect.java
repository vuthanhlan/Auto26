package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement interestDropdown = driver.findElement(By.xpath("//select[contains(@id,'Solution')]"));
        Select select = new Select(interestDropdown);
//        select.selectByValue("Replace DIY (In-house) Testing");
//        select.selectByIndex(6);
        select.selectByVisibleText("Test Analytics ");
        Thread.sleep(2000);

        driver.quit();
    }

}
