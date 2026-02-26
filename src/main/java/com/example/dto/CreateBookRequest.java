package com.example.dto;
import jakarta.validation.constraints.NotEmpty;

public record CreateBookRequest(
    @NotEmpty int seatsReserved
){}