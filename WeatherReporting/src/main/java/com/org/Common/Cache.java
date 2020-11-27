package com.org.Common;

import org.openqa.selenium.WebDriver;

import com.org.OpenWeatherMap.OpenWeatherMap;
import com.org.WeatherReporting.HomePageNDTV;
import com.org.WeatherReporting.WeatherPageNDTV;

public class Cache {

	WebDriver driver;

	public HomePageNDTV getHomePageNDTV() {
		HomePageNDTV homePageNDTV = new HomePageNDTV(driver);
		return homePageNDTV;

	}

	public WeatherPageNDTV getWeatherNDTVPage() {
		WeatherPageNDTV weatherPageNDTV = new WeatherPageNDTV(driver);
		return weatherPageNDTV;

	}

	public OpenWeatherMap getOpenWeatherMap() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(driver);
		return openWeatherMap;
	}

}
