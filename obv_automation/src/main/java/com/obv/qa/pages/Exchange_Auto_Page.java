package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class Exchange_Auto_Page extends TestBase {
    @FindBy(xpath = "//a[@id='exchange-tab']")
    WebElement exchange_btn;


    JavascriptExecutor executor = (JavascriptExecutor)driver;

    WebElement auto_link;

    WebElement vehicle;
    WebElement kms;

    WebElement exc_vehicle;
    WebElement sub_btn;


    public Exchange_Auto_Page()
    {
        PageFactory.initElements(driver,this);

        exchange_btn.click();

        auto_link=driver.findElement(By.xpath("//a[text()='Or Select A Vehicle']"));
        executor.executeScript("arguments[0].click();", auto_link);

        vehicle=driver.findElement(By.id("exchangeproduct_title"));
        kms=driver.findElement(By.name("exchangekms_driven"));
        exc_vehicle=driver.findElement(By.id("exchangeproduct_titlenew"));

        sub_btn=driver.findElement(By.id("check_price_exchange"));
    }

    public String newFillForm(String my_vehicle,String my_kms, String my_exc_vehicle, String auto_in_vehicle, String auto_in_exc_vehicle) throws InterruptedException {

        for(int i=0;i<auto_in_vehicle.length();i++)
        {
            vehicle.sendKeys(auto_in_vehicle.substring(i,i+1));
            Thread.sleep(1000);
        }

        String x_path_vechicle="//ul[@id='exchangeauto-suggest']//li[text()='"+my_vehicle+"']";

        driver.findElement(By.xpath(x_path_vechicle)).click();
        kms.sendKeys(String.valueOf(my_kms));


        for(int i=0;i<auto_in_exc_vehicle.length();i++)
        {
            exc_vehicle.sendKeys(auto_in_exc_vehicle.substring(i,i+1));
            Thread.sleep(1000);
        }


        String x_path_exc_vechicle="//ul[@id='exchangeauto-suggestnew']//li[text()='"+my_exc_vehicle+"']";

        driver.findElement(By.xpath(x_path_exc_vechicle)).click();

        sub_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
