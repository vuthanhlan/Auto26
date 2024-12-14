package Feature.Day08;

import UI.RequestDemoPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UnHappyCase {
    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;
    public UnHappyCase(WebDriver driver) {
        this.driver = driver;
        requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        UnHappyCase unhappyCase = new UnHappyCase(driver);

        unhappyCase.requestDemoPageUI.findTexBoxBusinessEmail().sendKeys("abc@gmail.com");
        Thread.sleep(1000);

        unhappyCase.requestDemoPageUI.findTexBoxCompany().sendKeys("Techcombank");
        Thread.sleep(1000);

        unhappyCase.requestDemoPageUI.findTexBoxPhone().sendKeys("0325417444");
        Thread.sleep(1000);

        unhappyCase.requestDemoPageUI.findTexBoxComment().sendKeys("We can walk you throungh a custom demo");
        Thread.sleep(1000);

        unhappyCase.requestDemoPageUI.findCheckBox().click();
        Thread.sleep(1000);

        unhappyCase.requestDemoPageUI.findButtonLetsTalk().click();
        Thread.sleep(1000);

        driver.quit();
    }
}
