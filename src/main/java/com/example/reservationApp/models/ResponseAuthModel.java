package com.example.reservationApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAuthModel {
    private int statusCode;
    private String message;
    private String tokenString;
    private Long LoginTime;
    private Long expirationTime;
}
