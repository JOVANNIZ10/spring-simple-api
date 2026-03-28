package com.example.exception;

public class PastRideDateException extends RuntimeException {
    public PastRideDateException() {
        super("Ride date cannot be in the past.");
    }
    
}
