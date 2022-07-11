package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class New_Vehicle_Page extends TestBase {
    //page factory

    WebElement category;
    WebElement make;
    WebElement model;
    WebElement trim;

    WebElement city;

    WebElement submit_btn;



    @FindBy(xpath = "//a[text()='New']")
    WebElement new_btn;

    public New_Vehicle_Page(){


        PageFactory.initElements(driver, this);
        new_btn.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        category= driver.findElement(By.name("newcategory"));

        make=driver.findElement(By.name("newmake"));

        model=driver.findElement(By.name("newmodel"));

        trim=driver.findElement(By.name("newtrim"));

        city=driver.findElement(By.name("newcity"));

        submit_btn=driver.findElement(By.id("check_price_new"));
    }


    public String newFillForm(String my_category, String my_make, String my_model, String my_trim, String  my_city) throws InterruptedException {
        Select categorySelect=new Select(category);
        Select makeSelect=new Select(make);
        Select modelSelect=new Select(model);
        Select citySelect=new Select(city);
        Select trimSelect=new Select(trim);

        categorySelect.selectByValue(my_category);
        makeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        citySelect.selectByValue(my_city);
        trimSelect.selectByValue(my_trim);

        submit_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
