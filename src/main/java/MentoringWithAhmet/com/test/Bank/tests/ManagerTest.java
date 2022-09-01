package MentoringWithAhmet.com.test.Bank.tests;

import MentoringWithAhmet.com.test.Bank.pages.LoginPage;
import MentoringWithAhmet.com.test.Bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ManagerTest {

    /*
    1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
    2-Click Bank Manager Login
    3-Click Add Customer
    4-Fill the blanks and click add customer button
    5-Get the text from pop-up and VALIDATE and click OK
    6-Click Open Account
    7-Choose your name from the list
    8-Choose any currency you want from list
    9-Get the text from pop-up and VALIDATE and click OK
    10-Click Customers Button
    11-Validate your firstname,lastName,PostCode and Account Number
    12-driver.quit
    13-Proud of yourself
     */

    @Test
    public void validateEmployee(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickManagerButton();
        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.CustomerInformation(driver,"Ahmet","Baldir","602343");

    }
}
