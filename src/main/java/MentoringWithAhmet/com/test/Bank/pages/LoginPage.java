package MentoringWithAhmet.com.test.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerButton;

    public void clickManagerButton(){
        managerButton.click();
    }
}
