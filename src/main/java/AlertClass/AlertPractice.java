package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
        WebElement previewNormal=driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button[@class='preview']"));
        WebElement secondwayPreview=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        secondwayPreview.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement previewSweet=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewSweet.click();
        WebElement text=driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        Assert.assertEquals(BrowserUtils.getText(text),"Something went wrong!");
        WebElement ok = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        ok.click();
    }
}
