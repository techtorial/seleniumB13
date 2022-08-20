package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class ClickAndHold {
    @Test
    public void clickAndHold() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement closeCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        //The reason i create action class to show you that you can use click method from actions as well
        Actions actions = new Actions(driver);
        actions.click(closeCookies).perform();
        actions.scrollByAmount(200, 200);
        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage= BrowserUtils.getText(blueBox);
        String expectedMessage="Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.clickAndHold(circle).moveToElement(blueBox).release().perform();
        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfter=BrowserUtils.getText(blueBox);
        String expectedMessageAfter="You did great!";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);

        String actualColor=blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void DragAndDropPractice(){
        /*
        1-navigate to the website https://demoqa.com/droppable
        2-Validate the message inside of the Big box us "Drop Here" -->first validation
        3-Get the "Drag me" box and put it into Big box -->DragAndDrop Method
        4-Validate the message turned to the "Dropped"
        5-Validate the color turned to the "rgba(....)-->you guys know how to get it.
         */
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://demoqa.com/droppable");
       WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement dropMe=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
       String actualMessage=BrowserUtils.getText(dropMe);
       String expectedMessage="Drop here";
       Assert.assertEquals(actualMessage,expectedMessage);
       Actions actions =new Actions(driver);
       actions.dragAndDrop(dragMe,dropMe).perform();
       String actualMessageAfter=BrowserUtils.getText(dropMe);
       String expectedMessageAfter="Dropped!";
       Assert.assertEquals(actualMessageAfter,expectedMessageAfter);
       String actualColor=dropMe.getCssValue("background-color");
       String expectedColor="rgba(70, 130, 180, 1)";
       Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void ClickAndHoldPractice(){

        /*
 1-Navigate to the website "https://demoqa.com/droppable"
 2-Click Accept
 3-Validate message is still "Drop here"
 4-Click and hold notAccepted box and release to the Drop box
 5-Click and hold acceptable box and release to Drop box
 6-Validate the message is "Drop here"
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.linkText("Accept"));
        acceptButton.click();
        WebElement notAcceptable=driver.findElement(By.id("notAcceptable"));
        WebElement bigBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessageBefore=BrowserUtils.getText(bigBox);
        String expectedMessageBefore="Drop here";
        Assert.assertEquals(actualMessageBefore,expectedMessageBefore);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(bigBox).release().perform();
        String actualMessageAfter=BrowserUtils.getText(bigBox);
        String expectedMessageAfter="Drop here";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);

    }
}
