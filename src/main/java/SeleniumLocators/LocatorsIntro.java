package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml%20(2).html");
        //ID LOCATOR
       WebElement header= driver.findElement(By.id("techtorial1"));//it will find the elements with specific locators
        String actualHeader=header.getText();//getText method -->gets the text and return String
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //Name Locator
        WebElement firstNameBox=driver.findElement(By.name("firstName"));
        firstNameBox.sendKeys("Ahmet");//SendKeys method sends the data that you want.
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("baldir");
        WebElement phoneNumber=driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("123213");
        WebElement email=driver.findElement(By.id("UserName"));
        email.sendKeys("123213");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("501 midway");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Mount Prospect");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60056");

         //CLASSNAME LOCATOR
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        //ISDISPLAYED and ISSELECTED METHOD?

        WebElement javaBox=driver.findElement(By.id("cond1"));//i have box now
        System.out.println(javaBox.isDisplayed());//true
        if(javaBox.isDisplayed()){
            javaBox.click();
            System.out.println(javaBox.isSelected());//true
        }else{
            System.out.println("Box is not displayed");
        }
        WebElement testNgBox=driver.findElement(By.id("cond3"));
        if(testNgBox.isDisplayed()){
            testNgBox.click();
            System.out.println(testNgBox.isSelected());
        }

        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        if(cucumberBox.isDisplayed()){
            cucumberBox.click();
            System.out.println(cucumberBox.isSelected());
        }











    }
}
