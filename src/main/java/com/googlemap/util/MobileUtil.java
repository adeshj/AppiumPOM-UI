package com.googlemap.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileUtil {

	private AppiumDriver<MobileElement> driver;

	public MobileUtil(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public MobileElement getElement(By locator) {
		MobileElement element = driver.findElement(locator);
		return element;
	}

	public void pressBackButton() {
		driver.navigate().back();
	}

	public void waitforVisisbilityOfElementLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
