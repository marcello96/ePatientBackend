package com.epatient.backend.controller;

import com.epatient.backend.exception.MalformedCredentialsException;
import com.epatient.backend.exception.NoSuchPatientException;
import com.epatient.backend.exception.UserExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchPatientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException(NoSuchPatientException e) {
        log.error("Patient {} does not exist!", e.getPatientId());
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleUserExistsException(UserExistsException e) {
        log.error("User exists!");
    }


    @ExceptionHandler({MalformedCredentialsException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleMalformedRequestException() {
        log.error("User exists!");
    }
}
