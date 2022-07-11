package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsedCarPage extends TestBase {
    List<WebElement> links;

    public UsedCarPage()
    {
        links=driver.findElements(By.xpath("//div[@class='list grid']//a"));
    }

    public boolean checkBrokenLinks()
    {
        Iterator<WebElement> itr=links.iterator();
        HttpURLConnection huc=null;

        while (itr.hasNext()) {

            WebElement link=itr.next();

            String url=link.getAttribute("href");

            System.out.println(url);
            try {
                huc = (HttpURLConnection) new URL(url).openConnection();

                huc.setRequestMethod("HEAD");
                huc.connect();

                int response_code = huc.getResponseCode();

                if (response_code >= 400) {
                    System.out.println("Broken link");
                    return false;
                } else {
                    System.out.println("Valid Link");
                }
            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return true;
    }
}










