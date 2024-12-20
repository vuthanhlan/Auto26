package Feature.Day05;

import Untils.excelUntils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckOutTest {
    private static WebDriver driver;
    public CheckOutTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        //Khỏi tạo webDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("https://www.saucedemo.com/");
        CheckOutTest checkOut = new CheckOutTest(driver);
        Login();
        addItiemButton();
        checkout();


    }

    public static void Login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    public static  void addItiemButton(){
        String excelFilePath = "DataProduct.xlsx";
        String sheetName = "Sheet1";
        //Đọc dữ liệu từ file Excel
        List<Map<String, String>> excelData = excelUntils.readExcelData(excelFilePath, sheetName);

        try {
            //duyệt qua từng bản ghi trong dữ liệu
            for(Map<String, String> rowData : excelData) {
                String product = rowData.get("Products"); //lấy giá trị cot userName
                WebElement addToCart = driver.findElement(By.xpath("//div[contains(text(),'"+product+"')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
                addToCart.click();
            }
        }
        catch (Exception e) {

        }
    }

    public static void checkout(){
        driver.findElement(By.xpath("//a[contains(@class,'cart')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btnCheckOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'check')]")));
        btnCheckOut.click();
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstName.sendKeys("Thanh");

        driver.findElement(By.id("last-name")).sendKeys("Lan");

        driver.findElement(By.id("postal-code")).sendKeys("DP02111");

        driver.findElement(By.id("continue")).click();

        WebElement btnFinish = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        btnFinish.click();
    }
}
