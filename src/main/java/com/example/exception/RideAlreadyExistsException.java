package com.example.exception;

import org.springframework.http.HttpStatus;

public class RideAlreadyExistsException extends AppException {
    public RideAlreadyExistsException() {
        super("A ride with the same origin, destination and date already exists", HttpStatus.CONFLICT);
    }
}
