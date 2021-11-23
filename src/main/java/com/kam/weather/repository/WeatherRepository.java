package com.kam.weather.repository;

import com.kam.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>  {

    Weather findByid(Long id);

}





