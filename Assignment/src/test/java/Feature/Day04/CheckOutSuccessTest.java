package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckOutSuccessTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@name,'back')]")));

        List<WebElement> carts = driver.findElements(By.xpath("//button[contains(@name,'cart')]"));
        for(int i = 0; i < 3; i++){
            carts.get(i).click();
            Thread.sleep(2000);
        }
//        driver.findElement(By.xpath("//button[contains(@name,'back')]")).click();
//        driver.findElement(By.xpath("//button[contains(@name,'jacket')]")).click();
//        driver.findElement(By.xpath("//button[contains(@name,'light')]")).click();

        String NumberCart = driver.findElement(By.xpath("//a[contains(@class,'cart')]")).getText();
        System.out.println("Number of Cart is: " + NumberCart);

        driver.findElement(By.xpath("//a[contains(@class,'cart')]")).click();


        WebElement btnCheckOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'check')]")));
        btnCheckOut.click();

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstName.sendKeys("Thanh");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("Lan");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("DP02111");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();

        WebElement btnFinish = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        String priceActual = driver.findElement(By.xpath("//div[contains(@class,'summary_total_label')]")).getText();
        System.out.println("price is: " + priceActual);

        Assert.assertEquals(priceActual, "Total: $60.45", "Không đúng giá");
        Thread.sleep(2000);
        if(priceActual.equals("Total: $60.45")){
            btnFinish.click();
        }

        Thread.sleep(2000);
      driver.quit();


    }
}
