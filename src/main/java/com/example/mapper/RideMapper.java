package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.dto.RideResponse;
import com.example.model.Ride;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RideMapper {
    private final ModelMapper modelMapper;
    public RideResponse toRideResponse(Ride ride) {
        return modelMapper.map(ride, RideResponse.class);
    }
}