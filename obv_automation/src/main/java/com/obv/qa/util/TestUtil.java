package com.obv.qa.util;

import com.obv.qa.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import static com.obv.qa.base.TestBase.driver;

public class TestUtil extends TestBase implements ITestListener, IRetryAnalyzer {


	int counter=0;
	int retryLimit=1;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub



	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onTestFailure(ITestResult re) {
		/* isFailed=true;
		try {
			SendEmail.NotifyFailure(re.getMethod().getMethodName(), re.getTestClass().getName());
		} catch (EmailException e) {
			throw new RuntimeException(e);
		}
		
		*/
		System.out.println("Entered onTestFailure");
		//in below code, " DemoListener .driver" is used to get same driver from sample test class.
		takeScreenshot(re.getMethod().getMethodName(), re.getTestClass().getName());
	}
	public static long implicit_wait=20;
	public static long page_load_timeout=40;

	public static String TESTDATA_SHEET_PATH = "src/main/java/com/obv/qa/util/My_Automation.xlsx";

	static Workbook book;
	static Sheet sheet;

	public TestUtil(){
//		vehicles=TestUtil.getData(TESTDATA_SHEET_PATH);
	}


	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
			System.out.println(book.getSheetIndex("Repair"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public void takeScreenshot(String method, String class_name)
	{

		System.out.println("Entered takeScreenshot");
		TakesScreenshot t = (TakesScreenshot)driver;

		File srcFile = t.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File("./ScreenShot/" +class_name+"_"+method+ ".jpg"));
			System.out.println("ScreenShot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}
}

