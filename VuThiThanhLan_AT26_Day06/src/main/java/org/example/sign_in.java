package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sign_in {
    ChromeDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void run(){
        // Bước 1 mở trình duyệt trang chủ
        driver.get("https://pos.mephar.com/auth/sign-in/");
        sleep(1000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/input[1]")).sendKeys("devtest01");
        sleep(1000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/span[1]/input[1]")).sendKeys("12345678");
        sleep(1000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]")).click();
        sleep(1000);

        String expecttedUrl="https://pos.mephar.com/";
        System.out.println(driver.getCurrentUrl());

    }
    @AfterMethod
    public void cleanUp(){}

    private void sleep(int time){
        try {
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
