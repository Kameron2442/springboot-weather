package com.kam.weather.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Map;

public class RestHelper {

    public static final HttpEntity<Object> buildRequestEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("User", "Blink182");
        return new HttpEntity<>("Hello World", headers);
    }

    public static final String uriBuilder(String url, MultiValueMap<String,String> mapParams, Map<String,String> mapPathVars){

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if(mapParams != null && mapParams.isEmpty() == false){
            builder.queryParams(mapParams);
        }

        if(mapPathVars != null && mapPathVars.isEmpty() == false){
            builder.buildAndExpand(mapPathVars);
        }

        return builder.toUriString();

    }


}
