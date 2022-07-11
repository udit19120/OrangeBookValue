package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Future_Price_For_Used_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Future_Price_For_Used_Page_Test extends TestBase {
    Future_Price_For_Used_Page future_price_for_used_page;
    String sheet = "Future_Used";

    public Future_Price_For_Used_Page_Test()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        future_price_for_used_page=new Future_Price_For_Used_Page();
    }


    @DataProvider
    public Object[][] getFutureUsedData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getFutureUsedData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven, String my_resale_year, String my_kms_per_year) throws InterruptedException {
//        future_price_for_used_page.newFillForm("1","Hyundai","Creta","SX 1.5 DIESEL BS6","2022","20000", "2023","15000");
//        future_price_for_used_page.newFillForm("2","KTM","Rc","125CC BS6","2021","1000","2023","1000");
//        future_price_for_used_page.newFillForm("3","BMW","C 400 GT","Standard BS6","2021", "1000", "2023","1000");
        String validationString=future_price_for_used_page.newFillForm(my_category, my_make, my_model, my_trim, my_year, my_kms_driven, my_resale_year, my_kms_per_year);

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
