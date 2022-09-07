package MentoringWithAhmet.com.test.OpenChart.tests;

import MentoringWithAhmet.com.test.OpenChart.pages.LoginPage;
import MentoringWithAhmet.com.test.OpenChart.pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MainTest extends TestBase{

    @Test
    public void validateData(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login();
        MainPage mainPage=new MainPage(driver);
        mainPage.validateInformation();
    }
}
