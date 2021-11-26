package com.kam.weather.service;

import com.kam.weather.model.Ageify;
import com.kam.weather.model.Weather;

import java.io.IOException;
import java.util.Map;

public interface WeatherService {

    Weather getWeatherById(final Long id);

    Map<String,Long> getFeelsLikeTempById(final Long id);

    String simulateRESTErrors(final Long id);

    String getAgeOfName(final String name);

}
