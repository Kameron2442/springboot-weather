package com.kam.weather.rest;

import com.kam.weather.model.Ageify;
import com.kam.weather.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpstatAPI {

    private String httpStatAPI = "https://httpstat.us/{codee}";
    private HttpMethod getCode = HttpMethod.GET;

    @Autowired
    private RestTemplateConfig templateConfig;

    public HttpstatAPI(){}

    @Retryable( value = {HttpStatusCodeException.class, NumberFormatException.class}, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public String getCode(String code){

        System.out.println(code);
        Map<String,String> pathVars = new HashMap<String, String>();
        MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<String,String>();
        pathVars.put("codee", code);
        String url = RestHelper.uriBuilder(httpStatAPI, queryParams, pathVars);

        RestTemplate template = templateConfig.getRestTemplate();
        HttpEntity<Object> entity = RestHelper.buildRequestEntity();
        ResponseEntity<String> response;

        try{
            response = template.exchange(url, getCode, entity, String.class);
        }catch (HttpStatusCodeException e){
            response = new ResponseEntity<String>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());

            if(response.getStatusCode().is5xxServerError()){
                System.out.println("Retryyyyyyyyyyyyyyyyyy");
                throw e;
            }else if(HttpStatus.TOO_MANY_REQUESTS.equals(response.getStatusCode())){
                System.out.println("Retryyyyyy TOO MANYYYYY");
                throw e;
            }else{
                System.out.println("FAILLLLLLLLLLLLLLLL");
                throw e;
            }
        }



        return response.getBody();


    }

}
