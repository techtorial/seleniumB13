package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void nestedFramePractice(){
        SoftAssert softAssert=new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        WebElement nestedFrame=driver.findElement(By.partialLinkText("Nested"));
        nestedFrame.click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement text=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
      //  Assert.assertTrue(BrowserUtils.getText(text).equals("LEFT"));
        softAssert.assertEquals(BrowserUtils.getText(text),"LEFTghghg");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle=driver.findElement(By.id("content"));
        Assert.assertEquals(BrowserUtils.getText(middle),"MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
    //    Assert.assertEquals(BrowserUtils.getText(right),"RIGHT");
        softAssert.assertEquals(BrowserUtils.getText(right),"RIGHT");
//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main html
        driver.switchTo().defaultContent();//it directly goes to the html(which is the most useful one)
        driver.switchTo().frame("frame-bottom");//BOTTOM FRAME
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
       // Assert.assertEquals(BrowserUtils.getText(bottom),"BOTTOM");
        softAssert.assertEquals(BrowserUtils.getText(bottom),"BOTTOM");
        System.out.println("IT COMPLETED EVERYTHING");
        softAssert.assertAll();
    }
}
   /*
   1-Get and validate Middle text
   2-Get and validate Right Text
   BONUS:Get and validate BOTTOM TEXT
    */