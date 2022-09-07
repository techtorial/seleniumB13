package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
        //You can use to setup your chrome browser properties
        //You can delete your cookies
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest Annotation");
        //you can use to launch your browser
        //WebDriver driver= DriverHelper.getDriver()
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass Annotation");
        //You can navigate to the website
    }

    @BeforeMethod //2
    public void beforeMethod(){
        System.out.println("BeforeMethod Annotation");
        //driver initialization. WebDriver driver= DriverHelper.getDriver()
        //driver.get(url)
        //You can use to login the website
    }

    @Test
    public void test(){ //1
        System.out.println("Test Annotation");
    }

    @Test
    public void test2(){//1
        System.out.println("Test2 Annotation");
    }

    @AfterMethod //2
    public void afterMethod(){
        System.out.println("AfterMethod annotation");
        //You can teardown under that(driver.quit)
        //You can take screenshot for failed test annotations
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite annotation");
    }






}
