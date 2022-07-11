package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.net.CacheRequest;

public class Residual_For_Used_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Residual']")
    WebElement residual;
    JavascriptExecutor executor = (JavascriptExecutor)driver;

    WebElement Category;
    WebElement for_used;
    WebElement Make;
    WebElement Model;
    WebElement Year;
    WebElement Trim;
    WebElement Tenure;
    WebElement Kms;
    WebElement sub_btn;
    WebElement Kms_per_month;


    public Residual_For_Used_Page()
    {
        PageFactory.initElements(driver, this);
        residual.click();

        for_used=driver.findElement(By.id("used-price"));
        for_used.click();

        Category=driver.findElement(By.name("leasecategory"));
        Make=driver.findElement(By.name("leasemake"));
        Model=driver.findElement(By.name("leasemodel"));
        Year=driver.findElement(By.name("leaseyear"));
        Trim=driver.findElement(By.name("leasetrim"));
        Tenure=driver.findElement(By.name("leasetenure"));
        Kms=driver.findElement(By.name("leasekms_driven"));
        Kms_per_month=driver.findElement(By.name("leasekms_driven_month"));

        sub_btn=driver.findElement(By.id("check_price_lease"));
    }


    public String newFillForm(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms_driven, String  my_tenure, String my_kms_per_month) throws InterruptedException {
        Select categorySelect=new Select(Category);
        Select makeSelect=new Select(Make);
        Select modelSelect=new Select(Model);
        Select yearSelect=new Select(Year);
        Select trimSelect=new Select(Trim);

        categorySelect.selectByValue(my_category);
        makeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        yearSelect.selectByValue(my_year);
        trimSelect.selectByValue(my_trim);

        Kms.sendKeys(String.valueOf(my_kms_driven));
        Tenure.sendKeys(String.valueOf(my_tenure));
        Kms_per_month.sendKeys(String.valueOf(my_kms_per_month));
        Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", sub_btn);
//        sub_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
