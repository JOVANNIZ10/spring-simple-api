package com.example.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateRideRequest (
    @NotBlank String origin,
    @NotBlank String destination,
    @NotNull LocalDateTime rideDate,
    @NotEmpty int availableSeats,
    UUID userid
){}
