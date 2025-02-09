package com.sw.Tests;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sw.base.DriverEngine;
import com.sw.pages.HomePage;
import com.sw.utilities.ExcelReader;
import com.sw.utilities.PropertyReader;

public class HomeTest extends DriverEngine {
	HomePage hp = new HomePage();

//	@Parameters({ "browser" })
//	@BeforeMethod
//	public void setUp(@Optional("chrome") String browser) throws Exception {
//		DriverEngine.initDriver(browser);
//	}

	@Parameters({ "browser" , "url"})
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser,@Optional("uaturl") String url) throws Exception {
		DriverEngine.initDriver(browser, url);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverEngine.quitDriver();
	}

	@Test(dataProvider = "testdata")
	public void test2(String s, String runmode) throws Exception {
        System.out.println("Searching word is " + s);
		hp.search(s);
		//DriverEngine.getDriver().manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		Thread.sleep(10000);
		String title = DriverEngine.getDriver().getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, s + " - Google Search");

	}
	
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() throws Exception {
		// System.out.println(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		// ExcelReader config = new
		// ExcelReader(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		ExcelReader config = new ExcelReader("D:\\Selenium\\google.xlsx", 0);
		int rows = config.getRowCount(0);
		Object[][] searchname = new Object[rows][2];
		for (int i = 0; i < rows; i++) {

			searchname[i][0] = config.getData(0, i, 0);
			searchname[i][1] = config.getData(0, i, 1);

		}
		System.out.println(Arrays.deepToString(searchname));

		return searchname;

	}
	



}
