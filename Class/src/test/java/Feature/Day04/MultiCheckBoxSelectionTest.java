package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MultiCheckBoxSelectionTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/radio.html");

        // Tìm danh sách các checkbox
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxes.add(driver.findElement(By.id("vfb-6-0")));
        checkboxes.add(driver.findElement(By.id("vfb-6-1")));

        //Click vào từng checkbox và in ra giá trị đã chọn
        for(WebElement checkbox : checkboxes) {
            checkbox.click(); //Chọn checkbox
            System.out.println(checkbox.getAttribute("value"));
        }
        driver.quit();

    }
}
