package com.org.OpenWeatherMap;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import com.org.Common.Common;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenWeatherMap extends Common {

	public OpenWeatherMap(WebDriver a_driver) {
		super(a_driver);

	}

	private String addURI;
	private double doublename_id;
	private Object emp_name;
	private String name_id;
	private RestTemplate restTemplate;
	HttpHeaders headers;
	private ResponseEntity response;
	String key = "7fe67bf08c80ded756e598d6f8fedaea";

	public ResponseEntity getResponseOpenWeatherMapDataByCity(String string) {
		addURI = "http://api.openweathermap.org/data/2.5/weather?q=" + string + "&appid=" + key;
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("ontent-type", "application/json");
		restTemplate = new RestTemplate();
		response = restTemplate.getForEntity(addURI, String.class);
		return response;

	}

	public void verifyOpenWeatherMapDataByCityResponseCode(String string) {
		ResponseEntity response = getResponseOpenWeatherMapDataByCity(string);
		Assert.assertEquals(true, response.getStatusCode() == HttpStatus.OK);
	}

	public int getHumidity(String city) {
		JSONObject json = new JSONObject(getResponseOpenWeatherMapDataByCity(city).getBody().toString());
		int hum = json.getJSONObject("main").getInt("humidity");
		return hum;

	}

}
