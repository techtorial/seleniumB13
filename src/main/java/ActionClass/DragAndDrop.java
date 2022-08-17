package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {
    //DRAG AND DROP:
    @Test
    public void dragAndDropPractice(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement closeCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        //The reason i create action class to show you that you can use click method from actions as well
        Actions actions=new Actions(driver);
        actions.click(closeCookies).perform();
        WebElement circle=driver.findElement(By.id("draggable"));
        WebElement orangeBox=driver.findElement(By.xpath("//div[.='... Or here.']"));
        String actualMessage= BrowserUtils.getText(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.dragAndDrop(circle,orangeBox).perform();
        orangeBox=driver.findElement(By.xpath("//div[.='You did great!']"));
        String actualAfterDrop=BrowserUtils.getText(orangeBox);
        String expectedAfterDrop="You did great!";
        Assert.assertEquals(actualAfterDrop,expectedAfterDrop);







    }

}
