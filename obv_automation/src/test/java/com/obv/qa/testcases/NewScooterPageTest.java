package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.NewBikePage;
import com.obv.qa.pages.NewScooterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewScooterPageTest extends TestBase {
    HomePage homePage;
    NewScooterPage newScooterPage;

    public NewScooterPageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        newScooterPage = new NewScooterPage();
        homePage = new HomePage();


        newScooterPage = homePage.clickOnNewScooter();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=newScooterPage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
