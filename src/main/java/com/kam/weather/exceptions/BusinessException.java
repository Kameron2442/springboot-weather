package com.kam.weather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class BusinessException extends ApplicationException{

    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Throwable cause){
        super(message, cause);
    }

    public BusinessException(Throwable cause){
        super(cause);
    }

}
