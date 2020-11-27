$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/org/Features/WeatherReportingComparator.feature");
formatter.feature({
  "name": "Weather Reporting Comparator",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Weather Reporting Comparator NDTV Website and openwaether api",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on NDTV website",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to weather Section",
  "keyword": "And "
});
formatter.step({
  "name": "I set magnitude of allowed variation \u003cmagnitude\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I select the \"\u003ccity\u003e\" from Pin your city section on the left of the screen and fetch \"\u003cweather info\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "fetch weather info from openweathermap api for \"\u003ccity\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "API status should be ok for \"\u003ccity\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "difference between API and UI layer should not be more two",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "city",
        "weather info",
        "magnitude"
      ]
    },
    {
      "cells": [
        "Bangalore",
        "humidity",
        "2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Weather Reporting Comparator NDTV Website and openwaether api",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on NDTV website",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherReportingStepDef.i_am_on_NDTV_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to weather Section",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingStepDef.i_navigate_to_weather_Section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set magnitude of allowed variation 2",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingStepDef.magnitude_of_allowed_variation(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the \"Bangalore\" from Pin your city section on the left of the screen and fetch \"humidity\"",
  "keyword": "When "
});
formatter.match({
  "location": "WeatherReportingStepDef.i_select_the_from_Pin_your_city_section_on_the_left_of_the_screen_and_fetch(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fetch weather info from openweathermap api for \"Bangalore\"",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingStepDef.fetch_weather_info_from_openweathermap_api_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API status should be ok for \"Bangalore\"",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherReportingStepDef.status_should_be_ok_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "difference between API and UI layer should not be more two",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingStepDef.difference_between_API_and_UI_layer_should_not_be_more_two()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:494)\r\n\tat org.testng.Assert.assertEquals(Assert.java:123)\r\n\tat org.testng.Assert.assertEquals(Assert.java:286)\r\n\tat org.testng.Assert.assertEquals(Assert.java:296)\r\n\tat com.org.WeatherReporting.WeatherPageNDTV.compareWeather(WeatherPageNDTV.java:28)\r\n\tat com.org.WeatherReportingStepDefinition.WeatherReportingStepDef.difference_between_API_and_UI_layer_should_not_be_more_two(WeatherReportingStepDef.java:81)\r\n\tat ✽.difference between API and UI layer should not be more two(src/test/java/com/org/Features/WeatherReportingComparator.feature:14)\r\n",
  "status": "failed"
});
});