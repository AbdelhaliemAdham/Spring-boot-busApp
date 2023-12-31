package com.example.reservationApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ErrorDetails  {

    private  String message;
    private  int statusCode;
    private  Long timeStamp;
    private  String devMessage;
}
