package com.example.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;

public class BookAlreadyExistsException extends AppException {
    public BookAlreadyExistsException(UUID rideId, UUID userID) {
        super("Book already exists for Ride ID " + rideId + " and User ID " + userID + ".", HttpStatus.CONFLICT);
    }
    
}
