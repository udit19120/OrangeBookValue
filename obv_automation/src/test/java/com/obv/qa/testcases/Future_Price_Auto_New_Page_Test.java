package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Exchange_Auto_Page;
import com.obv.qa.pages.Future_Price_Auto_New_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Future_Price_Auto_New_Page_Test extends TestBase {
    Future_Price_Auto_New_Page future_price_auto_new_page;

    String sheet = "Future_Auto";

    public Future_Price_Auto_New_Page_Test()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        future_price_auto_new_page=new Future_Price_Auto_New_Page();
    }

    @DataProvider
    public Object[][] getFutureAutoData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getFutureAutoData")
    public void FormTest1(String my_vehicle, String my_year_resale, String my_kms, String auto_in_vehicle) throws InterruptedException {
//        future_price_auto_new_page.newFillForm("hon","2023","1000");
        String validationString=future_price_auto_new_page.newFillForm(my_vehicle, my_year_resale, my_kms, auto_in_vehicle);
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