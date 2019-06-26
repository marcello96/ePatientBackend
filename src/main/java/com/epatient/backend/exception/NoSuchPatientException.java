package com.epatient.backend.exception;

import lombok.Getter;

@Getter
public class NoSuchPatientException extends Exception {

    private long patientId;

    public NoSuchPatientException(long patientId) {
       this.patientId = patientId;
    }
}
