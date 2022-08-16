package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectPractice {

    @Test
    public void validateFirstOptionCountry() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml%20(2).html");
        WebElement boxForCountry=driver.findElement(By.name("country"));
        Select countryBox=new Select(boxForCountry);
        WebElement firstOption=countryBox.getFirstSelectedOption();
        String actualOption=firstOption.getText().trim();
        String expectedOption="UNITED STATES";
        Assert.assertEquals(actualOption,expectedOption);
        countryBox.selectByVisibleText("TURKEY");
        Thread.sleep(3000);
        boxForCountry=driver.findElement(By.name("country"));
        countryBox=new Select(boxForCountry);
        firstOption=countryBox.getFirstSelectedOption();
        String actualText=firstOption.getText().trim();
        String expectedText="TURKEY";
        Assert.assertEquals(actualText,expectedText);

    }
    /*
    STEP BY STEP USAGE OF SELECT CLASS:
    1-You need to setup your automation.(webdriverManager,webdriver,maximize,get)
    2-You need to check the tag name of box(dropdown)-->if it is select tag name then use Select Class
    3-First we need to find the location of element and store as WebElement.(boxForCountry)
    4-Then We need to instantiate Select object with meaningfulName then provide the location of
    element as parameter.(Select countryBox=new Select(boxForCountry)
    5-Use select methods to be able to do your actions.(GetFirstSelectionOption,GetOptions,SelectValue..)
    6-Validate your expected and actual.
     */

}
