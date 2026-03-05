package com.example.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID userID) {
        super("User with ID " + userID + " not found.");
    }
    
}
