package mentoringWithNuradil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class amazon {

    @Test
    public void validateThePrice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 13 pro max case", Keys.ENTER);

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        listOfProducts.get(0).click();

        double actualTotal = 0;
        WebElement price1 = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium']"));

        actualTotal += Double.parseDouble(BrowserUtils.getText(price1).replace("$", ""));
        System.out.println(actualTotal);







    }
}
