package com.example.exception;

import java.util.UUID;

public class NotEnoughSeatsException extends RuntimeException {
    public NotEnoughSeatsException(UUID rideId) {
        super("Ride with ID " + rideId + " does not have enough seats available.");
    }
}
