package com.jaztest.jazs21912nbp.controller;

import com.jaztest.jazs21912nbp.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
@ApiIgnore
@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<ApiError> exception(HttpClientErrorException.NotFound ex){
        ApiError apiError = new ApiError(ex.getStatusCode().value(), new Date(),ex.getMessage(),"Not Found.");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({HttpClientErrorException.BadRequest.class})
    public ResponseEntity<ApiError> exception(HttpClientErrorException ex){
        ApiError apiError = new ApiError(ex.getStatusCode().value(), new Date(),ex.getMessage(),"Bad request.");
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
