package com.kam.weather.repository;

import com.kam.weather.model.Weather;
import com.kam.weather.model.WeatherList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>  {

    Weather findByid(Long id);

    List<Weather> findAll();

    @Query("select temp from Weather w where w.id = :id")
    Long getActualTempById(@Param("id") Long id);

}





