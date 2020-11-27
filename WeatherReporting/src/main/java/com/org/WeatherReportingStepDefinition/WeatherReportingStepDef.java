package com.org.WeatherReportingStepDefinition;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import com.org.Common.Cache;
import com.org.OpenWeatherMap.OpenWeatherMap;
import com.org.WeatherReporting.HomePageNDTV;
import com.org.WeatherReporting.WeatherPageNDTV;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherReportingStepDef {

	Cache cache = new Cache();
	HomePageNDTV homePageNDTV = cache.getHomePageNDTV();
	WeatherPageNDTV weatherPageNDTV = cache.getWeatherNDTVPage();
	OpenWeatherMap openWeatherMap = cache.getOpenWeatherMap();
	int humidity;

	@Given("I am on NDTV website")
	public void i_am_on_NDTV_website() {
		try {
			homePageNDTV.navigateToNDTVHomePage();
		} catch (Exception e) {

		}
	}

	@Given("I navigate to weather Section")
	public void i_navigate_to_weather_Section() {
		try {
			homePageNDTV.navigateToWeatherSection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Given("I set magnitude of allowed variation {int}")
	public void magnitude_of_allowed_variation(Integer int1) {
		weatherPageNDTV.magnitude(int1);
	}

	@When("I select the {string} from Pin your city section on the left of the screen and fetch {string}")
	public void i_select_the_from_Pin_your_city_section_on_the_left_of_the_screen_and_fetch(String string,
			String string2) {
		try {
			weatherPageNDTV.getCityhumidity(string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@When("fetch weather info from openweathermap api for {string}")
	public void fetch_weather_info_from_openweathermap_api_for(String string) {

		humidity = openWeatherMap.getHumidity(string);

	}

	@Then("API status should be ok for {string}")
	public void status_should_be_ok_for(String string) {
		openWeatherMap.verifyOpenWeatherMapDataByCityResponseCode(string);
	}

	@Then("difference between API and UI layer should not be more two")
	public void difference_between_API_and_UI_layer_should_not_be_more_two() {
		weatherPageNDTV.compareWeather(humidity);
	}

}
