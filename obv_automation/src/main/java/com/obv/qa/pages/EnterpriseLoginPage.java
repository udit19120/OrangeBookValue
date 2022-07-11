package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterpriseLoginPage extends TestBase {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(name="email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement LoginBtn;

    public EnterpriseLoginPage()
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
        return driver.findElement(By.xpath("//a[@id='dLabel' and contains(text(), 'Welcome')]")).getText();

    }
}
