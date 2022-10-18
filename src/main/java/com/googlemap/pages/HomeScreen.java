package com.googlemap.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.googlemap.util.MobileUtil;

import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomeScreen {

	public AppiumDriver<MobileElement> driver;
	private MobileUtil mobileutil;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		mobileutil = new MobileUtil(driver);
	}

	By searchBox = MobileBy.AccessibilityId("Search here");
	By textBox = MobileBy.id("com.google.android.apps.maps:id/search_omnibox_edit_text");
	By allSuggestions = MobileBy.id("com.google.android.apps.maps:id/typed_suggest_container");
	By suggestionsText = MobileBy.className("android.widget.TextView");

	public void clickSearchButton() {
		mobileutil.getElement(searchBox).click();
	}

	public void searchLocation(String text) {
		mobileutil.getElement(textBox).sendKeys(text);
	}

	public void pressBack() {
		mobileutil.pressBackButton();
	}

	public void verifySuggestionsList() {
		mobileutil.waitforVisisbilityOfElementLocated(allSuggestions, 10);
	}

	public void selectLocationFromSuggestionsList(String location) {
		List<MobileElement> list = driver.findElements(suggestionsText);

		for (MobileElement e : list) {
			System.out.println("Suggestions List : " + e.getText());
			if (e.getText().equals(location)) {
				e.click();
				break;
			}
		}
	}

	public void verifyLocation(String location) {
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + location + "\");"));
		System.out.println("Location is -> "+ element.getText());
		Assert.assertTrue(element.isDisplayed());
	}

}
