package com.kam.weather.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Component
public class RestTemplateConfig {

    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        return template;
    }

}
