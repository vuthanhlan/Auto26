package Feature.Day05;

import UI.RequestDemoPageUI;
import Untils.excelUntils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Sign_in_RequestDemo {
//    public static void main(String[] args) {
//        String excelFilePath ="dataSignIn.xlsx";
//        String sheetName = "sheet1";
//
//        List<Map<String, String>> excelData = excelUntils.readExcelData(excelFilePath, sheetName);
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
//        try{
//            for (Map<String, String> rowData : excelData) {
//                driver.get("https://saucelabs.com/request-demo");
//                String email = rowData.get("Business Email");
//                String firstName = rowData.get("First Name");
//                String lastName = rowData.get("Last Name");
//                String company= rowData.get("Company");
//                String phone =rowData.get("Phone Number");
//                String Interest = rowData.get("Interest");
//                String country =rowData.get("Country");
//                String comment = rowData.get("Comments");
//
//                RequestDemoPageUI requestDemoPageUI = new RequestDemoPageUI(driver);
//                //Nhập email
//                requestDemoPageUI.findTexBoxBusinessEmail().sendKeys(email);
//                //Nhập first name
//                requestDemoPageUI.findTexBoxFirstName().sendKeys(firstName);
//                //Nhập last name
//                requestDemoPageUI.findTexBoxLastName().sendKeys(lastName);
//                //Nhập company
//                requestDemoPageUI.findTexBoxCompany().sendKeys(company);
//                //Nhập phone
//                requestDemoPageUI.findTexBoxPhone().sendKeys(phone);
//                //Nhập county
//                WebElement Country = requestDemoPageUI.findTexBoxCountry();
//                Select countrySelect = new Select(Country);
//                countrySelect.selectByVisibleText(country);
//                //Nhập interest
//                WebElement inter = requestDemoPageUI.findTexBoxInterest();
//                Select select = new Select(inter);
//                select.selectByVisibleText(Interest);
//                //Nhập comment
//                requestDemoPageUI.findTexBoxComment().sendKeys(comment);
//                //Tích chọn
//                requestDemoPageUI.findCheckBox().click();
//                //Click button Lets talk
//                requestDemoPageUI.findButtonLetsTalk().click();
//            }
//        }
//        catch(Exception e){
//        }
//         driver.quit();
//    }
public static void main(String[] args) {

//        Đường dẫn file excel
    String excelFilePath = "DataSignIn.xlsx";
    String sheetName = "Sheet1"; //Hoặc thay bằng tên sheet bất kỳ trong file

//        Đọc dữ liệu từ file excel
    List<Map<String, String>> excelData = excelUntils.readExcelData(excelFilePath, sheetName);

    // Khởi tạo WebDriver
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    // Khởi tạo WebDriverWait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driver.get("https://saucelabs.com/request-demo/");
//            Duyệt qua từng bản ghi trong dữ liệu
    for (Map<String, String> rowData : excelData) {
        System.out.println("Dữ liệu hàng: " + rowData);
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

        System.out.println("Request success");
    }
    driver.quit();
}
}
