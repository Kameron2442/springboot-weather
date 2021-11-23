package com.kam.weather.service;

import com.kam.weather.model.Weather;
import com.kam.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class WeatherServiceImpl implements WeatherService {


    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl (final WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    public Weather getWeatherById(final Long id) {
        return weatherRepository.findByid(id);
    }

    public Map<String,Long> getFeelsLikeTempById(final Long id){
        Long actualTemp = weatherRepository.getActualTempById(id);
        Long feelsLikeTemp = actualTemp + Double.valueOf(Math.random() * 5 + 1).longValue();

        Map <String, Long> temps = new HashMap<String, Long>();
        temps.put("actualTemp", actualTemp);
        temps.put("feelsLikeTemp", feelsLikeTemp);

        return temps;
    };


}
