package com.example.exception;

public class RideAlreadyExistsException extends RuntimeException {
    public RideAlreadyExistsException() {
        super("A ride with the same origin, destination and date already exists");
    }
}
