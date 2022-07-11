package com.obv.qa.testcases;
import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Home_Sell_To_Individual;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;


public class Home_Sell_To_IndividualTest extends TestBase{
    Home_Sell_To_Individual home_sell_to_individual;

    String sheet = "VehicleHome";
    TestUtil testUtil;

    public Home_Sell_To_IndividualTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        home_sell_to_individual=new Home_Sell_To_Individual();
        testUtil=new TestUtil();
    }

    @DataProvider
    public Object[][] getVehicleData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getVehicleData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) throws InterruptedException {
        String validationString=home_sell_to_individual.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms);

        SoftAssert softAssert=new SoftAssert();

        System.out.println("This is validation string "+validationString);

        softAssert.assertNotEquals(-1, validationString.indexOf(my_model));
        softAssert.assertNotEquals(-1, validationString.indexOf(my_make));
        softAssert.assertNotEquals(-1, validationString.indexOf(my_trim));

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
