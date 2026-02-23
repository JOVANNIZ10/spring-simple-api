package com.example.dto;

import java.time.LocalTime;
import java.util.UUID;

public record BookResponse(
    UUID id,
    boolean status,
    LocalTime time,
    RideResponse ride
) {
    
}
