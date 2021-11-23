package com.kam.weather.repository;

import com.kam.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>  {

    Weather findByid(Long id);

    @Query("select temp from Weather w where w.id = :id")
    Long getActualTempById(@Param("id") Long id);

}





