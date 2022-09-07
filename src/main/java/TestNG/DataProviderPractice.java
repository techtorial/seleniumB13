package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    //it runs the SAME TEST with a different SET OF DATA.

//    @DataProvider(name = "FullName")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"mehmet","321","4343"},
//                {"malika","786","43434"},
//                {"damla","312","43434"},
//                {"ion","665","434343"},
//                {"ahmet","656","43434"}
//        };
//    }

    @Test(dataProvider = "FullName",dataProviderClass = FullNameDataProvider.class)
    public void test(String username,String password,String creditCard ){
        System.out.println(username + password +creditCard);
    }
//    @Test
//    public void test1(){
//        String username="Malika";
//        String password="756";
//        System.out.println(username + password);
//    }
//    @Test
//    public void test2(){
//        String username="Damla";
//        String password="987";
//        System.out.println(username + password);
//    }
//    @Test
//    public void test3( ){
//        String username="Ion";
//        String password="966";
//        System.out.println(username + password);
//    }
//    @Test
//    public void test4( ){
//        String username="Ahmet";
//        String password="123";
//        System.out.println(username + password);
//    }
}
