package com.kam.weather.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherList {

    List<Weather> Weathers;

}
