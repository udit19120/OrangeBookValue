package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.UsedCarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class UsedCarPageTest extends TestBase {
    HomePage homePage;
    UsedCarPage usedCarPage;

    public UsedCarPageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        usedCarPage = new UsedCarPage();
        homePage = new HomePage();


        //
        homePage.clickOnViewMore();
        Thread.sleep(5000);
        //

        usedCarPage = homePage.clickOnUserCarLink();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=usedCarPage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
