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

public class Future_Price_For_Used_Page extends TestBase {

    JavascriptExecutor executor = (JavascriptExecutor)driver;

    WebElement category;

    WebElement make;

    WebElement model;

    WebElement year;

    WebElement trim;

    WebElement kms_driven;

    @FindBy(xpath = "//a[text()='Future Price']")
    WebElement future_price_button;

    WebElement for_used;

    WebElement submit_btn;

    WebElement kms_driven_per_year;

    WebElement year_resale;


    public Future_Price_For_Used_Page()
    {
        PageFactory.initElements(driver, this);
        future_price_button.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        for_used=driver.findElement(By.xpath("//a[text()='For Used']"));

        for_used.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        category= driver.findElement(By.name("featurecategoryused"));

        make=driver.findElement(By.name("featuremakeused"));

        model=driver.findElement(By.name("featuremodelused"));

        trim=driver.findElement(By.name("featuretrimused"));

        year=driver.findElement(By.name("featureyearused"));

        submit_btn= driver.findElement(By.id("check_price_future"));

        kms_driven= driver.findElement(By.name("feature_kms_drivenused"));

        kms_driven_per_year=driver.findElement(By.name("featureexpected_kms_drivenused"));

        year_resale=driver.findElement(By.name("featureexpectedresaleused"));
    }

    public String newFillForm(String my_category, String my_make, String my_model, String my_trim, String  my_year, String my_kms_driven, String my_resale_year, String my_kms_per_year) throws InterruptedException {
        Select categorySelect=new Select(category);
        Select makeSelect=new Select(make);
        Select modelSelect=new Select(model);
        Select yearSelect=new Select(year);
        Select trimSelect=new Select(trim);
        Thread.sleep(2000);
        Select resaleYearSelect=new Select(year_resale);

        categorySelect.selectByValue(my_category);
        makeSelect.selectByValue(my_make);
        modelSelect.selectByValue(my_model);
        yearSelect.selectByValue(my_year);
        trimSelect.selectByValue(my_trim);

        kms_driven.sendKeys(String.valueOf(my_kms_driven));

        resaleYearSelect.selectByValue(my_resale_year);
        kms_driven_per_year.sendKeys(String.valueOf(my_kms_per_year));

//        System.out.println(category);
//        submit_btn.click();

        Thread.sleep(5000);
       executor.executeScript("arguments[0].click();", submit_btn);
       System.out.println("Hello");
        executor.executeScript("window.alert(document.getElementsByClassName(\"form-control\").featurecategoryused.selectedIndex)");
        Thread.sleep(5000);

        categorySelect.selectByValue(my_category);
        Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", submit_btn);



        Thread.sleep(3000);
        String val_string=driver.findElements(By.xpath("//input[@id='trim_populate']/preceding-sibling::label")).get(0).getText();
        System.out.println("This is val_string: "+val_string);
        return val_string;
    }
}
