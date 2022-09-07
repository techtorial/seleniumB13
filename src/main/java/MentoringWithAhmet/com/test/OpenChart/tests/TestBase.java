package MentoringWithAhmet.com.test.OpenChart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("opencharturl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            BrowserUtils.getScreenShot(driver,"openchart");
        }
      //  driver.quit();
    }
}
