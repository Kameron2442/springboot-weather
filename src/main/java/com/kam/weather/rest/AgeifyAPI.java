package com.kam.weather.rest;

import com.kam.weather.model.Ageify;
import com.kam.weather.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class AgeifyAPI {

    private String AgeifyURL = "https://api.agify.io/";
    private HttpMethod getCode = HttpMethod.GET;

    @Autowired
    private RestTemplateConfig templateConfig;

    public AgeifyAPI(){}

    public Ageify getAge(String name){

        Map<String,String> pathVars = new HashMap<String, String>();
        MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<String,String>();
        queryParams.add("name", name);
        String url = RestHelper.uriBuilder(AgeifyURL, queryParams, pathVars);
        System.out.println(url);

        RestTemplate template = templateConfig.getRestTemplate();
        HttpEntity<Object> entity = RestHelper.buildRequestEntity();
        ResponseEntity<Ageify> responce = template.exchange(url, getCode, entity, Ageify.class);
        Ageify age = responce.getBody();
        return responce.getBody();

    }

}
