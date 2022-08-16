package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLocators {

    /*
    NOTE:You can use any locator you want(id,classname,xpath,tagname....)
    TASK 1:
    1-Navigate to the website http://www.testdiary.com/training/selenium/selenium-test-page/
    2-print out selenium test page from website
    3-print out the paragraph from the  page
    4-Check the selenium box is displayed or not, if it is displayed and not selected then click
    5-Click java radio button
    6-Click Save
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Selenium Test Page')]"));
        System.out.println(header.getText().trim());
        WebElement paragraph=driver.findElement(By.xpath("//strong[contains(text(),'test')]"));
        System.out.println(paragraph.getText().trim());
        WebElement seleniumBox=driver.findElement(By.id("seleniumbox"));
        if(seleniumBox.isDisplayed()&&!seleniumBox.isSelected()){
            seleniumBox.click();
        }else{
            System.out.println("Selenium is already checked");
        }
        WebElement javaRadioButton=driver.findElement(By.xpath("//input[@id='java1']"));
        javaRadioButton.click();
        WebElement saveButton=driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        saveButton.click();

          /*
    TASK 2:HyperLink Task:
    1-Click the Test Dairy link with linktext
    2-print out the header,title and currentUrl of Test Dairy from opening page
    3-Navigate back to main page
    4-Click Test Diary Selenium learning with PartialLinkText
    5-print out the header,title and currentUrl of Test Dairy from opening page
     */

        WebElement dairyLink=driver.findElement(By.linkText("Test Diary"));
        dairyLink.click();
        WebElement headerr=driver.findElement(By.tagName("h1"));
        System.out.println(headerr.getText().trim());
        System.out.println(driver.getTitle().trim());
        System.out.println(driver.getCurrentUrl().trim());


    }

    /*
    TASK 3:Contact Form
    1-Fill the all the boxes (yourname,youremail,subject and your message)
    2-Click save button
    3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."
     */
}
