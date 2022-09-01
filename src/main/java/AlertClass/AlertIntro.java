package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        WebElement message=driver.findElement(By.id("result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");
    }
    @Test
    public void Dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        String actual=alert.getText();
        String expected="I am a JS Confirm";
        Assert.assertEquals(actual,expected);
        alert.dismiss();
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertEquals(BrowserUtils.getText(result),"You clicked: Cancel");
    }

    @Test
    public void SendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
        jsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Noza is the best");
        alert.accept();
        WebElement message= driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: Noza is the best");

    }
}
