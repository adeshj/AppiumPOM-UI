package com.googlemap.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

//	private static AppiumDriver<MobileElement> driver;
	
	public ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();

	
    public void setDriver(AppiumDriver<MobileElement> driver) {
        this.driver.set(driver);
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver.get();
    }

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.maps");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.maps.MapsActivity");
        setDriver(new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap));
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void tearDown() {
		System.out.println("Test Finished");
//		getDriver().quit();
	}

}