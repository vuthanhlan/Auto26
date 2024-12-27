package feature.day07;

import UI.LoginPageUI;
import Untils.ExcelUntils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DataDriverTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPageUI loginPageUI;

    String excelFilePath = "dataLogin.xlsx";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginPageUI = new LoginPageUI(driver);
    }

    public void inputData(String user, String pass) {
        loginPageUI.getTextUser().sendKeys(user);
        loginPageUI.getTextPassword().sendKeys(pass);
    }

    public void clickLogin(){loginPageUI.getButtonLogin().click();}

    @Test
    public void loginSuccess() {
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, "sheet1");
        for(Map<String, String> rowData : excelData) {
            driver.get("https://www.saucedemo.com/");
            inputData(rowData.get("Username"), rowData.get("Password"));
            clickLogin();
            break;
        }

    }

    @Test
    public void loginFailed() {
        int count = 0;
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, "Sheet1");
        for (Map<String, String> rowData : excelData) {
            if (count > 0) {
                driver.get("https://www.saucedemo.com/");
                inputData(rowData.get("Username"), rowData.get("Password"));
                clickLogin();
            }
            count++;
        }

        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
