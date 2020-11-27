package com.org.WeatherReporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.Common.Common;

public class HomePageNDTV extends Common {

	public HomePageNDTV(WebDriver a_driver) {
		super(a_driver);

	}

	public void navigateToNDTVHomePage() throws Exception {
		launchBrowser(readProp("url"));
	}

	public void navigateToWeatherSection() throws Exception {
		clickOnElement("more", HomePageNDTVObjectRepo.more);
		clickOnElement("weather", HomePageNDTVObjectRepo.weather);
	}

}
