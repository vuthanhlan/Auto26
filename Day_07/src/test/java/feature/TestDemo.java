package feature;

import UI.RequestDemoPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDemo {
    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;
    public TestDemo(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        // Tạo instance của TestDemo
        TestDemo testDemo = new TestDemo(driver);
        // Sử dụng requestDemoPageUI
        testDemo.requestDemoPageUI.findTexBoxBusinessEmail().sendKeys("thanhlan05@gmail.com");
        Thread.sleep(1000);
        testDemo.requestDemoPageUI.findTexBoxCompany().sendKeys("Techcombank");
        Thread.sleep(1000);

        testDemo.requestDemoPageUI.findTexBoxPhone().sendKeys("0357894512");
        Thread.sleep(1000);

        WebElement countryValue = testDemo.requestDemoPageUI.findTexBoxCountry();
        Select select1 = new Select(countryValue);
        select1.selectByValue("Afghanistan");
        Thread.sleep(1000);

        WebElement interestValue= testDemo.requestDemoPageUI.findTexBoxInterest();
        Select select = new Select(interestValue);
        select.selectByValue("Scalable Test Automation");
        Thread.sleep(1000);

        testDemo.requestDemoPageUI.findTexBoxComment().sendKeys("We can walk you throungh a custom demo");
        Thread.sleep(1000);

        testDemo.requestDemoPageUI.findCheckBox().click();

        Thread.sleep(5000);
        driver.quit();
    }

}
