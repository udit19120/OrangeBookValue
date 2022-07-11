package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Future_Price_For_New_page extends TestBase {
    WebElement category;

    WebElement make;

    WebElement model;

    WebElement year;

    WebElement trim;

    WebElement kms_driven;

    @FindBy(xpath = "//a[text()='Future Price']")
    WebElement future_price_button;

    WebElement submit_btn;


    public Future_Price_For_New_page()
    {
        PageFactory.initElements(driver, this);
        future_price_button.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        category= driver.findElement(By.name("featurecategorynew"));

        make=driver.findElement(By.name("featuremakenew"));

        model=driver.findElement(By.name("featuremodelnew"));

        trim=driver.findElement(By.name("featuretrimnew"));

        year=driver.findElement(By.name("featureexpectedresalnew"));

        submit_btn= driver.findElement(By.id("check_price_future"));

        kms_driven= driver.findElement(By.name("featureexpected_kms_drivennew"));

    }

    public String newFillForm(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven) throws InterruptedException {
        Select categorySelect=new Select(category);
        Select makeSelect=new Select(make);
        Select modelSelect=new Select(model);
        Select yearSelect=new Select(year);
        Select trimSelect=new Select(trim);

        categorySelect.selectByValue(my_category);
        makeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        yearSelect.selectByValue(my_year);
        trimSelect.selectByValue(my_trim);


        kms_driven.sendKeys(String.valueOf(my_kms_driven));
        submit_btn.click();



        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
