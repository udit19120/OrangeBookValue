package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.UsedBikePage;
import com.obv.qa.pages.UsedCarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsedBikePageTest extends TestBase {
    HomePage homePage;
    UsedBikePage usedBikePage;

    public UsedBikePageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        usedBikePage = new UsedBikePage();
        homePage = new HomePage();
        usedBikePage = homePage.clickOnUserBikeLink();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=usedBikePage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
