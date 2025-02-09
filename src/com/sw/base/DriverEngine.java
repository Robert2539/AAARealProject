package com.sw.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sw.utilities.PropertyReader;

public class DriverEngine {
	public static WebDriver driver;
	// public static WebDriver WebDriver;

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return dr.get();

	}

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);

	}

	public static void remove() {
		dr.remove();

	}

	public static void initDriver(String browser) throws Exception {
		if (getDriver() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				setDriver(driver);
				getDriver().get(PropertyReader.getValue("url"));
			} else if (browser.equalsIgnoreCase("edge")) {
				// edge implementaion
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				setDriver(driver);
				getDriver().get(PropertyReader.getValue("url"));
			}

		}
	}

	public static void initDriver(String browser, String url) throws Exception {
		if (getDriver() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				setDriver(driver);
				if (url.equalsIgnoreCase("qaurl")) {
					getDriver().get(PropertyReader.getValue("qaurl"));
				} else if (url.equalsIgnoreCase("uaturl")) {
					getDriver().get(PropertyReader.getValue("uaturl"));
				}

			} else if (browser.equalsIgnoreCase("edge")) {
				// edge implementaion
				System.out.println("edge opening");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				setDriver(driver);
				// getDriver().get(PropertyReader.getValue("url"));
				if (url.equalsIgnoreCase("qaurl")) {
					getDriver().get(PropertyReader.getValue("qaurl"));
				} else if (url.equalsIgnoreCase("uaturl")) {
					getDriver().get(PropertyReader.getValue("uaturl"));

				}
			}
		}
	}

	public static void quitDriver() {
		/*
		 * if(driver!=null) { driver.quit(); driver=null; }
		 */
		if (getDriver() != null) {
			getDriver().quit();
			remove();
			setDriver(null);

		}

	}
	// click, scroll, highlight, dropdown, checkbox, ...............(more methods)
	// move further, back, refresh
	// scroll up and down, ronot, actions class

//	public static void waitSomeTime(long time){
//		try {
//			getDriver().manage().wait(time);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//	}

	public static void deleteFilesInFolder(String folderPath) {
		File folder = new File(folderPath);
		if (folder.exists() && folder.isDirectory()) {
			// List all files in the folder
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					// Delete each file
					file.delete();
				}
			}
		}
	}

}
