package com.kam.weather.controller;

import com.kam.weather.model.Weather;
import com.kam.weather.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    private MockMvc mockMvc;

    private Weather weather = new Weather(Long.valueOf(1), "date", "desc", Long.valueOf(85));

    @BeforeEach
    void setUp() {
        System.out.println("ye");
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    void greeting() {
    }

    @Test
    void findItem() throws Exception {
        Mockito.when(weatherService.getWeatherById(Mockito.any())).thenReturn(weather);
        mockMvc.perform(get("/find/1"))
                .andExpect(status().isOk());
    }
}