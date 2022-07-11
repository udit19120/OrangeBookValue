package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class UserLoginPage extends TestBase {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(name="email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement LoginBtn;

    public UserLoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String Login() throws InterruptedException {
        email.sendKeys(TestBase.email);
        password.sendKeys(TestBase.password);
        Thread.sleep(5000);
        js.executeScript("arguments[0].click()",LoginBtn);
//        LoginBtn.click();

        Thread.sleep(3000);
        return driver.findElement(By.xpath("//a[contains(text(), 'Welcome ') and @role='button']")).getText();

    }


    public void clickOnGoogleLogin()
    {
        driver.findElement(By.xpath("//div[@id='my-signin2']")).click();
    }

    public void clickOnFacebookLogin()
    {
        driver.findElement(By.xpath("//div[@class='social fb']")).click();
    }


    public String LoginUsingGoogle() throws InterruptedException {

        String MainWindow= driver.getWindowHandle();
        clickOnGoogleLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);

        Set<String> windows=driver.getWindowHandles();

        Iterator<String> iterator=windows.iterator();

        while (iterator.hasNext())
        {
            String childWindow=iterator.next();
            if(!MainWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.id("identifierId")).sendKeys(TestBase.email);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()=\"Next\"]//parent::button")).click();
//                driver.close();
            }

        }

        driver.switchTo().window(MainWindow);

        windows=driver.getWindowHandles();
        iterator=windows.iterator();
        while (iterator.hasNext())
        {
            String childWindow=iterator.next();
            if(!MainWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("password")).sendKeys(TestBase.emailpass);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()=\"Next\"]//parent::button")).click();
//                driver.close();
            }

        }


        driver.switchTo().window(MainWindow);

        Thread.sleep(3000);
        return driver.findElement(By.xpath("//a[contains(text(), 'Welcome ') and @role='button']")).getText();

    }



    public String LoginUsingFacebook() throws InterruptedException {

        String MainWindow= driver.getWindowHandle();
        clickOnFacebookLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);

        Set<String> windows=driver.getWindowHandles();

        Iterator<String> iterator=windows.iterator();

        while (iterator.hasNext())
        {
            String childWindow=iterator.next();
            if(!MainWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("email")).sendKeys(TestBase.email);
                driver.findElement(By.name("pass")).sendKeys(TestBase.facebookpass);
                Thread.sleep(3000);
                driver.findElement(By.name("login")).click();
//                driver.close();
            }

        }

        driver.switchTo().window(MainWindow);

//        windows=driver.getWindowHandles();
//        iterator=windows.iterator();
//        while (iterator.hasNext())
//        {
//            String childWindow=iterator.next();
//            if(!MainWindow.equalsIgnoreCase(childWindow))
//            {
//                driver.switchTo().window(childWindow);
//                driver.findElement(By.name("password")).sendKeys(TestBase.emailpass);
//                Thread.sleep(3000);
//                driver.findElement(By.xpath("//span[text()=\"Next\"]//parent::button")).click();
////                driver.close();
//            }
//
//        }
//

//        driver.switchTo().window(MainWindow);

        Thread.sleep(3000);
        return driver.findElement(By.xpath("//a[contains(text(), 'Welcome ') and @role='button']")).getText();

    }
}
