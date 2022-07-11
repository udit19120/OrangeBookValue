package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomePage;
import com.obv.qa.pages.UsedScooterPage;
import com.obv.qa.pages.UsedVehiclePage;
import com.obv.qa.pages.UserLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginPageTest extends TestBase {
    UserLoginPage userLoginPage;
    HomePage homePage;

    public UserLoginPageTest()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        userLoginPage = new UserLoginPage();
        homePage = new HomePage();
        userLoginPage = homePage.clickOnUserLogin();
    }

    @Test
    public void LoginTest() throws InterruptedException {
//        userLoginPage.clickOnGoogleLogin();
        String validationString =userLoginPage.Login();
        System.out.println(validationString);

        int index=validationString.indexOf(TestBase.username);
        Assert.assertNotEquals(index, -1);
    }

    @Test
    public void LoginWithGoogleTest() throws InterruptedException {
        String validationString=userLoginPage.LoginUsingGoogle();

        System.out.println(validationString);

        int index=validationString.indexOf(TestBase.username);
        Assert.assertNotEquals(index, -1);


    }


    @Test
    public void LoginWithFacebookTest() throws InterruptedException {
        String validationString=userLoginPage.LoginUsingFacebook();

        System.out.println(validationString);

        int index=validationString.indexOf(TestBase.username);
        Assert.assertNotEquals(index, -1);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
