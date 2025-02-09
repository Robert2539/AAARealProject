package com.sw.Tests;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sw.base.DriverEngine;
import com.sw.pages.zNewPage;
import com.sw.utilities.ExcelReader;

public class zNewFormTest extends DriverEngine {
	zNewPage np = new zNewPage();

	@Parameters({ "browser" , "url"})
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser,@Optional("qaurl") String url) throws Exception {
		DriverEngine.initDriver(browser, url);
	}

	@AfterMethod
	public void tearDown() {
		DriverEngine.quitDriver();
	}

	@Test(dataProvider = "testdata", groups= "regression")
	public void test2(String f, String l/*, String runmode */) throws Exception {
        System.out.println("First name is  " + f +" last name is "+l);
		np.enterInInpuxBox(f,zNewPage.firstnameFeild);

	}
	
	@DataProvider(name = "testdata", parallel=true)
	public Object[][] TestDataFeed() throws Exception {
		// System.out.println(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		// ExcelReader config = new
		// ExcelReader(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		ExcelReader config = new ExcelReader("C:\\Users\\pricx\\OneDrive\\Documents\\newFirstLastName.xlsx", 0);
		int rows = config.getRowCount(0);
		Object[][] searchname = new Object[rows][2];
		for (int i = 0; i < rows; i++) {

			searchname[i][0] = config.getData(0, i, 0);
			searchname[i][1] = config.getData(0, i, 1);

		}
		//System.out.println(Arrays.deepToString(searchname));

		return searchname;

	}
	
//	@Test(groups={"smoke"})
//	public void test() throws Exception {
//       System.out.println("another method");
//
//	}

	@BeforeSuite
	public void delSS() {
		DriverEngine.deleteFilesInFolder(System.getProperty("user.dir") + "\\ScreenshotsPass\\");
		DriverEngine.deleteFilesInFolder(System.getProperty("user.dir") + "\\ScreenshotsFail\\");
		DriverEngine.deleteFilesInFolder(System.getProperty("user.dir") + "\\ExtentReports\\");
		
	}

}
