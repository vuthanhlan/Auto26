package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleRadioButtonSelectionTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement radioButton = driver.findElement(By.id("vfb-7-2"));
        radioButton.click();
        Thread.sleep(1000);

        //Lấy giá trị và trạng thái của radio button
        String value = radioButton.getAttribute("value");
        boolean isSelected = radioButton.isSelected();

        //In ra giá trị và trạng thái đã chọn
        System.out.println("Radio Button value selected: "+ value);
        System.out.println("Radio Button isSelected: "+ isSelected);

        driver.quit();
    }
}
