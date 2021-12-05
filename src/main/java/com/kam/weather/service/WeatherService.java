package com.kam.weather.service;

import com.kam.weather.model.Ageify;
import com.kam.weather.model.Weather;
import com.kam.weather.model.WeatherList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface WeatherService {

    Weather getWeatherById(final Long id);

    WeatherList getForecast(final Long filterTemp);

    Map<String,Long> getFeelsLikeTempById(final Long id);

    String simulateRESTErrors(final Long id);

    String getAgeOfName(final String name);

    String errorCodes(final Long code);

}
