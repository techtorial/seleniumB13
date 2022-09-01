package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {
    /*
            TASK:
            1-login successfully-->username--demo password -->demo
            2-validate(ASSERT) title -->Dashboard
             */
    @Test
    public void validateTitleAndUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualUrl.contains(expectedUrl), true);
    }

    /*
       TASK:1-Click Catalog Button and VALIDATE the product option is on the list.
        */
    @Test
    public void validateProductOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogOption.click();
        WebElement productOption = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productOption.isDisplayed());
    }

    /*
           1-Create for loop(starts from i=1) not click first box because it selects everythng
           2-Find the all boxes elements and store them in the List
           3-Validate all boxes are displayed(1 one 1 in for loop)
           4-Click the box and validate the box is selected after that.
            */
    @Test
    public void validateTheBoxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogOption.click();
        Thread.sleep(2000);
        WebElement productOption = driver.findElement(By.xpath("//a[.='Products']"));
        productOption.click();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allBoxes.get(i).click();
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            Assert.assertTrue(allBoxes.get(i).isSelected());
        }
    }

    @Test
    public void validateIsProductAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogOption.click();
        Thread.sleep(2000);
        WebElement productOption = driver.findElement(By.xpath("//a[.='Products']"));
        productOption.click();
        Thread.sleep(3000);
        List<WebElement> allBrands = driver.findElements(By.xpath("//tr//td[3]"));//indexing -->suggested for tables

        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();

        for (int i = 1; i < allBrands.size(); i++) {
            actualBrands.add(allBrands.get(i).getText().trim());
            expectedBrands.add(allBrands.get(i).getText().trim());
            Collections.sort(expectedBrands);
            Assert.assertEquals(actualBrands, expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
    }


    /*
    HOMEWORK:Validation for the functionality of ProductName Button

    1-Click productName button
    2-Then validate the all brands are descending order.
    TIPS:Think about Collections.sort and Collections.reverse.
    TIPS2:Similar logic with ascending order but you need couple more steps to complete this task
       1-Click ProductName
       2-Reverse the list
     */

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogOption.click();
        Thread.sleep(2000);
        WebElement productOption = driver.findElement(By.xpath("//a[.='Products']"));
        productOption.click();
        Thread.sleep(3000);
        WebElement productName = driver.findElement(By.xpath("//a[@class='asc']"));
        productName.click();
        Thread.sleep(2000);
        List<WebElement> allBrands = driver.findElements(By.xpath("//tr//td[3]"));//indexing -->suggested for tables
        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();
        //whenever you need to do comparison for 2 list with String value.It goes to ASCII TABLE. It means
        //I suggest you to use either toLowerCase, or UpperCase at the end of GetText().
        for (int i = 1; i < allBrands.size(); i++) {
            actualBrands.add(allBrands.get(i).getText().trim().toLowerCase());
            expectedBrands.add(allBrands.get(i).getText().trim().toLowerCase());
            Collections.sort(expectedBrands);
            Collections.reverse(expectedBrands);
            Assert.assertEquals(actualBrands, expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
    }
}

