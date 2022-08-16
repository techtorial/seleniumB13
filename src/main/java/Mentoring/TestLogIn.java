package Mentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLogIn {
    @Test
    public void testing() throws NoSuchFieldException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement usernameField
                = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        WebElement passwordField
                = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
        WebElement loginBtn
                = driver.findElement(By.xpath("//button[@name=\"login\"]"));

    usernameField.sendKeys("jkda;kfjdas;j");
    passwordField.sendKeys("lkdasjfoiwrahfjgksd");
    loginBtn.click();
        WebElement errorMessage
                = driver.findElement(By.xpath("//div[contains(text(),\"The email or mobile number you entered isn’t connected to an account.\")]"));
    if(!errorMessage.isDisplayed())
    {
        throw new NoSuchFieldException();
    }


    }
}
