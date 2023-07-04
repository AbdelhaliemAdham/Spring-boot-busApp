package com.example.reservationApp.models;


import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ApiExceptionError.class)
   public ResponseEntity<ErrorDetails> handleApiExcetion(ApiExceptionError exceptionError,WebRequest request){
        final ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(exceptionError.getLocalizedMessage());
        errorDetails.setStatusCode(exceptionError.getStatus().value());
        errorDetails.setDevMessage(request.getDescription(false));
        errorDetails.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AccessDeniedException.class)

   public ResponseEntity<ErrorDetails> handleAccessDeniedExcetion(AccessDeniedException exceptionError,WebRequest request){
        final ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(exceptionError.getLocalizedMessage());
        errorDetails.setDevMessage(request.getDescription(false));
        errorDetails.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorDetails,HttpStatus.UNAUTHORIZED);
    }
        @ExceptionHandler(Exception.class)

   public ResponseEntity<ErrorDetails> handleGlobalExcetion(Exception exceptionError,WebRequest request){
        final ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(exceptionError.getLocalizedMessage());
        errorDetails.setDevMessage(request.getDescription(false));
        errorDetails.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorDetails,HttpStatus.UNAUTHORIZED);
    }
}
