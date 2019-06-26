package com.epatient.backend.controller;

import com.epatient.backend.exception.NoSuchPatientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PatientExceptionHandler {

    @ExceptionHandler(NoSuchPatientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException(NoSuchPatientException e) {
        log.error("Patient {} does not exist!", e.getPatientId());
    }
}
