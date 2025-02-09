package com.sw.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports extent;
	 

	public static ExtentReports createInstance(String fileName) {
		System.out.println(fileName);
		ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
		System.out.println("ji");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle(fileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Automation Tester", "Ricxon");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");	
        return extent;

	}
}
