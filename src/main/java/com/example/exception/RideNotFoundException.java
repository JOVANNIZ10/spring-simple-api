package com.example.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;

public class RideNotFoundException extends AppException {
    public RideNotFoundException(UUID rideId) {
        super("Ride with ID " + rideId + " not found.", HttpStatus.NOT_FOUND);
    }
    
}
