package com.kam.weather.controller;

import com.kam.weather.model.Greeting;
import com.kam.weather.model.HttpStatus;
import com.kam.weather.model.Weather;
import com.kam.weather.model.WeatherList;
import com.kam.weather.service.WeatherService;
import com.kam.weather.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WeatherController {

    private static final String template = "Hi, %s!";
    private static final String feelsLikeTemplate = "Actual Temp: %d. Feels like: %d.";
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

    @GetMapping("/forecast")
    public WeatherList getForecast(@RequestParam(value = "specific-temp", required = false) Long filterTemp) {
        return weatherService.getForecast(filterTemp);
    }


    @GetMapping("/feels-like-temp/{id}")
    public String getFeelsLikeTemp(@PathVariable("id") Long id) {
        Map temps = weatherService.getFeelsLikeTempById(id);
        return String.format(feelsLikeTemplate, temps.get("actualTemp"), temps.get("feelsLikeTemp"));
    }

    @GetMapping("/outside/{id}")
    public String simulateRESTErrors(@PathVariable("id") Long id) {
        return weatherService.simulateRESTErrors(id);
    }

    @GetMapping("/age/{name}")
    public String simulateRESTErrors(@PathVariable("name") String name) {
        System.out.println("break here pls");
        return weatherService.getAgeOfName(name);
    }

    @GetMapping("/error-codes")
    public String errorCodes(@Valid @RequestBody HttpStatus status) {
        return weatherService.errorCodes(status.getErrorCode());
    }

    @GetMapping("/test")
    public String smallTest() {

        String code = "hellooooo";
        String httpStatAPI = "https://httpstat.us/{codee}";

        Map<String,String> pathVars = new HashMap<String, String>();
        pathVars.put("codee", code);

        MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<String,String>();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(httpStatAPI);
        builder.buildAndExpand(pathVars);
//        return builder.toUriString();

        //UriComponentsBuilder builderTwo = UriComponentsBuilder.fromHttpUrl(httpStatAPI).buildAndExpand(pathVars);


        return builder
                .buildAndExpand(pathVars)
                .toUriString();
    }

}
