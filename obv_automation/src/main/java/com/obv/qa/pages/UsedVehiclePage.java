package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsedVehiclePage extends TestBase {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//div[@id='scooter']//a")
    WebElement UsedScooter;

    public UsedVehiclePage()
    {
        PageFactory.initElements(driver, this);
    }

    public UsedScooterPage clickOnUsedScooterLink() throws InterruptedException {
        Thread.sleep(5000);
        UsedScooter.click();
//        js.executeScript("arguments[0].click", UsedScooter);
        System.out.println("Clicked on Used Scooter");
        return new UsedScooterPage();
    }
}
