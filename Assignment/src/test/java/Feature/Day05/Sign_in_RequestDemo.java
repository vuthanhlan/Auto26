package Feature.Day05;

import UI.RequestDemoPageUI;
import Untils.excelUntils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Sign_in_RequestDemo {
    public static void main(String[] args) {
        String excelFilePath ="dataSignIn.xlsx";
        String sheetName = "sheet1";

        List<Map<String, String>> excelData = excelUntils.readExcelData(excelFilePath, sheetName);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;

        try{
            for (Map<String, String> rowData : excelData) {
                driver.get("https://saucelabs.com/request-demo");
                String email = rowData.get("Business Email");
                String firstName = rowData.get("First Name");
                String lastName = rowData.get("Last Name");
                String company= rowData.get("Company");
                String phone =rowData.get("Phone Number");
                String Interest = rowData.get("Interest");
                String country =rowData.get("Country");
                String comment = rowData.get("Comments");

                RequestDemoPageUI requestDemoPageUI = new RequestDemoPageUI(driver);

                //Nhập email
                requestDemoPageUI.findTexBoxBusinessEmail().sendKeys(email);

                //Nhập first name
                requestDemoPageUI.findTexBoxFirstName().sendKeys(firstName);

                //Nhập last name
                requestDemoPageUI.findTexBoxLastName().sendKeys(lastName);

                //Nhập company
                requestDemoPageUI.findTexBoxCompany().sendKeys(company);

                //Nhập phone
                requestDemoPageUI.findTexBoxPhone().sendKeys(phone);

                //Nhập county
                WebElement Country = requestDemoPageUI.findTexBoxCountry();
                Select countrySelect = new Select(Country);
                countrySelect.selectByVisibleText(country);

                //Nhập interest
                WebElement inter = requestDemoPageUI.findTexBoxInterest();
                Select select = new Select(inter);
                select.selectByVisibleText(Interest);

                //Nhập comment
                requestDemoPageUI.findTexBoxComment().sendKeys(comment);
                //Tích chọn
                requestDemoPageUI.findCheckBox().click();


                //Click button Lets talk
                requestDemoPageUI.findButtonLetsTalk().click();

            }

        }
        catch(Exception e){

        }


    }
}
