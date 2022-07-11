package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_Vehicle_Auto_Page extends TestBase {
    @FindBy(xpath = "//a[text()='New']")
    WebElement new_btn;

    JavascriptExecutor executor = (JavascriptExecutor)driver;

    WebElement auto_link;
    WebElement search_vehicle;
    WebElement city;
    WebElement sub_btn;

//    Honda Amaze 1.2 E MT PETROL BS6


    public New_Vehicle_Auto_Page()
    {
        PageFactory.initElements(driver, this);
        new_btn.click();

        auto_link=driver.findElement(By.xpath("//a[text()='Or Select A Vehicle']"));


        executor.executeScript("arguments[0].click();", auto_link);
//        auto_link.click();

        search_vehicle=driver.findElement(By.id("newproduct_title"));

        city=driver.findElement(By.name("newcity"));

        //deliberately failed case: element will not be found
        sub_btn=driver.findElement(By.id("check_price_new"));
    }

    public String newFillForm(String my_vehicle,String my_city, String auto_vehicle_in) throws InterruptedException {

        for(int i=0;i<auto_vehicle_in.length();i++)
        {
            search_vehicle.sendKeys(auto_vehicle_in.substring(i,i+1));
            Thread.sleep(1000);
        }

        //  deliberately failed case: element will not be found
        String x_path_vehicle="//ul[@id='newauto-suggest']//li[text()='"+ my_vehicle +"']";

        driver.findElement(By.xpath(x_path_vehicle)).click();
        city.sendKeys(String.valueOf(my_city));
        sub_btn.click();

        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
