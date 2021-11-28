package com.kam.weather.rest;

import com.kam.weather.model.Ageify;
import com.kam.weather.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    public String getCode(String code){

        System.out.println(code);
        Map<String,String> pathVars = new HashMap<String, String>();
        MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<String,String>();
        pathVars.put("codee", code);
        String url = RestHelper.uriBuilder(httpStatAPI, queryParams, pathVars);
        System.out.println(url);

        RestTemplate template = templateConfig.getRestTemplate();
        HttpEntity<Object> entity = RestHelper.buildRequestEntity();
        ResponseEntity<String> response = template.exchange(url, getCode, entity, String.class);
        return response.getBody();

    }

}
