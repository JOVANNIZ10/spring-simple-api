package com.example.exception;

import org.springframework.http.HttpStatus;

public class PastRideDateException extends AppException {
    public PastRideDateException() {
        super("Ride date cannot be in the past.", HttpStatus.CONFLICT);
    }
    
}
