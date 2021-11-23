package com.kam.weather.controller;

import com.kam.weather.model.Greeting;
import com.kam.weather.model.Weather;
import com.kam.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WeatherController {

    private static final String template = "Hi, %s!";
    private final AtomicLong counter = new AtomicLong();

    private WeatherService weatherService;

    @Autowired
    public WeatherController(final WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        try {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }catch (Exception e){
            System.out.println(e);
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
    }

    @GetMapping("/find/{id}")
    public Weather findItem(@PathVariable("id") Long id) {
        System.out.println(id);
        return weatherService.getWeatherById(id);
    }

}