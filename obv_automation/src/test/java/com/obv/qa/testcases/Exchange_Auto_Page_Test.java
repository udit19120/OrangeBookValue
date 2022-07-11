package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Exchange_Auto_Page;
import com.obv.qa.pages.Exchange_Used_Page;
import com.obv.qa.pages.New_Vehicle_Auto_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class Exchange_Auto_Page_Test extends TestBase {
    Exchange_Auto_Page exchange_auto_page;
    String sheet = "Exchange_Auto";

    public Exchange_Auto_Page_Test() {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        exchange_auto_page=new Exchange_Auto_Page();
    }

    @DataProvider
    public Object[][] getExchangeAutoData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getExchangeAutoData")
    public void FormTest1(String my_vehicle, String my_kms, String my_exc_vehicle, String auto_in_vehicle, String auto_in_exc_vehicle) throws InterruptedException {
        String validationString=exchange_auto_page.newFillForm(my_vehicle, my_kms, my_exc_vehicle, auto_in_vehicle, auto_in_exc_vehicle);

        SoftAssert softAssert=new SoftAssert();

        validationString=validationString.toLowerCase();
        auto_in_vehicle=auto_in_vehicle.toLowerCase();
        auto_in_exc_vehicle=auto_in_exc_vehicle.toLowerCase();

        System.out.println("This is validation string "+validationString);


        softAssert.assertNotEquals(-1, validationString.indexOf(auto_in_exc_vehicle));
        softAssert.assertNotEquals(-1, validationString.indexOf(auto_in_vehicle));

//        softAssert.assertNotEquals(-1, validationString.indexOf(my_vehicle));
//        softAssert.assertNotEquals(-1, validationString.indexOf(my_exc_vehicle));

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }


}

//    String x_path_exc_vechicle="//ul[@id='exchangeauto-suggestnew']//li[text()='"+my_exc_vehicle+"']";
//String x_path_vechicle="//ul[@id='exchangeauto-suggest']//li[text()='"+my_exc_vehicle+"']";

//    Honda Amaze 2019 1.2 E I-VTEC
//Honda Amaze 1.2 S CVT PETROL BS6