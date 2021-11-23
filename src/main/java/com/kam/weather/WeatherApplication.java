package com.kam.weather;

import com.kam.weather.model.Weather;
import com.kam.weather.repository.WeatherRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeatherApplication {

	@Autowired
	private WeatherRepository weatherRepository;

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			weatherRepository.save(new Weather(Long.valueOf(1), "April 1st", "sunny", Long.valueOf(90)));
			weatherRepository.save(new Weather(Long.valueOf(2), "April 2nd", "cloudy", Long.valueOf(80)));
			weatherRepository.save(new Weather(Long.valueOf(3), "April 3rd", "rainy", Long.valueOf(70)));
		};
	}

}

