package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void validatePositiveLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        Assert.assertEquals(driver.getCurrentUrl(),"http://demo.sentrifugo.com/index.php/index/welcome");
    }
    @Test
    public void validateNegativeLogin1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("","");
        Assert.assertEquals(loginPage.usernameErrorMessage(),"Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(),"Please enter password.");
        Assert.assertEquals(loginPage.usernameErrorColor(),"rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.passwordErrorColor(),"rgba(255, 0, 0, 1)");
    }
}
