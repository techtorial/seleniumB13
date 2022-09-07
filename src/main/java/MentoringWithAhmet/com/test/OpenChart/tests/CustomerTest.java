package MentoringWithAhmet.com.test.OpenChart.tests;

import MentoringWithAhmet.com.test.OpenChart.pages.CustomerPage;
import MentoringWithAhmet.com.test.OpenChart.pages.LoginPage;
import MentoringWithAhmet.com.test.OpenChart.pages.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerTest extends  TestBase{

   @Parameters({"firstName","lastName"})
    @Test
    public void validateMessage(String name,String lastname ){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login();
        MainPage mainPage=new MainPage(driver);
        mainPage.validateInformation();
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerInformation(name,lastname);
    }
}
