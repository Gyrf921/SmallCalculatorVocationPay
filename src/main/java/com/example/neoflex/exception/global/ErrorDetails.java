package com.example.neoflex.exception.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private int statusCode;
    private int businessErrorCode;
    private LocalDate timestamp;
    private String message;
    private String details;
}
