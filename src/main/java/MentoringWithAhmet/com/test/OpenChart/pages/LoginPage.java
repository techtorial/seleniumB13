package MentoringWithAhmet.com.test.OpenChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement username;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    public void login(){
        username.sendKeys(ConfigReader.readProperty("openchartusername"));
        password.sendKeys(ConfigReader.readProperty("openchartpassword"));
        loginButton.click();

    }


}
