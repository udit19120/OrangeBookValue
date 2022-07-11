package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.NewCarPage;
import com.obv.qa.pages.UsedCarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewCarPageTest extends TestBase {

    HomePage homePage;
    NewCarPage newCarPage;

    public NewCarPageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        newCarPage = new NewCarPage();
        homePage = new HomePage();


        newCarPage = homePage.clickOnNewCar();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=newCarPage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
