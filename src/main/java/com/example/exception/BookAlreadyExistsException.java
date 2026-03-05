package com.example.exception;

import java.util.UUID;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(UUID rideId, UUID userID) {
        super("Book already exists for Ride ID " + rideId + " and User ID " + userID + ".");
    }
    
}
