package com.googlemap.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.googlemap.base.BaseTest;
import com.googlemap.pages.HomeScreen;

public class HomeScreenTest extends BaseTest {

	private HomeScreen homeScreen;

	@DataProvider
	public Object[][] locationData() {
		return new Object[][] { { "Pune" }, { "Mumbai" } };
	}

	@Test(dataProvider = "locationData")
	public void searchLocationTest(String location) {
		homeScreen = new HomeScreen(getDriver());
		homeScreen.clickSearchButton();
		homeScreen.searchLocation(location);
		homeScreen.pressBack();
		homeScreen.verifySuggestionsList();
		homeScreen.selectLocationFromSuggestionsList(location);
		homeScreen.verifyLocation(location);
	}

}
