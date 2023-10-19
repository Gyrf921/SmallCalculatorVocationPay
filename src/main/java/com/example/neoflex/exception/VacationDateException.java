package com.example.neoflex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VacationDateException extends RuntimeException {
    public VacationDateException(String massage) {
        super(massage);
    }
}
