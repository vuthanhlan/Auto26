package Feature.Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement interestDropdown = driver.findElement(By.xpath("//select[contains(@id,'Solution')]"));
        Select select = new Select(interestDropdown);
//        select.selectByValue("Replace DIY (In-house) Testing");
//        select.selectByIndex(6);
        select.selectByVisibleText("Test Analytics ");
        Thread.sleep(2000);

        driver.quit();
    }

}
https://github.com/ZiuHoa/AutoTest/tree/master/src/test/java/UI/checkoutProduct

Chữa bài:
        1. Em nên thêm comment để sau đọc lại code dễ nhìn hơn.
        2. Loại bỏ Thread.sleep: Sử dụng các phương thức chờ động của WebDriverWait để làm việc hiệu quả hơn, buổi trước mình đã học rồi.
        3. Hãy tham khảo đoạn code sau bằng việc nhóm các hành động vào 1 hàm, việc này giúp em tái sử dụng code
public class Inventory {
    private static WebDriver driver;

    public Inventory(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Inventory inventory = new Inventory(driver);

        inventory.login();

        inventory.addItemButton();

        inventory.checkout();

        driver.quit();
    }

    public static void login() {
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
    }

    public static void addItemButton() {
        WebElement addItemButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addItemButton1.click();

        WebElement addItemButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addItemButton2.click();

        WebElement addItemButton3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addItemButton3.click();
    }

    public static void checkout() {
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();

        WebElement buttonCheckout = driver.findElement(By.id("checkout"));
        buttonCheckout.click();

        WebElement inputFirstName = driver.findElement(By.id("first-name"));
        inputFirstName.sendKeys("Hoang Thai");

        WebElement inputLastName = driver.findElement(By.id("last-name"));
        inputLastName.sendKeys("Ha");

        WebElement inputZip = driver.findElement(By.id("postal-code"));
        inputZip.sendKeys("123456");

        WebElement buttonContinue = driver.findElement(By.id("continue"));
        buttonContinue.click();

        WebElement buttonFinish = driver.findElement(By.id("finish"));
        buttonFinish.click();

        WebElement messageComplete = driver.findElement(By.xpath("//span[@class='title']"));
        System.out.println("Message: " + messageComplete.getText());
    }
}
