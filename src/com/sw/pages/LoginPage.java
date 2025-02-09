package com.sw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sw.base.DriverEngine;

public class LoginPage {
	
	private static By searchFeild = By.name("q");
	
	public void search(String s) {
		DriverEngine.getDriver().findElement(searchFeild).sendKeys(s, Keys.ENTER);
		System.out.println("After search title is->" + DriverEngine.getDriver().getTitle());

	}

}
