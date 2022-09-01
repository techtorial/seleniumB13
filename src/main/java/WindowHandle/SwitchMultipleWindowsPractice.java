package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindowsPractice {

    /*
    1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
    2-Click open multiple tabs under Button 4
    3-Switch driver to the Basic Control and fill all the blanks
    4-Click Register button and validate the message "Registration is Successful"
    5-Switch driver to the alertsDemo page and click the any of the "Click Me" button
    6-quit all the pages.
    7-Proud of yourself
     */
    @Test
    public void practiceMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollWithJS(driver, button4);
        button4.click();
        BrowserUtils.switchByTitle(driver, "Basic Controls");
        WebElement registerBtn = driver.findElement(By.id("registerbtn"));
        BrowserUtils.scrollWithJS(driver,registerBtn );
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Baldir");
        WebElement languages = driver.findElement(By.id("englishchbx"));
        languages.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("ahmet@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("ahmet123");
        registerBtn.click();
        WebElement message=driver.findElement(By.xpath("//label[@id='msg']"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(actualMessage.equals(expectedMessage));
        Assert.assertFalse(!actualMessage.equals(expectedMessage));
        Assert.assertEquals(BrowserUtils.getText(message),"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement alertBox=driver.findElement(By.id("alertBox"));
        alertBox.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
