package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/techtorial/Desktop/usa.png");
        WebElement update=driver.findElement(By.id("file-submit"));
        update.click();
        WebElement message=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(BrowserUtils.getText(message).equals("File Uploaded!"));
    }
}
