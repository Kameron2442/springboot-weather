package com.kam.weather.model;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class HttpStatus {

    @Size(min=3, max=5)
    private String user;
    @NotNull
    private Long errorCode;

}
