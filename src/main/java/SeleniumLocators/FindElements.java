package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    //Find Elements method
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/techtorial/Downloads/Techtorialhtml%20(2).html");
        List<WebElement> allboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

         for(WebElement box:allboxes){
             if(box.isDisplayed() && !box.isSelected()){
                 box.click();
             }
         }
    }

}
