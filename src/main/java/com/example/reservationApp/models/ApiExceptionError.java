package com.example.reservationApp.models;

import org.springframework.http.HttpStatus;

public class ApiExceptionError extends RuntimeException {

    private final HttpStatus status;
    private final String ErrorMessage;
    public ApiExceptionError(HttpStatus status, String errorMessage) {
        this.status = status;
        ErrorMessage = errorMessage;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public String getErrorMessage() {
        return ErrorMessage;
    } 

    
}
