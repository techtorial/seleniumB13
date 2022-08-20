package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeysPractice {

    @Test
    public void KeysPractice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.google.com/");
        //TASK:Find the xpath of Google search bar
        //and sendKeys Selenium
        WebElement searchBar=driver.findElement(By.xpath("//input[@name='q']"));
        searchBar.sendKeys("Selenium", Keys.ENTER);
    }
}
