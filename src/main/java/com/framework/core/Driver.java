package com.framework.core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

	public WebDriver getRemoteWebDriver(String URL, DesiredCapabilities dc) throws MalformedURLException {
		return new RemoteWebDriver(new URL(URL),dc);
	}

	public AndroidDriver getAppiumAndroidDriver(String appPackage, String appActivity, String deviceName, String appiumServerURL) throws MalformedURLException {
		//Desired Caps
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability("automationName", "Appium");
		DC.setCapability("platformName", "Android");
		DC.setCapability("appPackage", appPackage);
		DC.setCapability("appActivity", appActivity);
		DC.setCapability("deviceName", deviceName);

		//Initiate WebDriver
		return new AndroidDriver(new URL(appiumServerURL), DC);
	}

	public AndroidDriver getAndroidChromeDriver(String deviceName, String appiumServerURL, Proxy proxy) throws MalformedURLException {
		//Desired Caps
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability("automationName", "Appium");
		DC.setCapability("platformName", "Android");
		DC.setCapability("browserName", "Chrome");
		DC.setCapability("deviceName", deviceName);

		if(proxy != null) DC.setCapability(CapabilityType.PROXY,proxy);

		//Initiate WebDriver
		return new AndroidDriver(new URL(appiumServerURL), DC);
	}

	public Platform getPlatform(String platformName){
		String osName = platformName.toUpperCase();
		if(osName.equals("WIN8.1")) return Platform.WIN8_1;
		else if (osName.equals("WIN8")) return Platform.WIN8;
		else if (osName.equals("ANDROID")) return Platform.ANDROID;
		else if (osName.equals("LINUX")) return Platform.LINUX;
		else if (osName.equals("MAC")) return Platform.MAC;
		else if (osName.equals("WIN")) return Platform.WINDOWS;
		else return Platform.ANY;



	}
}
