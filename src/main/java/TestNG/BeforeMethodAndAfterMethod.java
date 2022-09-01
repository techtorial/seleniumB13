package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAndAfterMethod {

    @BeforeMethod
    public void establish(){
        System.out.println("I am BeforeMethod Annotation");//3
    }

    @Test
    public void test1(){
        System.out.println("I am test 1");
    }

    @Test
    public void test2(){
        System.out.println("I am test 2");
    }

    @Test
    public void test3(){
        System.out.println("I am test 3");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("I am AfterMethod");//3
    }
}
