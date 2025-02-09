package com.sw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sw.base.DriverEngine;

public class signupPage {
	public static By searchFeild = By.name("q");
	
	
	public void search() {
		DriverEngine.getDriver().findElement(searchFeild).sendKeys("UK", Keys.ENTER);
		System.out.println("After search title is->" + DriverEngine.getDriver().getTitle());
	}
	
}
