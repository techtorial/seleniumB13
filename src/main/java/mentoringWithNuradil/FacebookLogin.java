package mentoringWithNuradil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class FacebookLogin {

    @Test
    public void facebookLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100");

        WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        // to assign the variable
        // alt +enter for windows
        // option +enter for mac
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));

        username.sendKeys("batchAhmet");
        password.sendKeys("batch13");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'mobile number')]"));

        String expectedError = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        String actualError = errorMessage.getText();

        Assert.assertEquals(actualError, expectedError);
        errorMessage.isDisplayed();







    }








}
