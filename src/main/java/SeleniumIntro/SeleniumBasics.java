package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //We are setting up our automation
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //window user need to put chromedriver.exe
        WebDriver driver = new ChromeDriver();
        //maximize-->will maximize your window/screen
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");//get -->method navigates to the website that you want
        System.out.println(driver.getTitle()); //getTitle method gives you the title of page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page - Techtorial";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        //driver.getCurrentUrl-->it gives you the url of the page.
        //Command+option +L to organize your codes
        //Control+Alt + L to organize your codes
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techtorialacademy.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();//it closes your driver
    }

}
