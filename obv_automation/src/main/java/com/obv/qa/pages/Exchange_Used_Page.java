package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Exchange_Used_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Exchange']")
    WebElement exchange;
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    WebElement used_btn;

    WebElement vCat;
    WebElement vMake;
    WebElement vModel;
    WebElement vYear;
    WebElement vTrim;
    WebElement vKms;
    WebElement eMake;
    WebElement eModel;
    WebElement eTrim;
    WebElement eYear;
    WebElement eKms;
    WebElement sub_btn;

    public Exchange_Used_Page()
    {
        PageFactory.initElements(driver, this);
        exchange.click();



        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        used_btn=driver.findElement(By.id("usedExchange"));

        executor.executeScript("arguments[0].click();", used_btn);

        vCat=driver.findElement(By.name("exchangecategory"));
        vMake=driver.findElement(By.name("exchangemake"));
        vModel=driver.findElement(By.name("exchangemodel"));
        vYear=driver.findElement(By.name("exchangeyear"));
        vTrim=driver.findElement(By.name("exchangetrim"));
        vKms=driver.findElement(By.name("exchangekms_driven"));

        eMake=driver.findElement(By.name("exchangemakeused"));
        eModel=driver.findElement(By.name("exchangemodelused"));
        eTrim=driver.findElement(By.name("exchangetrimused"));
        eYear=driver.findElement(By.name("exchangeyearused"));
        eKms=driver.findElement(By.name("exchangekms_drivenused"));

        sub_btn=driver.findElement(By.id("check_price_exchange"));
    }

    public String newFillForm(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven, String my_eMake, String my_eModel, String my_eYear,String my_eTrim, String my_eKms) throws InterruptedException {
        Select categorySelect=new Select(vCat);
        Select vmakeSelect=new Select(vMake);
        Select modelSelect=new Select(vModel);
        Select yearSelect=new Select(vYear);
        Select trimSelect=new Select(vTrim);

        categorySelect.selectByValue(my_category);
        vmakeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        yearSelect.selectByValue(my_year);
        trimSelect.selectByValue(my_trim);


        vKms.sendKeys(String.valueOf(my_kms_driven));


        Select eMakeSelect=new Select(eMake);
        Select eModelSelect=new Select(eModel);
        Select eTrimSelect=new Select(eTrim);
        Select eYearSelect=new Select(eYear);




        eMakeSelect.selectByValue(my_eMake);
        eModelSelect.selectByValue(my_eModel);
        eYearSelect.selectByValue(my_eYear);
        eTrimSelect.selectByValue(my_eTrim);
        eKms.sendKeys(my_eKms);
        sub_btn.click();


        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }


}
