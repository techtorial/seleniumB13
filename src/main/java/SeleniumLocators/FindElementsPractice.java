package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {

    /*
    TASK 1:
    1-navigate to the internet-herokuapp
    2-print out all the links
     */

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//li"));
        for(WebElement link:allLinks){
            System.out.println(link.getText().trim());
        }

         /*
         TASK 2:
         3-I want you print out only the ones that length is less than 12
         4-print out how many of them are less than 12
          */
        int counter=0;
            for(WebElement link:allLinks){
                if(link.getText().length()<12){
                    System.out.println(link.getText().trim());
                    counter++;
                }
            }
        System.out.println(counter);
    }
}
