package com.example.dto;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public record CreateBookRequest(
    UUID userId,
    UUID rideID,
    @NotEmpty int seatsReserved
){}