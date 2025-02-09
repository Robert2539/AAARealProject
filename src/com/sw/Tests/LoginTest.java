package com.sw.Tests;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sw.base.DriverEngine;
import com.sw.pages.LoginPage;
import com.sw.utilities.ExcelReader;

public class LoginTest {
	LoginPage lp = new LoginPage();
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) throws Exception {
		DriverEngine.initDriver(browser);
	}

	@AfterMethod
	public void tearDown() {
		DriverEngine.quitDriver();
	}

	@Test(dataProvider="testdata")
	public void test1(String s, String a) {
		lp.search(s);

	}
	
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() throws Exception {
		//System.out.println(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		//ExcelReader config = new ExcelReader(System.getProperty("user.dir")+"\\Data\\googleSearchWords.xlsx");
		ExcelReader config = new ExcelReader("D:\\Selenium\\google.xlsx", 2);
		int rows = config.getRowCount(2);
		Object[][] searchname = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			searchname[i][0] = config.getData(0, i, 0);
			searchname[i][1] = config.getData(0, i, 1);
			
		}
		System.out.println(Arrays.deepToString(searchname));
		return searchname;

	}
	

}
