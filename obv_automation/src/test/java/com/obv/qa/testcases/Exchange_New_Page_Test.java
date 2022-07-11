package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Exchange_New_Page;
import com.obv.qa.pages.Future_Price_For_New_page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Exchange_New_Page_Test extends TestBase {
    Exchange_New_Page exchange_new_page;

    String sheet = "Exchange_New";

    public Exchange_New_Page_Test()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        exchange_new_page=new Exchange_New_Page();
    }

    @DataProvider
    public Object[][] getBookExchange_NewTestData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }


    @Test(dataProvider = "getBookExchange_NewTestData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven, String my_eMake, String my_eModel, String my_eTrim) throws InterruptedException {
//        exchange_new_page.newFillForm("1","BMW","X1","SDRIVE 20I SPORTX BS6","2021","1000","BMW","3 Series","M340I");
        String validationString=exchange_new_page.newFillForm(my_category, my_make, my_model, my_trim, my_year, my_kms_driven, my_eMake, my_eModel, my_eTrim);

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
