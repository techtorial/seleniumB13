package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    //TASK: Can you create a method  which accepts 2 parameters and
    //returns the multiplication of these two numbers.

    public int multiplication(int number1, int number2){
        return number1*number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResults=multiplication(3,4);
        int expectedResults=12;
        Assert.assertEquals(actualResults,expectedResults);
    }

    @Test
    public void validateZero(){
        int actualResult=multiplication(0,999);
        int expectedResult=0;
        Assert.assertEquals(actualResult,expectedResult);
    }
}
