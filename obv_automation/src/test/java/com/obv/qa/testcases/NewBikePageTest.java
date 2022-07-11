package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.NewBikePage;
import com.obv.qa.pages.NewCarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewBikePageTest extends TestBase {

    HomePage homePage;
    NewBikePage newBikePage;

    public NewBikePageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        newBikePage = new NewBikePage();
        homePage = new HomePage();


        newBikePage = homePage.clickOnNewBike();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=newBikePage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
