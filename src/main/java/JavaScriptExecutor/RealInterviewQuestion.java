package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class RealInterviewQuestion {

    @Test
    public void question(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com/");
        WebElement videoButton=driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-display jw-button-color jw-reset']"));
        WebElement weatherButton=driver.findElement(By.xpath("//a[.='Warm-Weather Treats']"));
        BrowserUtils.scrollWithJS(driver,weatherButton);
        videoButton.click();
       // BrowserUtils.clickWithJS(driver,videoButton);

    }
}
