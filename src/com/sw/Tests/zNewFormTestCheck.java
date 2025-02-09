package com.sw.Tests;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sw.base.DriverEngine;
import com.sw.pages.zNewPage;
import com.sw.utilities.ExcelReader;

public class zNewFormTestCheck extends DriverEngine {
	zNewPage np = new zNewPage();
	

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser, @Optional("qaurl") String url) throws Exception {
		DriverEngine.initDriver(browser, url);
	}

	@AfterMethod
	public void tearDown() {
		DriverEngine.quitDriver();
	}

	@Parameters({"male"})
	@Test
	public void test2(@Optional("male") String gender) throws Exception {
        Thread.sleep(2000);
		np.clickCheckbox(gender);
	}

}
