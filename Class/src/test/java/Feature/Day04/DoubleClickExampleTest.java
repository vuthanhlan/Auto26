package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import javax.swing.*;

public class DoubleClickExampleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement button = driver.findElement(By.tagName("button"));

        WebElement button1 = driver.findElement(By.xpath("//span[contains(@class,'context')]"));

        Actions actions = new Actions(driver);

        actions.doubleClick(button).perform();
        Thread.sleep(1000);



        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after double click: "+alertText);

        driver.switchTo().alert().accept();

        actions.contextClick(button1).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[contains(@class,'edit')]")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        driver.quit();
    }
}
