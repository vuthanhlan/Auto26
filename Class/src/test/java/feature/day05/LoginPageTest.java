package feature.day05;

import Untils.ExcelUntils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginPageTest {



    public static void main(String[] args) throws InterruptedException {

        String excelFilePath = "dataLogin.xlsx";
        String sheetName = "Sheet1";

        //Đọc dữ liệu từ file Excel
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
                //duyệt qua từng bản ghi trong dữ liệu
            for(Map<String, String> rowData : excelData) {
                System.out.println("Dữ liệu hàng"+rowData);
                String user = rowData.get("Username"); //lấy giá trị cot userName
                String pass = rowData.get("Password");
                driver.get("https://www.saucedemo.com/");
                driver.findElement(By.id("user-name")).sendKeys(user);
                Thread.sleep(2000);
                driver.findElement(By.id("password")).sendKeys(pass);
                Thread.sleep(2000);
                driver.findElement(By.id("login-button")).click();

                Thread.sleep(2000);
            }
        }
        catch (Exception e) {

        }



    }
}
