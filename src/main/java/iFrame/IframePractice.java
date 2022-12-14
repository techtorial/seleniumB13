package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class IframePractice {
    /*
    1-Navigate to the https://the-internet.herokuapp.com/frames
    2-Click iframe
    3-print out the header "An iFrame containing the TinyMCE WYSIWYG Editor"
    4-clear the message part and send "I love Selenium"
     */
    @Test
    public void iframePractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        WebElement iframe=driver.findElement(By.linkText("iFrame"));
        iframe.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.tagName("p"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement selenium=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        selenium.click();
    }
}
