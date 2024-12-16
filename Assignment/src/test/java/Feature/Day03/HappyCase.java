package Feature.Day03;

import UI.RequestDemoPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HappyCase {
    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;
    public HappyCase(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        HappyCase HappyCase = new HappyCase(driver);
        HappyCase.requestDemoPageUI.findTexBoxBusinessEmail().sendKeys("abc@gmail.com");
        Thread.sleep(1000);

        HappyCase.requestDemoPageUI.findTexBoxCompany().sendKeys("Techcombank");
        Thread.sleep(1000);

        HappyCase.requestDemoPageUI.findTexBoxPhone().sendKeys("0325417444");
        Thread.sleep(1000);

        WebElement InterestValue = HappyCase.requestDemoPageUI.findTexBoxInterest();
        Select select2 = new Select(InterestValue);
        select2.selectByValue("Scalable Test Automation");
        Thread.sleep(1000);

        HappyCase.requestDemoPageUI.findTexBoxComment().sendKeys("We can walk you throungh a custom demo");
        Thread.sleep(1000);

        HappyCase.requestDemoPageUI.findCheckBox().click();
        Thread.sleep(1000);

        HappyCase.requestDemoPageUI.findButtonLetsTalk().click();
        Thread.sleep(1000);

        driver.quit();



    }
}
