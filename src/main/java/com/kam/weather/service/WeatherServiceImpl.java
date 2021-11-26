package com.kam.weather.service;

import com.kam.weather.model.Ageify;
import com.kam.weather.model.Weather;
import com.kam.weather.repository.WeatherRepository;
import com.kam.weather.rest.AgeifyAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kam.weather.exceptions.BusinessException;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {


    private WeatherRepository weatherRepository;
    private AgeifyAPI ageAPI;


    @Autowired
    public WeatherServiceImpl (final WeatherRepository weatherRepository, AgeifyAPI ageAPI){
        this.weatherRepository = weatherRepository;
        this.ageAPI = ageAPI;
    }

    @Override
    public Weather getWeatherById(final Long id) {
        return weatherRepository.findByid(id);
    }

    @Override
    public Map<String,Long> getFeelsLikeTempById(final Long id){

        log.info("---------------------------im-in----------------------------------");

        Long actualTemp = weatherRepository.getActualTempById(id);

        if(actualTemp == null){
            throw new BusinessException("Im throwing this because a null was passed");
        }

        Long feelsLikeTemp = actualTemp + Double.valueOf(Math.random() * 5 + 1).longValue();

        Map <String, Long> temps = new HashMap<String, Long>();
        temps.put("actualTemp", actualTemp);
        temps.put("feelsLikeTemp", feelsLikeTemp);

        return temps;
    };

    @Override
    public String simulateRESTErrors(final Long id){



        return "Works!";
    };

    @Override
    public String getAgeOfName(final String name){

        Ageify age = ageAPI.getAge(name);

        return "Age of " + age.getName() + " is probably: " + age.getAge();

    }



}
