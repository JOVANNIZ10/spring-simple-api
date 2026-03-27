package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exception.RideNotFoundException;
import com.example.model.Ride;
import com.example.repository.RideRepository;

import jakarta.transaction.Transactional;

public class RideService {
    @Autowired
    private RideRepository rideRepository;

    @Transactional
    public void bookSeats(UUID rideId, int seats) {
        Ride ride = rideRepository.findById(rideId)
            .orElseThrow(() -> new RideNotFoundException(rideId));
        
        ride.bookSeats(seats); // modifica el objeto en memoria
        rideRepository.save(ride); // persiste en BD
    }
}
