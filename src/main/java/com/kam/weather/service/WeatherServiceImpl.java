package com.kam.weather.service;

import com.kam.weather.model.Weather;
import com.kam.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {


    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl (final WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    public Weather getWeatherById(Long id) {
        return weatherRepository.findByid(id);
    }

}
