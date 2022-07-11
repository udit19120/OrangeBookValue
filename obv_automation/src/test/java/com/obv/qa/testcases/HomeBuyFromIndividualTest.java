package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomeBuyFromIndividual;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class HomeBuyFromIndividualTest extends TestBase {
    HomeBuyFromIndividual homeBuyFromIndividual;

    String sheet = "VehicleHome";
    TestUtil testUtil;

    public HomeBuyFromIndividualTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        homeBuyFromIndividual=new HomeBuyFromIndividual();
        testUtil=new TestUtil();
    }
    @DataProvider
    public Object[][] getVehicleData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getVehicleData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) throws InterruptedException {
        String validationString=homeBuyFromIndividual.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms);

        SoftAssert softAssert=new SoftAssert();

        System.out.println("This is validation string "+validationString);

        softAssert.assertNotEquals(-1, validationString.indexOf(my_make));
        System.out.println("Now checking second condition");
        softAssert.assertNotEquals(-1, validationString.indexOf(my_trim));
        softAssert.assertNotEquals(-1, validationString.indexOf(my_model));

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
