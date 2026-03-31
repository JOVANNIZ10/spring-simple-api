package com.example.dto;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public record CreateBookRequest(
    @NotEmpty UUID userId,
    @NotEmpty UUID rideID,
    @NotEmpty int seatsReserved
){}