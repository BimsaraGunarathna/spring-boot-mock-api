package com.example.springbootmockapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * To return NotFoundAdvice to the user
 * @author Bimsara Gunarathna
 * @since 7/18/2021
 */
@ControllerAdvice
public class ComedianNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ComedianNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String comedianNotFoundHandler(ComedianNotFoundException ex) {
        return ex.getMessage();
    }
}
