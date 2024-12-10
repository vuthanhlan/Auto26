package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestDemoPageUI {

    private WebDriver driver;

    public void LoginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public RequestDemoPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findLabelBook() {
        return driver.findElement(By.xpath("//span[contains(text(),'Book')]"));
    }
    public WebElement findTextBusinessEmail() {
        return driver.findElement(By.xpath("//label[contains(@id,'LblEmail')]"));
    }
    public WebElement findTexBoxBusinessEmail() {
        return driver.findElement(By.xpath("//input[contains(@id,'Email')]"));
    }

    public WebElement findTextCompany () {
        return driver.findElement(By.xpath("//label[contains(@id,'LblCompany’)]"));
    }

    public WebElement findTexBoxCompany() {
        return driver.findElement(By.xpath("//input[contains(@id,'Company')]"));
    }
}
