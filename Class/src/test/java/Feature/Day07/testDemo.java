package Feature.Day07;

import UI.LoginPageUI;
import Untils.ExcelUntils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class testDemo {
    WebDriver driver;
    WebDriverWait wait;
    LoginPageUI loginPageUI;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @BeforeMethod
    public void setUrl() {
        driver.get("https://www.saucedemo.com/");
        loginPageUI = new LoginPageUI(driver);
    }
    public void inputData(String user, String pass) {
        loginPageUI.getTextUser().sendKeys(user);
        loginPageUI.getTextPassword().sendKeys(pass);
    }

    public void clickLogin(){loginPageUI.getButtonLogin().click();}

    @Test
    public void InputValidUserNameAndPassword() {
        inputData("standard_user", "secret_sauce");
        clickLogin();
    }
    @Test
    public void InputValidUserNameAndInvalidPassword() {

        inputData("standard_user", "aaa");
        clickLogin();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginPageUI.getErrorText()));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals("Error message does not match " + "expected.", "Epic sadface: Username and password do not match any user in this service",actualMessage );
    }

    @Test
    public void InputInvalidUserNameAndValidPassword() {
        inputData("standard", "secret_sauce");
        clickLogin();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginPageUI.getErrorText()));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals("Error message does not match " + "expected.", "Epic sadface: Username and password do not match any user in this service",actualMessage );
    }

    @Test
    public void InputInvalidUserNameAndInvalidPassword() {
        inputData("standard", "secret");
       clickLogin();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginPageUI.getErrorText()));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals("Error message does not match " + "expected.", "Epic sadface: Username and password do not match any user in this service",actualMessage );
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
