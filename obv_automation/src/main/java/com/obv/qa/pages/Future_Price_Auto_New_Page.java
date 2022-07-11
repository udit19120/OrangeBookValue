package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Future_Price_Auto_New_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Future Price']")
    WebElement future_price_button;

    WebElement auto_link;
    WebElement vehicle;
    WebElement resale_year;
    WebElement kms_per_year;
    WebElement sub_btn;

    public Future_Price_Auto_New_Page()
    {
        PageFactory.initElements(driver, this);

        future_price_button.click();
        auto_link=driver.findElement(By.xpath("//a[text()='Or Select A Vehicle']"));
        auto_link.click();

        vehicle=driver.findElement(By.id("featureproduct_titlenew"));
        kms_per_year=driver.findElement(By.name("featureexpected_kms_drivennew"));
        resale_year=driver.findElement(By.name("featureexpectedresalnew"));

        sub_btn=driver.findElement(By.id("check_price_future"));


    }

    public String newFillForm(String my_vehicle, String my_year_resale, String my_kms, String auto_in_vehicle) throws InterruptedException {
        for(int i=0;i<auto_in_vehicle.length();i++)
        {
            vehicle.sendKeys(auto_in_vehicle.substring(i,i+1));
            Thread.sleep(1000);
        }

        String x_path_vehicle="//ul[@id='featureauto-suggestnew']//li[text()='"+my_vehicle+"']";

        driver.findElement(By.xpath(x_path_vehicle)).click();

        Select resaleSelect=new Select(resale_year);
        resaleSelect.selectByValue(my_year_resale);

        kms_per_year.sendKeys(String.valueOf(my_kms));
        sub_btn.click();



        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
