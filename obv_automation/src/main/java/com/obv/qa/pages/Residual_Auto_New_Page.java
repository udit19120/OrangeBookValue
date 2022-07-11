package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Residual_Auto_New_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Residual']")
    WebElement residual;

    WebElement auto_link;
    WebElement vehicle;
    WebElement tenure;
    WebElement kms_per_month;

    WebElement sub_btn;

    public Residual_Auto_New_Page()
    {
        PageFactory.initElements(driver, this);
        residual.click();

        auto_link=driver.findElement(By.xpath("//a[text()='Or Select A Vehicle']"));

        auto_link.click();

        vehicle=driver.findElement(By.id("leaseproduct_titlenew"));
        tenure=driver.findElement(By.name("leasetenurenew"));

        kms_per_month=driver.findElement(By.name("leasekms_driven_monthnew"));
        sub_btn=driver.findElement(By.id("check_price_lease"));

    }

    public String newFillForm(String my_vehicle,String my_tenure, String my_kms_month, String auto_in_vehicle) throws InterruptedException {
//      search_vehicle.sendKeys(my_vehicle);
        for(int i=0;i<auto_in_vehicle.length();i++)
        {
            vehicle.sendKeys(auto_in_vehicle.substring(i,i+1));
            Thread.sleep(1000);
        }

        String x_path_vehicle="//ul[@id='leaseauto-suggestnew']//li[text()='"+my_vehicle+"']";

        driver.findElement(By.xpath(x_path_vehicle)).click();
        tenure.sendKeys(my_tenure);
        kms_per_month.sendKeys(String.valueOf(my_kms_month));

        sub_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
