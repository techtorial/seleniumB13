package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlaceOrderTest extends TestBase {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }

    @Test
    public void validatePurchaseMessage() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptops();
        LeptopPage leptopPage=new LeptopPage(driver);
        leptopPage.chooseLaptop(driver,"MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.addToCartclick();
        macBookProPage.validateMessage(driver);
        CartPage cartPage=new CartPage(driver);
        macBookProPage.clickCartButton();
        cartPage.clickPlaceOrderButton();
        PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver);
        placeOrderPage.fillAllInformation("Mustafa","Syria","Ankara",
                "123 123 123","05","2023");
        Assert.assertEquals(placeOrderPage.finalMessage(),"Thank you for your purchase!");
        placeOrderPage.clickOkButton();
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
