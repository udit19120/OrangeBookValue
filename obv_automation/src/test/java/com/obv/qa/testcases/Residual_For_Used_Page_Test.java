package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Residual_For_New_Page;
import com.obv.qa.pages.Residual_For_Used_Page;
import com.obv.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Residual_For_Used_Page_Test extends TestBase {
    Residual_For_Used_Page residual_for_used_page;

    String sheet = "Residual_Used";


    public Residual_For_Used_Page_Test()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        residual_for_used_page=new Residual_For_Used_Page();
    }

    @DataProvider
    public Object[][] getResidualUsedData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getResidualUsedData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms_driven, String  my_tenure, String my_kms_per_month) throws InterruptedException {
//        residual_for_used_page.newFillForm("1","BMW","3 Series","2022","M340I","100","10","100");
        String validationString=residual_for_used_page.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms_driven, my_tenure, my_kms_per_month);
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
