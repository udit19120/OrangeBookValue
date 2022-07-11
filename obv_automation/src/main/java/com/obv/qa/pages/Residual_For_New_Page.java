package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Residual_For_New_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Residual']")
    WebElement residual;
    WebElement Category;
    WebElement Make;
    WebElement Model;
    WebElement Trim;
    WebElement Tenure;
    WebElement Kms;

    WebElement sub_btn;

    public Residual_For_New_Page(){
        PageFactory.initElements(driver, this);
        residual.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        Category=driver.findElement(By.name("leasecategorynew"));
        Make=driver.findElement(By.name("leasemakenew"));
        Model=driver.findElement(By.name("leasemodelnew"));
        Trim=driver.findElement(By.name("leasetrimnew"));
        Tenure=driver.findElement(By.name("leasetenurenew"));
        Kms=driver.findElement(By.name("leasekms_driven_monthnew"));

        sub_btn=driver.findElement(By.id("check_price_lease"));
    }


    public String newFillForm(String my_category, String my_make, String my_model, String my_trim, String  my_tenure, String my_kms_driven) throws InterruptedException {
        Select categorySelect=new Select(Category);
        Select makeSelect=new Select(Make);
        Select modelSelect=new Select(Model);
        Select trimSelect=new Select(Trim);

        categorySelect.selectByValue(my_category);
        makeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        trimSelect.selectByValue(my_trim);

        Tenure.sendKeys(String.valueOf(my_tenure));
        Kms.sendKeys(String.valueOf(my_kms_driven));

        sub_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
