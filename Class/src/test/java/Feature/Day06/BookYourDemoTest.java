package Feature.Day06;

import Untils.ExcelUntils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class    BookYourDemoTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @BeforeMethod
    public void setUrl() {
        driver.get("https://saucelabs.com/request-demo/");
    }

    @DataProvider(name = "demoData")
    public Object[][] getDemoData() {
        String excelFilePath = "DataSignIn.xlsx";
        String sheetName = "Sheet1"; //Hoặc thay bằng tên sheet bất kỳ trong file

//        Đọc dữ liệu từ file excel
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, sheetName);

        //Chuyển đổi danh sách Map thành 2 chiều
        Object[][] data = new Object[excelData.size()][1];
        for (int i = 0; i < excelData.size(); i++) {
            data[i][0] = excelData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "demoData")
    public void testRequestDemoSuccess(Map<String, String> rowData) {

        String businessEmail = rowData.get("Business Email"); //Lấy giá trị cột Business Email
        String firstName = rowData.get("First Name");
        String lastName = rowData.get("Last Name");
        String company = rowData.get("Company");
        String phoneNumber = rowData.get("Phone Number");
        String country = rowData.get("Country");
        String interest = rowData.get("Interest");
        String comments = rowData.get("Comments");
//nhap du lieu
        driver.findElement(By.id("Email")).sendKeys(businessEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Phone")).sendKeys(phoneNumber);
        WebElement countryDropdownList = driver.findElement(By.id("Country"));
        new Select(countryDropdownList).selectByVisibleText(country);
        WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
        new Select(interestDropdownList).selectByVisibleText(interest);
        driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(comments);
        driver.findElement(By.id("LblmktoCheckbox_44280_0")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void testSubmitNull() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Must be valid email')]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Must\n" +
                "example@yourdomain.com", "Error message does not match " +
                "expected.");
    }
    @Test(dataProvider = "demoData")
    public void testFirstNameNull(Map<String, String> rowData) {
        String businessEmail = rowData.get("Business Email"); //Lấy giá trị cột Business Email
        String firstName = rowData.get("First Name");
        String lastName = rowData.get("Last Name");
        String company = rowData.get("Company");
        String phoneNumber = rowData.get("Phone Number");
        String country = rowData.get("Country");
        String interest = rowData.get("Interest");
        String comments = rowData.get("Comments");
//nhap du lieu
        driver.findElement(By.id("Email")).sendKeys(businessEmail);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName"))).sendKeys(lastName);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Phone")).sendKeys(phoneNumber);
        WebElement countryDropdownList = driver.findElement(By.id("Country"));
        new Select(countryDropdownList).selectByVisibleText(country);
        WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
        new Select(interestDropdownList).selectByVisibleText(interest);
        driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(comments);
        driver.findElement(By.id("LblmktoCheckbox_44280_0")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ValidMsgFirstName')]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "This field is required.", "Error message does not match " +
                "expected.");
    }

    @Test(dataProvider = "demoData")
    public void testLastNameNull(Map<String, String> rowData) {

        String businessEmail = rowData.get("Business Email"); //Lấy giá trị cột Business Email
        String firstName = rowData.get("First Name");
        String lastName = rowData.get("Last Name");
        String company = rowData.get("Company");
        String phoneNumber = rowData.get("Phone Number");
        String country = rowData.get("Country");
        String interest = rowData.get("Interest");
        String comments = rowData.get("Comments");
//nhap du lieu
        driver.findElement(By.id("Email")).sendKeys(businessEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).sendKeys(firstName);

        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Phone")).sendKeys(phoneNumber);
        WebElement countryDropdownList = driver.findElement(By.id("Country"));
        new Select(countryDropdownList).selectByVisibleText(country);
        WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
        new Select(interestDropdownList).selectByVisibleText(interest);
        driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(comments);
        driver.findElement(By.id("LblmktoCheckbox_44280_0")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ValidMsgLastName')]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "This field is required.", "Error message does not match " +
                "expected.");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//String businessEmail = rowData.get(0).get("Business Email");