package com.kam.weather.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleApplicationException(Exception ex, WebRequest request){

        log.info("---------------------------im-error----------------------------------");
        log.error("Error thrown: ", ex);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status;

        if(ex instanceof BusinessException){
            status = HttpStatus.BAD_REQUEST;
        }else{
            status = HttpStatus.EXPECTATION_FAILED;
        }

        return new ResponseEntity<Object>("Whoops something broke", headers, status);

    }



}
