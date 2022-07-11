package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomeBuyFromIndividual extends TestBase {
    //page factory


    @FindBy(name = "category")
    WebElement category;

    @FindBy(name = "make")
    WebElement make;

    @FindBy(name = "model")
    WebElement model;




    @FindBy(name = "year")
    WebElement year;


    @FindBy(name = "trim")
    WebElement trim;

    @FindBy(name = "kms_driven")
    WebElement kms_driven;

    @FindBy(id = "check_price_used")
    WebElement submit_btn;


    @FindBy(xpath = "//a[text()='Buy']")
    WebElement Buy_btn;

    @FindBy(xpath = "//input[@type='radio' and @value='individual']")
    WebElement individual_radio;

    public HomeBuyFromIndividual(){
        PageFactory.initElements(driver, this);
        Buy_btn.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(individual_radio).click().perform();
    }

    public String newFillForm(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) throws InterruptedException {

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

        if(my_category.equals("5"))
        {
            System.out.println("This is bicycle case");
            submit_btn.click();
            Thread.sleep(3000);
            String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
            System.out.println("This is val_string: "+val_string);
            return val_string;
        }
        kms_driven.sendKeys(my_kms);
        submit_btn.click();

        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }

}
