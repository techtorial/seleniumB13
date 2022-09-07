package com.test.etsy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("etsyUrl"));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
