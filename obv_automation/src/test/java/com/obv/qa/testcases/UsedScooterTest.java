package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.UsedBikePage;
import com.obv.qa.pages.UsedScooterPage;
import com.obv.qa.pages.UsedVehiclePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsedScooterTest extends TestBase {
    HomePage homePage;
    UsedVehiclePage usedVehiclePage;

    UsedScooterPage usedScooterPage;

    public UsedScooterTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        usedVehiclePage = new UsedVehiclePage();
        usedScooterPage=new UsedScooterPage();
        homePage = new HomePage();
        usedVehiclePage = homePage.clickOnUsedVehicleLink();
        Thread.sleep(5000);
        usedScooterPage=usedVehiclePage.clickOnUsedScooterLink();
    }


    @Test
    public void BrokenLinksTest(){
        boolean testResult=usedScooterPage.checkBrokenLinks();
        Assert.assertEquals(true, testResult);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
