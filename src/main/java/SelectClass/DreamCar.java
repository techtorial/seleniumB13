package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX-350
}
     */

    @Test
    public void selectMultiMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cars.com/");
        WebElement newCarDropDown = driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newCarDropDown, "new", "value");
        WebElement makeChoice = driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(makeChoice, "lexus", "value");
        WebElement makeModel = driver.findElement(By.id("models"));
        BrowserUtils.selectBy(makeModel, "lexus-rx_350", "value");

        WebElement priceBox = driver.findElement(By.id("make-model-max-price"));
        Select price = new Select(priceBox);
        WebElement firstOptionPrice = price.getFirstSelectedOption();

        //String actualMessage = firstOptionPrice.getText().trim();
        String actualMessage=BrowserUtils.getText(firstOptionPrice);
        String expected = "No max price";
        Assert.assertEquals(actualMessage, expected);

        WebElement zipCodeDistance = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(zipCodeDistance, "40", "value");
        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        Thread.sleep(2000);
        search.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText().trim();
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement sortBy=driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Lowest price","text");
        Thread.sleep(3000);
        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));

        for(WebElement title:allTitles){
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
        }
    }
}
