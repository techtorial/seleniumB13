package MentoringWithAhmet.com.test.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManagerPage {

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addButton;

    public void CustomerInformation(WebDriver driver,String firstName,String lastName,String postCode){
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        addButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Customer added successfully with customer id :6");
        alert.accept();

    }


}
