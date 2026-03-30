package com.example.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;

public class NotEnoughSeatsException extends AppException {
    public NotEnoughSeatsException(UUID rideId) {
        super("Ride with ID " + rideId + " does not have enough seats available.", HttpStatus.CONFLICT);
    }
}
