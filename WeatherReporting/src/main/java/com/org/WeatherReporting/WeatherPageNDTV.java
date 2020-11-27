package com.org.WeatherReporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.org.Common.Common;

public class WeatherPageNDTV extends Common {

	public WeatherPageNDTV(WebDriver a_driver) {
		super(a_driver);

	}

	public void getCityhumidity(String icity) throws Exception {
		moveMapDown();
		clickOnElement("city", WeatherPageNDTVRepo.getCity(icity));
		setHumidityFromWeb(
				Integer.parseInt(getElementText(WeatherPageNDTVRepo.humidity).split("%")[0].split(":")[1].trim()));
	}

	public void compareWeather(int apihum) {
		int whum = getHumidityFromWeb();
		int diff = whum - apihum;
		System.out.println("getMagnitude()" + getMagnitude());
		if (Math.abs(diff) > getMagnitude()) {
			Assert.assertEquals(false, true);
		} else {
			Assert.assertEquals(true, true);
		}
	}

	public void magnitude(int num) {
		setMagnitude(num);
	}
}
