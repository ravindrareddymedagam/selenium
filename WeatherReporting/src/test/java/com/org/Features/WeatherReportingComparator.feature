#Author: ravindrareddy


Feature: Weather Reporting Comparator

Scenario Outline: Weather Reporting Comparator NDTV Website and openwaether api
  
Given I am on NDTV website
And I navigate to weather Section
And I set magnitude of allowed variation <magnitude>
When I select the "<city>" from Pin your city section on the left of the screen and fetch "<weather info>"
And fetch weather info from openweathermap api for "<city>"
Then API status should be ok for "<city>"
And difference between API and UI layer should not be more two

Examples:
|city|weather info|magnitude|
|Bangalore|humidity|2|


     
