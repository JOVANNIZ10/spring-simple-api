package com.example.exception;

import java.util.UUID;

public class RideNotFoundException extends RuntimeException {
    public RideNotFoundException(UUID rideId) {
        super("Ride with ID " + rideId + " not found.");
    }
    
}
