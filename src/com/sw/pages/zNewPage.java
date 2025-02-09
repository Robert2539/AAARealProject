package com.sw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sw.base.DriverEngine;

public class zNewPage {
	public static By firstnameFeild = By.id("text1");
	//public static By checkboxFeild = By.xpath("//input[@value='"+gender+"']");
	

	public void enterInInpuxBox(String word, By ele) throws InterruptedException {
		DriverEngine.getDriver().findElement(ele).sendKeys(word, Keys.ENTER);
	}
	
	public void clickCheckbox(String gender) {
		By checkboxFeild = By.xpath("//input[@value='"+gender+"']");
		DriverEngine.getDriver().findElement(checkboxFeild).click();
	}
	
	
}
