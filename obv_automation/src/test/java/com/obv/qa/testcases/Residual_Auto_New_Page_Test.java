package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Exchange_Auto_Page;
import com.obv.qa.pages.Residual_Auto_New_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Residual_Auto_New_Page_Test extends TestBase {
    Residual_Auto_New_Page residual_auto_new_page;
    String sheet = "Residual_Auto_New";

    public Residual_Auto_New_Page_Test()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        residual_auto_new_page=new Residual_Auto_New_Page();
    }


    @DataProvider
    public Object[][] getResidualVehicleAutoData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getResidualVehicleAutoData")
    public void FormTest1(String my_vehicle,String my_tenure, String my_kms_month, String auto_in_vehicle) throws InterruptedException {
        String validationString=residual_auto_new_page.newFillForm(my_vehicle, my_tenure, my_kms_month, auto_in_vehicle);
        SoftAssert softAssert=new SoftAssert();

        System.out.println("This is validation string "+validationString);

        softAssert.assertNotEquals(-1, validationString.indexOf(my_vehicle));

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}
//    Honda Amaze 1.2 E MT PETROL BS6