package com.kam.weather.rest;

import com.kam.weather.model.Ageify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class AgeifyAPI {

    private String AgeifyURL = "https://api.agify.io/?name=michael";
    private HttpMethod getCode = HttpMethod.GET;

    @Autowired
    private RestTemplateConfig templateConfig;

    public AgeifyAPI(){}

    public Ageify getAge(String name){

        RestTemplate template = templateConfig.getRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("Hello World", headers);

        ResponseEntity<Ageify> responce = template.exchange(AgeifyURL, getCode, entity, Ageify.class);
        Ageify age = responce.getBody();
        System.out.println(age.getClass().getName());
        System.out.println(age);
        return responce.getBody();

    }

}
