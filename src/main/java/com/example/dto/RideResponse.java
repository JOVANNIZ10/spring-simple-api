package com.example.dto;

import org.hibernate.validator.constraints.UUID;

public record RideResponse (
    UUID id,
    String origin,
    String destination,
    String dateTime
) {
    
}
