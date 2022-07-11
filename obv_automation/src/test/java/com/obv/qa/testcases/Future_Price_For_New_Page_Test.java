//Giving Error with Product Site but working correct for automation site.
package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Future_Price_For_New_page;
import com.obv.qa.pages.New_Vehicle_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Future_Price_For_New_Page_Test extends TestBase {
    Future_Price_For_New_page future_price_for_new_page;

    String sheet = "Future_New";

    public Future_Price_For_New_Page_Test()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        future_price_for_new_page=new Future_Price_For_New_page();
    }

    @DataProvider
    public Object[][] getFutureNewData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }


    @Test(dataProvider = "getFutureNewData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven) throws InterruptedException {
        String validationString=future_price_for_new_page.newFillForm(my_category,my_make, my_model,my_trim,my_year,my_kms_driven);
        SoftAssert softAssert=new SoftAssert();

        System.out.println("This is validation string "+validationString);

        softAssert.assertNotEquals(-1, validationString.indexOf(my_model));
        softAssert.assertNotEquals(-1, validationString.indexOf(my_make));
        softAssert.assertNotEquals(-1, validationString.indexOf(my_trim));

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }


}
