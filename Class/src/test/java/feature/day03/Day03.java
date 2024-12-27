package feature.day03;

import UI.RequestDemoPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03 {
    static ChromeDriver driver;
    private static RequestDemoPageUI loginPageUI = null;

    public void Day03(RequestDemoPageUI loginPageUI) {
        Day03.loginPageUI = loginPageUI;
    }

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://saucelabs.com/request-demo");
//        Thread.sleep(2000);
        driver.get("https://demo.guru99.com/test/upload/");
//        String getUrl = driver.getCurrentUrl();
//        System.out.println("Đường dẫn web là: "+getUrl);

//        WebElement inputEmail = driver.findElement(By.id("Email"));
//        inputEmail.sendKeys("saucelabs@gmail.com");
//        Thread.sleep(2000);
////        inputEmail.clear();
//        inputEmail.isEnabled();

//        WebElement btn_TryItFree = driver.findElement(By.linkText("Try it free"));
//        WebElement btn_TryItFree = driver.findElement(By.partialLinkText("Try"));
//        btn_TryItFree.click();

//        WebElement header = driver.findElement(By.tagName("h1"));
//        System.out.println("Header text: "+ header.getText());


        // Tìm tất cả thẻ button
//        List<WebElement> btns = driver.findElements(By.tagName("button"));
//        System.out.println("\nButton:");
//        for(WebElement btn: btns) {
//            System.out.println(btn.getText());
//        }

        //Tìm phần tử theo CSS selector: tất cả các nút <button>
//        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
//        for (WebElement button : buttons) {
//            System.out.println(button.getText());
//
//        }

        //Tìm phần ử theo CSS Selector: input có name là "Email"
//        WebElement emailInput = driver.findElement(By.cssSelector("input[name='Email'"));
//        inputEmail.sendKeys("thanhlan@gmail.com");


        String filePath = "D:/doc";

        WebElement uploadFiled = driver.findElement(By.id("uploadfile_0"));
        uploadFiled.sendKeys(filePath);


    }
}
//Một số CSS Selector phổ biến:
//tagName.className:
//Tìm thẻ với class cụ thể. Ví dụ: button.submit (tìm thẻ <button> có class là submit).
//
//tagName#id:
//Tìm thẻ với ID cụ thể. Ví dụ: input#email (tìm thẻ <input> có ID là email).
//
//tagName[attribute='value']:
//Tìm thẻ với thuộc tính và giá trị cụ thể. Ví dụ: input[name='email'].
//
//tagName > child:
//Tìm phần tử con trực tiếp. Ví dụ: div > p (tìm <p> là con trực tiếp của <div>).
//
//tagName:first-child:
//Tìm phần tử con đầu tiên. Ví dụ: li:first-child.