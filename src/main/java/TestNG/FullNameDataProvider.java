package TestNG;

import org.testng.annotations.DataProvider;

public class FullNameDataProvider {

    @DataProvider(name = "FullName")
    public Object[][] getData(){
        return new Object[][]{
                {"mehmet","321","4343"},
                {"malika","786","43434"},
                {"damla","312","43434"},
                {"ion","665","434343"},
                {"ahmet","656","43434"}
        };
    }


}
