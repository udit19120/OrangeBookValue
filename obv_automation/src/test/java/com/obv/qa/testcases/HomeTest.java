package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Home;
import com.obv.qa.pages.HomeBuyFromIndividual;
import com.obv.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

//@Listeners(TestUtil.class)
public class HomeTest extends TestBase{
	Home home;
	String sheet = "VehicleHome";
	SoftAssert softAssert;

	public HomeTest() throws FileNotFoundException {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();
		home=new Home();
		softAssert=new SoftAssert();

	}

	@DataProvider
	public Object[][] getVehicleData(){
		Object data[][] = TestUtil.getTestData(sheet);
		return data;
	}

	@Test
	public void homePageTitleTest()
	{
		String title=home.validateHomePageTitle();
		softAssert.assertEquals(title, "Used Car, Bike, Scooter, Mobile, Real Estate, Jobs,Jewellery Price Valuation Tool | OBV Fail Test Case");
		softAssert.assertAll();

	}

	@Test(dataProvider = "getVehicleData", priority = 1)
	public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) throws InterruptedException {
		String validationString=home.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms);

		System.out.println("This is validation string "+validationString);

		softAssert.assertNotEquals(-1, validationString.indexOf(my_model));
		softAssert.assertNotEquals(-1, validationString.indexOf(my_make));
		softAssert.assertNotEquals(-1, validationString.indexOf(my_trim));

		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
