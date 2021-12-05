package com.kam.weather.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class RestHelperTest {

    private String baseUrl = "https://test.com/";
    private String baseUrlPathvar = "https://test.com/{val1}/";
    private String baseUrlPathvars = "https://test.com/{val1}/page/{val2}/";

    private Map<String,String> pathVars;
    private MultiValueMap<String,String> queryParams;
    private String expectedResult;

    @BeforeEach
    void setup(){
        pathVars = new HashMap<String, String>();
        queryParams = new LinkedMultiValueMap<String,String>();
    }

    @Test
    void UriBuilder_oneParam(){
        expectedResult = "https://test.com/?p1=param1";
        queryParams.add("p1", "param1");
        String result = RestHelper.uriBuilder(baseUrl, queryParams, pathVars);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void UriBuilder_onePathvar(){
        expectedResult = "https://test.com/value1/";
        pathVars.put("val1", "value1");
        String result = RestHelper.uriBuilder(baseUrlPathvar, queryParams, pathVars);
        Assertions.assertEquals(expectedResult, result);
    }
//
//    @Test
//    void UriBuilder_multipleParams(){
//
//    }
//
//    @Test
//    void UriBuilder_multiplePathvars(){
//
//    }
//
//    @Test
//    void UriBuilder_multipleParamsAndPathvars(){
//
//    }


}
