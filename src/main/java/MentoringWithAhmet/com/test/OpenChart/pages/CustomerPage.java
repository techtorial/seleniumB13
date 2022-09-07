package MentoringWithAhmet.com.test.OpenChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addButton;

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    public void customerInformation(String name,String lastName){
        addButton.click();
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
    }
}
