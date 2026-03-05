package com.example.dto;

import java.time.LocalDateTime;

import java.util.UUID;

public record RideResponse (
    UUID id,
    String origin,
    String destination,
    LocalDateTime dateTime
) { 
}
