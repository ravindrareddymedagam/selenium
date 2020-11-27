package com.org.WeatherReporting;

import org.openqa.selenium.By;

public class WeatherPageNDTVRepo {

	public static By degrees = By
			.xpath("//div[@class='leaflet-popup-content-wrapper']//span/b[contains(text(),'Degrees')]");
	public static By fahrenheit = By
			.xpath("//div[@class='leaflet-popup-content-wrapper']//span/b[contains(text(),'Fahrenheit')]");
	public static By humidity = By
			.xpath("//div[@class='leaflet-popup-content-wrapper']//span/b[contains(text(),'Humidity')]");

	public static By getCity(String icity) {
		String cityname;
		if (icity.equals("Bangalore")) {
			cityname = "Bengaluru";
		} else {
			cityname = icity;
		}
		By city = By.xpath("//div[contains(text(),'" + cityname + "')]");
		return city;
	}

}
