package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class PracticeSelectAndLocators {

    /*
    Open this link - https://www.techlistic.com/p/selenium-practice-form.html
Enter first and last name (textbox).
Select gender (radio button).
Select years of experience (radio button).
Enter date.(02-04-2022, 2022/2/4, 2022-04-02)
Select Profession (Checkbox).
Select Automation tools you are familiar with (multiple checkboxes).
Select Continent (Select box).
Select multiple commands from a multi select box. (at least 2)
Click on Submit button.
Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links.
     */

    @Test
    public void fillTheInformation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement genderRadioButton=driver.findElement(By.id("sex-0"));
        genderRadioButton.click();
        WebElement yearExperienceRadioButton=driver.findElement(By.id("exp-3"));
        yearExperienceRadioButton.click();
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("2022-04-02");
        WebElement profession=driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement selenium=driver.findElement(By.id("tool-2"));
        selenium.click();
        WebElement continents=driver.findElement(By.id("continents"));
        BrowserUtils.selectBy(continents,"North America","text");
        WebElement seleniumCommands=driver.findElement(By.id("selenium_commands"));
        BrowserUtils.selectBy(seleniumCommands,"Browser Commands","text");
        BrowserUtils.selectBy(seleniumCommands,"Switch Commands","text");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
    }

    /*
    1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
    2-Fill all the boxes
    3-click Yes radio button for subsription
    4-Click privacy button
    5-Click continue button
    6-Validate Account is created header

    NOTE:To be able get see account is created for you last run make sure you have a different username
    just add ahmet1,ahmet2 like that everytime for validation.(ASSERT)
     */
}
