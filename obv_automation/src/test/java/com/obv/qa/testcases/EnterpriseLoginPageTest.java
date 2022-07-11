package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.EnterpriseLoginPage;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.UserLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnterpriseLoginPageTest extends TestBase {
    EnterpriseLoginPage enterpriseLoginPage;
    HomePage homePage;

    public EnterpriseLoginPageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        enterpriseLoginPage = new EnterpriseLoginPage();
        homePage = new HomePage();
        enterpriseLoginPage = homePage.clickOnEnterpriseLogin();
    }

    @Test
    public void LoginTest() throws InterruptedException {
        String validationString =enterpriseLoginPage.Login();
        System.out.println(validationString);

        int index=validationString.indexOf(TestBase.username);
        Assert.assertNotEquals(index, -1);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
