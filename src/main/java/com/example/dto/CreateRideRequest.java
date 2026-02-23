package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateRideRequest (
    @NotBlank String origin,
    @NotBlank String destination,
    @NotBlank String dateTime
){}
