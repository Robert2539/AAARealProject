package com.sw.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sw.base.DriverEngine;

public class HomePage {
	static By searchFeild = By.name("q");
	
	
	@SuppressWarnings("deprecation")
	public void search(String s) throws InterruptedException {
		DriverEngine.getDriver().findElement(searchFeild).sendKeys(s, Keys.ENTER);
		

	}
}
